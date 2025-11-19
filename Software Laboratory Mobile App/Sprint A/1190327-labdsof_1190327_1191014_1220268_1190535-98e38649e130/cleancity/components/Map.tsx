import React from "react";
import { View, StyleSheet } from "react-native";
import MapView, { PROVIDER_DEFAULT } from "react-native-maps";

const INITIAL_REGION = {
  latitude: 39.39,
  longitude: -8.22,
  latitudeDelta: 2,
  longitudeDelta: 2,
};

const Map = () => {
  return (
    //<View style={styles.container}>
    <View style={{ flex: 1 }}>
      <MapView
        provider={PROVIDER_DEFAULT}
        style={styles.map}
        // style={StyleSheet.absoluteFill}
        showsUserLocation
        showsMyLocationButton
        initialRegion={INITIAL_REGION}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1, // Ensures the parent container fills available space
    alignItems: "center", // Centers the map horizontally
    justifyContent: "flex-start", // Centers the map vertically if needed
  },
  map: {
    width: "100%", // Full width
    height: "100%", // Half of the container's height
    borderRadius: 12, // Optional: Rounds the edges of the map
  },
});

export default Map;
