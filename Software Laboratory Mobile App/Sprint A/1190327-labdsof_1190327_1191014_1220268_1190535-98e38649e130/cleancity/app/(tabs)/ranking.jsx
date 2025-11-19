import React, { useEffect, useState } from "react";
import { Text, View, FlatList, StyleSheet, ActivityIndicator, SafeAreaView, Image, RefreshControl } from "react-native";
import { getRanking } from "../../lib/appwrite";
import { TouchableOpacity } from "react-native-gesture-handler";
import { useRouter } from "expo-router";
import icons from "../../constants/icons";

const Ranking = () => {
    const [rankingData, setRankingData] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    const [refreshing, setRefreshing] = useState(false);
    const [error, setError] = useState(null);
    const router = useRouter();

    // Fetch Ranking data
    const fetchRanking = async () => {
        try {
            setIsLoading(true);
            const response = await getRanking();
            setRankingData(response);
        } catch (err) {
            console.error("Error fetching ranking data:", err);
            setError("Failed to load ranking.");
        } finally {
            setIsLoading(false);
        }
    };

    useEffect(() => {
        fetchRanking();
    }, []);

    const onRefresh = async () => {
        setRefreshing(true);
        await fetchRanking();
        setRefreshing(false);
    };

    // Function to render ranking items
    const renderRankingItem = ({ item, index }) => (
        <View style={[styles.item, index % 2 === 0 ? styles.itemEven : styles.itemOdd]}>
            <Text style={styles.rank}>#{index + 1}</Text>
            {index === 0 && <Image source={icons.firstRank} style={styles.rankIcon} />}
            {index === 1 && <Image source={icons.secondRank} style={styles.rankIcon} />}
            {index === 2 && <Image source={icons.thirdRank} style={styles.rankIcon} />}
            <View style={styles.userDetails}>
                <Text style={styles.username}>{item.username || "Anonymous"}</Text>
                <Text style={styles.score}>{item.points} Points</Text>
            </View>
        </View>
    );

    if (isLoading) {
        return (
            <SafeAreaView style={styles.container}>
                <ActivityIndicator size="large" color="blue" />
                <Text style={styles.loadingText}>Loading Ranking...</Text>
            </SafeAreaView>
        );
    }

    if (error) {
        return (
            <SafeAreaView style={styles.container}>
                <Text style={styles.errorText}>{error}</Text>
                <TouchableOpacity onPress={() => setError(null)}>
                    <Text style={styles.retryText}>Retry</Text>
                </TouchableOpacity>
            </SafeAreaView>
        );
    }

    return (
        <SafeAreaView style={styles.container}>
            <Text style={styles.title}>Ranking</Text>
            <FlatList
                data={rankingData}
                keyExtractor={(item, index) => item.id ? item.id.toString() : index.toString()}
                renderItem={renderRankingItem}
                contentContainerStyle={styles.list}
                refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} />}
            />
        </SafeAreaView>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#161622",
        paddingHorizontal: 16,
        paddingVertical: 20,
    },
    title: {
        fontSize: 24,
        fontWeight: "bold",
        color: "white",
        textAlign: "center",
        marginBottom: 20,
    },
    loadingText: {
        marginTop: 10,
        fontSize: 16,
        color: "gray",
        textAlign: "center",
    },
    errorText: {
        color: "red",
        fontSize: 16,
        textAlign: "center",
        marginBottom: 10,
    },
    retryText: {
        color: "blue",
        fontSize: 16,
        textAlign: "center",
    },
    list: {
        paddingBottom: 20,
    },
    item: {
        flexDirection: "row",
        alignItems: "center",
        padding: 16,
        borderRadius: 8,
        marginVertical: 5,
    },
    itemEven: {
        backgroundColor: "#2A2A2A",
    },
    itemOdd: {
        backgroundColor: "#333333",
    },
    rank: {
        fontSize: 20,
        fontWeight: "bold",
        color: "gold",
        marginRight: 12,
    },
    rankIcon: {
        width: 24,
        height: 24,
        marginRight: 8,
    },
    userDetails: {
        flex: 1,
    },
    username: {
        fontSize: 18,
        fontWeight: "600",
        color: "white",
    },
    score: {
        fontSize: 14,
        color: "gray",
    },
});

export default Ranking;
