import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import { View, Text, TouchableOpacity } from "react-native";
import { useRouter } from "expo-router";
import { Image } from "react-native";
import icons from "../../../constants/icons";


const CreateMenu = () => {
  const router = useRouter();

  return (
    <SafeAreaView className="bg-primary h-full">
      <View className="flex-1 justify-center items-center px-4">
        <Text className="text-2xl text-white font-psemibold mb-10">
          What would you like to do?
        </Text>

        <TouchableOpacity
          onPress={() => router.push("create/createReport")}
          className="w-full py-4 bg-secondary rounded-lg mb-4 flex justify-center items-center"
        >
          <Image
              source={icons.plastic}
              className="w-6 h-6 mr-2"
          />
          <Text className="text-white text-lg font-pmedium">
            Create a Pollution Report
          </Text>
        </TouchableOpacity>

        <TouchableOpacity
          onPress={() => router.push("create/createEvent")}
          className="w-full py-4 bg-secondary rounded-lg flex justify-center items-center"
        >
          <Image
              source={icons.handshake}
              className="w-6 h-6 mr-2"
          />
          <Text className="text-white text-lg font-pmedium">
            Create an Event
          </Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
};

export default CreateMenu;
