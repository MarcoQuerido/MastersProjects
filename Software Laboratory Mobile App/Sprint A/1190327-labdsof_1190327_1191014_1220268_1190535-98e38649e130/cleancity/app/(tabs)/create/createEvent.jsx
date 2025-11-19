import React, {useEffect, useState} from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  Alert,
  Modal,
  Image,
  ScrollView,
} from "react-native";
import * as ImagePicker from "expo-image-picker";
import {createEvent, getAllEvents} from "../../../lib/appwrite";
import { router } from "expo-router";
import { useGlobalContext } from "../../../context/GlobalProvider";
import * as DocumentPicker from "expo-document-picker";
import {icons} from "../../../constants";
import {getCurrentPositionAsync, requestForegroundPermissionsAsync} from "expo-location";
import {Utils} from "../../Utils";

const CreateEvent = () => {
  const { user } = useGlobalContext();
  const [form, setForm] = useState({
    title: "",
    description: "",
    date: "",
    time: "",
    rewardType: "points", // default reward type
    rewardValue: "",
    badgeImage: null, // Badge image URL
  });

  const [showPreview, setShowPreview] = useState(false);
  const [location, setLocation] = useState(null);
  const [isLocationLoaded, setIsLocationLoaded] = useState(false);

  // Fetch user location
  useEffect(() => {
    (async () => {
      let { status } = await requestForegroundPermissionsAsync();
      if (status !== "granted") {
        Alert.alert("Permission to access location was denied");
        return;
      }

      let location = await getCurrentPositionAsync({});
      setLocation(location);
      setIsLocationLoaded(true);
    })();
  }, []);

  // Validate form fields
  const validateForm = () => {
    const {
      title,
      description,
      date,
      time,
      rewardType,
      rewardValue,
      badgeImage,
    } = form;

    if (!title || !description || !date || !time) {
      Alert.alert("Error", "Please fill out all required fields.");
      return false;
    }

    if (rewardType === "points" && !rewardValue) {
      Alert.alert("Error", "Please specify the points for the reward.");
      return false;
    }

    if (rewardType === "badge" && !badgeImage) {
      Alert.alert("Error", "Please upload a badge image for the reward.");
      return false;
    }

    return true;
  };

  const handleBadgeUpload = async () => {
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      aspect: [4, 3],
      quality: 1,
    });

    if (!result.canceled) {
      setForm((prevForm) => ({
        ...prevForm,
        badge: result.assets[0].uri,
      }));
    }
  };

  // Handle event submission
  const submitEvent = async () => {
    if (
        !form.title ||
        !form.description ||
        !form.date ||
        !form.time ||
        !form.rewardType
    ) {
      return Alert.alert("Error", "Please fill out all fields.");
    }

    try {
      // Fetch all existing events
      const existingEvents = await getAllEvents();

      // Check if there are any events within 50 meters
      const isTooClose = existingEvents.some((event) => {
        const distance = Utils.haversineDistance(
            location.coords.latitude,
            location.coords.longitude,
            event.latitude,
            event.longitude
        );
        return distance < 0.05;
      });

      if (isTooClose) {
        return Alert.alert("Error", "There is already an event created within 50 meters of this location.");
      }

      await createEvent({
        ...form,
        userId: user.$id,
        latitude: location.coords.latitude,
        longitude: location.coords.longitude,
      });

      setShowPreview(false);
      Alert.alert("Success", "Event created successfully!");
      router.push("/home");
    } catch (error) {
      Alert.alert("Error", error.message);
    } finally {
      setForm({
        title: "",
        description: "",
        date: "",
        time: "",
        rewardType: "",
        rewardValue: "",
      });
    }
  };

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
          badgeImage: result.assets[0],
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

  // Open image picker for badge upload
  const selectBadgeImage = async () => {
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      quality: 1,
    });

    if (!result.canceled) {
      setForm({ ...form, badgeImage: result.assets[0].uri });
    }
  };

  // Handle preview display
  const handlePreview = () => {
    if (!validateForm()) return;
    setShowPreview(true);
  };

  if (!isLocationLoaded) {
    return <Text className="text-white">{"Waiting..."}</Text>;
  }

  return (
      <SafeAreaView className="bg-primary h-full">
        <ScrollView contentContainerStyle={{ flexGrow: 1 }}>
          <View className="flex-1 px-4 py-6">
            <Text className="text-2xl text-white font-psemibold mb-6">
              Create an Event
            </Text>

            {/* Event Title */}
            <TextInput
                placeholder="Event Title"
                placeholderTextColor="#ccc"
                value={form.title}
                onChangeText={(text) => setForm({ ...form, title: text })}
                className="bg-black-100 text-white rounded-lg p-4 mb-4"
            />

            {/* Event Description */}
            <TextInput
                placeholder="Description"
                placeholderTextColor="#ccc"
                value={form.description}
                onChangeText={(text) => setForm({ ...form, description: text })}
                className="bg-black-100 text-white rounded-lg p-4 mb-4"
                multiline
            />

            {/* Event Date */}
            <TextInput
                placeholder="Date (YYYY-MM-DD)"
                placeholderTextColor="#ccc"
                value={form.date}
                onChangeText={(text) => setForm({ ...form, date: text })}
                className="bg-black-100 text-white rounded-lg p-4 mb-4"
            />

            {/* Event Time */}
            <TextInput
                placeholder="Time (HH:MM)"
                placeholderTextColor="#ccc"
                value={form.time}
                onChangeText={(text) => setForm({ ...form, time: text })}
                className="bg-black-100 text-white rounded-lg p-4 mb-4"
            />

            {/* Event Location */}

            {/* Reward Type Selection */}
            <View className="flex-row mb-4">
              <TouchableOpacity
                  onPress={() =>
                      setForm({
                        ...form,
                        rewardType: "points",
                        rewardValue: "",
                        badgeImage: null,
                      })
                  }
                  className={`flex-1 py-4 ${
                      form.rewardType === "points" ? "bg-secondary" : "bg-black-100"
                  } rounded-lg mr-2`}
              >
                <Text className="text-white text-center">Points</Text>
              </TouchableOpacity>
              <TouchableOpacity
                  onPress={() =>
                      setForm({
                        ...form,
                        rewardType: "badge",
                        rewardValue: "",
                        badgeImage: null,
                      })
                  }
                  className={`flex-1 py-4 ${
                      form.rewardType === "badge" ? "bg-secondary" : "bg-black-100"
                  } rounded-lg`}
              >
                <Text className="text-white text-center">Badge</Text>
              </TouchableOpacity>
            </View>

            {/* Reward Configuration */}
            {form.rewardType === "points" ? (
                <TextInput
                    placeholder="Enter Points Value"
                    placeholderTextColor="#ccc"
                    value={form.rewardValue}
                    onChangeText={(text) => setForm({ ...form, rewardValue: text })}
                    className="bg-black-100 text-white rounded-lg p-4 mb-6"
                />
            ) : (
                <View className="mt-7 space-y-2">
                  <Text className="text-base text-gray-100 font-pmedium">
                    Badge Image
                  </Text>

                  <TouchableOpacity onPress={() => openPicker("image")}>
                    {form.badgeImage ? (
                        <Image
                            source={{ uri: form.badgeImage.uri }}
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
            )}

            {/* Action Buttons */}
            <View className="flex-row mt-6">
              <TouchableOpacity
                  onPress={handlePreview}
                  className="flex-1 py-4 bg-secondary rounded-lg mr-2"
              >
                <Text className="text-white text-lg font-pmedium text-center">
                  Preview
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                  onPress={submitEvent}
                  className="flex-1 py-4 bg-green-500 rounded-lg"
              >
                <Text className="text-white text-lg font-pmedium text-center">
                  Submit
                </Text>
              </TouchableOpacity>
            </View>
          </View>
        </ScrollView>

        {/* Preview Modal */}
        <Modal visible={showPreview} transparent animationType="slide">
          <View className="bg-black-900 bg-opacity-90 h-full justify-center items-center px-6">
            <View className="bg-primary p-6 rounded-lg w-full">
              <Text className="text-2xl text-white font-psemibold mb-4">
                Preview Event
              </Text>
              <Text className="text-white mb-2">Title: {form.title}</Text>
              <Text className="text-white mb-2">
                Description: {form.description}
              </Text>
              <Text className="text-white mb-2">Date: {form.date}</Text>
              <Text className="text-white mb-2">Time: {form.time}</Text>
              {form.rewardType === "points" ? (
                  <Text className="text-white mb-2">
                    Reward: {form.rewardValue} Points
                  </Text>
              ) : (
                  <>
                    <Text className="text-white mb-2">Reward: Badge</Text>
                    {form.badgeImage && (
                        <Image
                            source={{ uri: form.badgeImage }}
                            className="w-full h-48 rounded-lg"
                            resizeMode="contain"
                        />
                    )}
                  </>
              )}
              <View className="flex-row mt-4">
                <TouchableOpacity
                    onPress={() => setShowPreview(false)}
                    className="flex-1 py-4 bg-secondary rounded-lg mr-2"
                >
                  <Text className="text-white text-center">Edit</Text>
                </TouchableOpacity>
                <TouchableOpacity
                    onPress={submitEvent}
                    className="flex-1 py-4 bg-green-500 rounded-lg"
                >
                  <Text className="text-white text-center">Confirm</Text>
                </TouchableOpacity>
              </View>
            </View>
          </View>
        </Modal>
      </SafeAreaView>
  );
};

export default CreateEvent;
