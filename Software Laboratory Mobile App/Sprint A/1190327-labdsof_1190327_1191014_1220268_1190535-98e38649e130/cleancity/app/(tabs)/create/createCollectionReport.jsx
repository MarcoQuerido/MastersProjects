import { useState } from "react";
import { router, useLocalSearchParams } from "expo-router";
import { ResizeMode, Video } from "expo-av";
import * as DocumentPicker from "expo-document-picker";
import { SafeAreaView } from "react-native-safe-area-context";
import {
  View,
  Text,
  Alert,
  Image,
  TouchableOpacity,
  ScrollView,
} from "react-native";
import { icons } from "../../../constants";
import {
  createCollectionPost,
  getCollectionWithSpecificReport
} from "../../../lib/appwrite";
import { CustomButton, FormField } from "../../../components";
import { useGlobalContext } from "../../../context/GlobalProvider";
import MapView, { Marker } from "react-native-maps";
import AWS from "aws-sdk";
import base64 from "base64-js";

const CreateCollectionReport = () => {
  const { user } = useGlobalContext();
  const { reportTitle, reportDescription, reportLatitude, reportLongitude, reportDistance , reportImage, reportVideo, reportId } = useLocalSearchParams();
  const [uploading, setUploading] = useState(false);

  const [form, setForm] = useState({
    title: "",
    video: null,
    thumbnail: null,
    prompt: "",
  });

  const openPicker = async (selectType) => {
    const result = await DocumentPicker.getDocumentAsync({
      type:
          selectType === "image"
              ? ["image/png", "image/jpg"]
              : ["video/mp4", "video/gif"],
    });

    if (!result.canceled) {
      if (selectType === "image") {
        setForm({
          ...form,
          thumbnail: result.assets[0],
        });
      }

      if (selectType === "video") {
        setForm({
          ...form,
          video: result.assets[0],
        });
      }
    } else {
      setTimeout(() => {
        Alert.alert("Document picked", JSON.stringify(result, null, 2));
      }, 100);
    }
  };

  const detectGarbage = async (imageUri) => {
    const rekognition = new AWS.Rekognition({
      region: 'eu-west-2',
      accessKeyId: '',
      secretAccessKey: '',
    });

    const base64Image = await fetch(imageUri)
        .then(res => res.blob())
        .then(blob => new Promise((resolve, reject) => {
          const reader = new FileReader();
          reader.onloadend = () => resolve(reader.result.split(',')[1]);
          reader.onerror = reject;
          reader.readAsDataURL(blob);
        }));

    const byteArray = base64.toByteArray(base64Image);

    const params = {
      Image: {
        Bytes: byteArray,
      },
      MaxLabels: 10,
      MinConfidence: 75,
    };

    const result = await rekognition.detectLabels(params).promise();
    const labels = result.Labels;
    return labels.some(label => label.Name.toLowerCase().includes('garbage'));
  };

  const submit = async () => {
    if (
        !form.thumbnail ||
        !form.video
    ) {
      return Alert.alert("Please provide all fields");
    }

    setUploading(true);
    try {
      const isGarbage = await detectGarbage(form.thumbnail.uri);
      if (!isGarbage) {
        Alert.alert("Error", "The image does not contain garbage.");
        setUploading(false);
        return;
      }

      const existingCollection = await getCollectionWithSpecificReport(reportId);

      if (existingCollection.length > 0) {
        Alert.alert(
            "Duplicate Report",
            "A collection regarding this report already exists."
        );
        router.push("/home");
      }

      await createCollectionPost({
        ...form,
        userId: user.$id,
        reportId: reportId,
      });

      Alert.alert("Success", "Trash collection report uploaded successfully");
      router.push("/home");
    } catch (error) {
      Alert.alert("Error", error.message);
    } finally {
      setForm({
        title: "",
        video: null,
        thumbnail: null,
        prompt: "",
      });

      setUploading(false);
    }
  };

  return (
      <SafeAreaView className="bg-primary h-full">
        <ScrollView className="px-4 my-6">
          <Text className="text-2xl text-white font-psemibold">
            Upload Trash Collection Report
          </Text>

          <View className="mt-6 space-y-2 bg-black-100 px-4 py-3 rounded-xl">
            <Text className="text-base text-gray-100 font-pmedium">
              <Text className="font-bold">Pollution Report Title:</Text> {reportTitle}
            </Text>

            {reportDescription && (
                <Text className="text-base text-gray-100 font-pmedium">
                  <Text className="font-bold">Description:</Text> {reportDescription}
                </Text>
            )}

            <Text className="text-base text-gray-100 font-pmedium">
              <Text className="font-bold">You are {reportDistance ? (reportDistance * 1000).toFixed(0) : 0} meters away from the report</Text>
            </Text>
          </View>

          {reportLatitude && reportLongitude && (
              <View className="mt-6 space-y-2">
                <Text className="text-lg text-white font-semibold">Pollution Report Location</Text>
                <View style={{ height: 200, borderRadius: 12, overflow: 'hidden' }}>
                  <MapView
                      style={{ flex: 1 }}
                      initialRegion={{
                        latitude: parseFloat(reportLatitude),
                        longitude: parseFloat(reportLongitude),
                        latitudeDelta: 0.003,
                        longitudeDelta: 0.003,
                      }}
                      zoomEnabled={false}
                      scrollEnabled={false}
                      pitchEnabled={false}
                      rotateEnabled={false}
                  >
                    <Marker
                        coordinate={{
                          latitude: parseFloat(reportLatitude),
                          longitude: parseFloat(reportLongitude),
                        }}
                        title="Pollution Report"
                        description="This is the pollution report location"
                    />
                  </MapView>
                </View>
              </View>
          )}

          <View className="mt-7 space-y-2">
            <Text className="text-base text-gray-100 font-pmedium">
              Upload Trash Collection Video
            </Text>

            <TouchableOpacity onPress={() => openPicker("video")}>
              {form.video ? (
                  <Video
                      source={{ uri: form.video.uri }}
                      className="w-full h-64 rounded-2xl"
                      useNativeControls
                      resizeMode={ResizeMode.COVER}
                      isLooping
                  />
              ) : (
                  <View className="w-full h-40 px-4 bg-black-100 rounded-2xl border border-black-200 flex justify-center items-center">
                    <View className="w-14 h-14 border border-dashed border-secondary-100 flex justify-center items-center">
                      <Image
                          source={icons.upload}
                          resizeMode="contain"
                          alt="upload"
                          className="w-1/2 h-1/2"
                      />
                    </View>
                  </View>
              )}
            </TouchableOpacity>
          </View>

          <View className="mt-7 space-y-2">
            <Text className="text-base text-gray-100 font-pmedium">
              Cleaned Location Image
            </Text>

            <TouchableOpacity onPress={() => openPicker("image")}>
              {form.thumbnail ? (
                  <Image
                      source={{ uri: form.thumbnail.uri }}
                      resizeMode="cover"
                      className="w-full h-64 rounded-2xl"
                  />
              ) : (
                  <View className="w-full h-16 px-4 bg-black-100 rounded-2xl border-2 border-black-200 flex justify-center items-center flex-row space-x-2">
                    <Image
                        source={icons.upload}
                        resizeMode="contain"
                        alt="upload"
                        className="w-5 h-5"
                    />
                    <Text className="text-sm text-gray-100 font-pmedium">
                      Choose a file
                    </Text>
                  </View>
              )}
            </TouchableOpacity>
          </View>

          <CustomButton
              title="Submit & Publish"
              handlePress={submit}
              containerStyles="mt-7"
              isLoading={uploading}
          />
        </ScrollView>
      </SafeAreaView>
  );
};

export default CreateCollectionReport;
