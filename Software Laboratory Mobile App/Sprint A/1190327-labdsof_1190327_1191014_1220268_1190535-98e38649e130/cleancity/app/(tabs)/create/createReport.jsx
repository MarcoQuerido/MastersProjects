import { useState, useEffect } from "react";
import { router } from "expo-router";
import { ResizeMode, Video } from "expo-av";
import * as DocumentPicker from "expo-document-picker";
import { SafeAreaView } from "react-native-safe-area-context";
import { requestForegroundPermissionsAsync, getCurrentPositionAsync } from "expo-location";
import {
  View,
  Text,
  Alert,
  Image,
  TouchableOpacity,
  ScrollView,
} from "react-native";

import { icons } from "../../../constants";
import { createReportPost, updateUserPoints } from "../../../lib/appwrite";
import { CustomButton, FormField } from "../../../components";
import { useGlobalContext } from "../../../context/GlobalProvider";
import AWS from "aws-sdk";
import base64 from "base64-js";

const Create = () => {
  const { user, setUser } = useGlobalContext();
  const [uploading, setUploading] = useState(false);
  const [form, setForm] = useState({
    title: "",
    video: null,
    thumbnail: null,
    prompt: "",
    latitude: "",
    longitude: "",
  });

  useEffect(() => {
    (async () => {
      let { status } = await requestForegroundPermissionsAsync();
      if (status !== "granted") {
        Alert.alert("Permission to access location was denied");
        return;
      }

      let location = await getCurrentPositionAsync({});
      setForm((prevForm) => ({
        ...prevForm,
        latitude: location.coords.latitude.toString(),
        longitude: location.coords.longitude.toString(),
      }));
    })();
  }, []);

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
        form.prompt === "" ||
        form.title === "" ||
        !form.thumbnail ||
        !form.video ||
        form.latitude === "" ||
        form.longitude === ""
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

      await createReportPost({
        ...form,
        userId: user.$id,
        latitude: parseFloat(form.latitude),
        longitude: parseFloat(form.longitude),
      });

      // Award 50 points to the user
      const newPoints = (user.points || 0) + 50;
      await updateUserPoints(user.$id, newPoints);
      setUser({ ...user, points: newPoints });

      Alert.alert("Success", "Post uploaded successfully and you earned 50 points!");
      router.push("/home");
    } catch (error) {
      Alert.alert("Error", error.message);
    } finally {
      setForm({
        title: "",
        video: null,
        thumbnail: null,
        prompt: "",
        latitude: "",
        longitude: "",
      });

      setUploading(false);
    }
  };

  return (
      <SafeAreaView className="bg-primary h-full">
        <ScrollView className="px-4 my-6">
          <Text className="text-2xl text-white font-psemibold">Upload Pollution Report</Text>

          <FormField
              title="Pollution Report Title"
              value={form.title}
              placeholder="Give your Pollution Report a catchy title..."
              handleChangeText={(e) => setForm({ ...form, title: e })}
              otherStyles="mt-10"
          />

          <View className="mt-7 space-y-2">
            <Text className="text-base text-gray-100 font-pmedium">
              Upload Pollution Report
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
              Thumbnail Image
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

          <FormField
              title="Description"
              value={form.prompt}
              placeholder="The Description of your Pollution Report...."
              handleChangeText={(e) => setForm({ ...form, prompt: e })}
              otherStyles="mt-7"
          />

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

export default Create;
