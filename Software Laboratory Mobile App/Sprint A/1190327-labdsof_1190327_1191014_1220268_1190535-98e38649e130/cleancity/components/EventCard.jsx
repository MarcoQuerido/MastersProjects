// components/EventCard.jsx
import React from "react";
import { View, Text, TouchableOpacity, Alert } from "react-native";
import { useGlobalContext } from "../context/GlobalProvider";
import { joinEvent } from "../lib/appwrite";

const EventCard = ({ title, description, date, location, badge, eventId, showJoinButton }) => {
    const { user } = useGlobalContext();

    const handleJoinEvent = async () => {
        try {
            await joinEvent(eventId, user.$id);
            Alert.alert("Success", "You have joined the event");
        } catch (error) {
            Alert.alert("Error", error.message);
        }
    };

    return (
        <View className="p-4 bg-secondary rounded-lg mb-4">
            {badge && (
                <View className="bg-red-500 rounded-full px-2 py-1 mb-2">
                    <Text className="text-xs text-white">{badge}</Text>
                </View>
            )}
            <Text className="text-lg font-psemibold text-white">{title}</Text>
            <Text className="text-sm text-gray-100">{description}</Text>
            <Text className="text-xs text-gray-100">{date}</Text>
            <Text className="text-xs text-gray-100">{location}</Text>
            {showJoinButton && (
                <TouchableOpacity
                    onPress={handleJoinEvent}
                    className="mt-4 bg-primary rounded-lg py-2"
                >
                    <Text className="text-center text-white font-psemibold">Join Event</Text>
                </TouchableOpacity>
            )}
        </View>
    );
};

export default EventCard;
