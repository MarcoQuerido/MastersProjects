import React, { useEffect, useState, useRef } from "react";
import { Text, View, Modal, Button, TouchableOpacity, Alert, StyleSheet, ScrollView, RefreshControl } from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import MapView, { Marker } from "react-native-maps";
import { requestForegroundPermissionsAsync, getCurrentPositionAsync } from "expo-location";
import SearchEvents from "../../components/SearchEvents";
import { getAllReportPosts, getAllEvents, joinEvent, hasUserJoinedEvent } from "../../lib/appwrite";
import { icons } from "../../constants";
import { useRouter } from "expo-router";
import { useGlobalContext } from "../../context/GlobalProvider";
import { Utils } from "../Utils";

const Location = () => {
    const [location, setLocation] = useState(null);
    const [pollutionReports, setPollutionReports] = useState([]);
    const [events, setEvents] = useState([]);
    const [isLocationLoaded, setIsLocationLoaded] = useState(false);
    const [areReportsLoaded, setAreReportsLoaded] = useState(false);
    const [areEventsLoaded, setAreEventsLoaded] = useState(false);
    const [selectedReport, setSelectedReport] = useState(null);
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [distanceToReport, setDistanceToReport] = useState(null);
    const [refreshing, setRefreshing] = useState(false);
    const mapRef = useRef(null);
    const router = useRouter();
    const { user } = useGlobalContext();

    const fetchLocation = async () => {
        let { status } = await requestForegroundPermissionsAsync();
        if (status !== "granted") {
            Alert.alert("Permission to access location was denied");
            return;
        }

        let location = await getCurrentPositionAsync({});
        setLocation(location);
        setIsLocationLoaded(true);
    };

    const fetchPollutionReports = async () => {
        try {
            const response = await getAllReportPosts();
            const validReports = response.filter(
                (report) =>
                    report.latitude &&
                    report.longitude &&
                    typeof report.latitude === "number" &&
                    typeof report.longitude === "number"
            );
            setPollutionReports(validReports);
            setAreReportsLoaded(true);
        } catch (error) {
            console.error("Error fetching pollution reports:", error);
        }
    };

    const fetchEvents = async () => {
        try {
            const response = await getAllEvents();
            const validEvents = response.filter(
                (event) =>
                    event.latitude &&
                    event.longitude &&
                    typeof event.latitude === "number" &&
                    typeof event.longitude === "number"
            );

            // Check if the user has already joined each event
            const eventsWithJoinStatus = await Promise.all(
                validEvents.map(async (event) => {
                    const hasUserAlreadyJoinedEvent = await hasUserJoinedEvent(event.$id, user.$id);
                    return { ...event, hasUserAlreadyJoinedEvent };
                })
            );

            setEvents(eventsWithJoinStatus);
            setAreEventsLoaded(true);
        } catch (error) {
            console.error("Error fetching events:", error);
        }
    };

    useEffect(() => {
        fetchLocation();
        fetchPollutionReports();
        fetchEvents();
    }, []);

    const onRefresh = async () => {
        setRefreshing(true);
        await fetchLocation();
        await fetchPollutionReports();
        await fetchEvents();
        setRefreshing(false);
    };

    const handlePollutionMarkerPress = (report) => {
        setSelectedReport(report);
        if (location && report) {
            const distance = Utils.haversineDistance(
                location.coords.latitude,
                location.coords.longitude,
                report.latitude,
                report.longitude
            );
            setDistanceToReport(distance);
        }
        setIsModalVisible(true);
    };

    const handleJoinEvent = async (event) => {
        if (event.hasUserAlreadyJoinedEvent) {
            Alert.alert("Error", "You have already joined this Event!");
        } else {
            try {
                await joinEvent(event.$id, user.$id);
                Alert.alert("Success", "You have joined the event");
                // Update the event's join status locally
                setEvents((prevEvents) =>
                    prevEvents.map((e) =>
                        e.$id === event.$id ? { ...e, hasUserAlreadyJoinedEvent: true } : e
                    )
                );
            } catch (error) {
                Alert.alert("Error", error.message);
            }
        }
    };

    const handleEventMarkerPress = (event) => {
        Alert.alert(
            "Join Event?",
            `Event: ${event.title}\nDescription: ${event.description}`,
            [
                {
                    text: "Yes",
                    onPress: () => handleJoinEvent(event),
                },
                { text: "No", onPress: () => {} },
            ]
        );
    };

    const handleCollectTrash = () => {
        if (selectedReport && location) {
            const distance = Utils.haversineDistance(
                location.coords.latitude,
                location.coords.longitude,
                selectedReport.latitude,
                selectedReport.longitude
            );

            if (distance > 0.05) {
                Alert.alert(
                    "You are too far!",
                    `You are ${distance.toFixed(1)} km away from this pollution report. Get closer to collect trash.`,
                    [{ text: "OK" }]
                );
            } else {
                router.push({
                    pathname: "create/createCollectionReport",
                    params: {
                        reportTitle: selectedReport.title || "",
                        reportDescription: selectedReport.prompt || "",
                        reportLatitude: selectedReport.latitude,
                        reportLongitude: selectedReport.longitude,
                        reportDistance: distance,
                        reportImage: selectedReport.thumbnail,
                        reportVideo: selectedReport.video,
                        reportId: selectedReport.$id,
                    },
                });
            }
        }
        setIsModalVisible(false);
    };

    const centerMapOnLocation = () => {
        if (mapRef.current && location) {
            mapRef.current.animateToRegion(
                {
                    latitude: location.coords.latitude,
                    longitude: location.coords.longitude,
                    latitudeDelta: 0.0922,
                    longitudeDelta: 0.0421,
                },
                1000
            );
        }
    };

    if (!isLocationLoaded || !areReportsLoaded || !areEventsLoaded) {
        return <Text className="text-white">{"Waiting..."}</Text>;
    }

    return (
        <SafeAreaView className="flex-1 px-4 pt-10 bg-primary">
            <ScrollView
                contentContainerStyle={{ flexGrow: 1 }}
                refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} />}
            >
                <SearchEvents />
                <Text className="text-2xl text-white font-psemibold mt-4">Your Current Location</Text>
                <View className="mt-4 flex-1 rounded-lg overflow-hidden">
                    <MapView
                        ref={mapRef}
                        style={{ flex: 1 }}
                        initialRegion={{
                            latitude: location.coords.latitude,
                            longitude: location.coords.longitude,
                            latitudeDelta: 0.0922,
                            longitudeDelta: 0.0421,
                        }}
                    >
                        <Marker
                            coordinate={{
                                latitude: location.coords.latitude,
                                longitude: location.coords.longitude,
                            }}
                            title="You are here"
                            zIndex={1000}
                            image={icons.pin}
                        />

                        {pollutionReports.map((report, index) => {
                            const isSameLocation =
                                Math.abs(report.latitude - location.coords.latitude) < 0.000005 &&
                                Math.abs(report.longitude - location.coords.longitude) < 0.000005;

                            return (
                                <Marker
                                    key={index}
                                    coordinate={{
                                        latitude: isSameLocation ? report.latitude + 0.00003 : report.latitude,
                                        longitude: report.longitude,
                                    }}
                                    title={`Pollution Report: ${report.title || "No Title"}`}
                                    description={report.prompt || "No Description"}
                                    pinColor="blue"
                                    image={icons.plasticMap}
                                    onPress={() => handlePollutionMarkerPress(report)}
                                />
                            );
                        })}

                        {events.map((event, index) => {
                            const isSameLocation =
                                Math.abs(event.latitude - location.coords.latitude) < 0.000005 &&
                                Math.abs(event.longitude - location.coords.longitude) < 0.000005;

                            return (
                                <Marker
                                    key={index}
                                    coordinate={{
                                        latitude: isSameLocation ? event.latitude - 0.00003 : event.latitude,
                                        longitude: event.longitude,
                                    }}
                                    title={`Event: ${event.title || "No Title"}`}
                                    description={event.description || "No Description"}
                                    pinColor="green"
                                    image={icons.handshakeMap}
                                    onPress={() => handleEventMarkerPress(event)}
                                />
                            );
                        })}
                    </MapView>
                </View>

                <TouchableOpacity style={styles.centerButton} onPress={centerMapOnLocation}>
                    <Text style={styles.centerButtonText}>Center</Text>
                </TouchableOpacity>

                {selectedReport && (
                    <Modal
                        animationType="slide"
                        transparent={true}
                        visible={isModalVisible}
                        onRequestClose={() => setIsModalVisible(false)}
                    >
                        <View style={styles.modalOverlay}>
                            <View style={styles.modalContent}>
                                <Text className="text-xl font-semibold mb-4">Initiate Trash Collection?</Text>
                                <Text className="text-sm mb-4">
                                    You are {distanceToReport ? distanceToReport.toFixed(1) : 0} km away from the report.
                                </Text>
                                <Button title="Yes" onPress={handleCollectTrash} />
                                <Button
                                    title="Cancel"
                                    onPress={() => setIsModalVisible(false)}
                                    color="gray"
                                    style={{ marginTop: 10 }}
                                />
                            </View>
                        </View>
                    </Modal>
                )}
            </ScrollView>
        </SafeAreaView>
    );
};

const styles = StyleSheet.create({
    centerButton: {
        position: "absolute",
        bottom: 20,
        right: 20,
        backgroundColor: "red",
        padding: 10,
        borderRadius: 50,
        alignItems: "center",
        justifyContent: "center",
    },
    centerButtonText: {
        color: "white",
        fontSize: 16,
    },
    modalOverlay: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "rgba(0,0,0,0.5)",
    },
    modalContent: {
        width: 300,
        padding: 20,
        backgroundColor: "white",
        borderRadius: 10,
        alignItems: "center",
    },
});

export default Location;
