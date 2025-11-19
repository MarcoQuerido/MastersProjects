import { useState, useEffect, useMemo } from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import { FlatList, Image, RefreshControl, Text, View } from "react-native";

import { images } from "../../constants";
import useAppwrite from "../../lib/useAppwrite";
import { getAllEvents, getAllReportPosts, getLatestEvents, getLatestReportPosts, getLatestCollections } from "../../lib/appwrite";
import { EmptyState, SearchInput, Trending, ReportCard, EventCard } from "../../components";
import { useGlobalContext } from "../../context/GlobalProvider";

const Home = () => {
    const { data: posts, refetch: refetchPosts } = useAppwrite(getAllReportPosts);
    const { data: latestPosts, refetch: refetchLatestPosts } = useAppwrite(getLatestReportPosts);
    const { data: allEvents, refetch: refetchAllEvents } = useAppwrite(getAllEvents);
    const { data: latestEvents, refetch: refetchLatestEvents } = useAppwrite(getLatestEvents);
    const { data: latestCollections, refetch: refetchLatestCollections } = useAppwrite(getLatestCollections);
    const { user } = useGlobalContext();

    const [refreshing, setRefreshing] = useState(false);

    const onRefresh = async () => {
        setRefreshing(true);
        await refetchPosts();
        await refetchLatestPosts();
        await refetchAllEvents();
        await refetchLatestEvents();
        await refetchLatestCollections();
        setRefreshing(false);
    };

    useEffect(() => {
        refetchLatestPosts();
        refetchLatestEvents();
        refetchLatestCollections();
    }, []);

    const listHeaderComponent = useMemo(() => (
        <View className="flex my-6 px-4 space-y-6">
            <View className="flex justify-between items-start flex-row mb-6">
                <View>
                    <Text className="font-pmedium text-sm text-gray-100">
                        Welcome Back to
                    </Text>
                    <Text className="text-2xl font-psemibold text-white">
                        CleanCity
                    </Text>
                </View>

                <View style={{ marginTop: 6 }}>
                    <Image
                        source={images.logoSmall}
                        style={{ width: 36, height: 40 }}
                        resizeMode="contain"
                    />
                </View>
            </View>

            <SearchInput />

            <View className="w-full flex-1 pt-5 pb-8">
                <Text className="text-lg font-pregular text-gray-100 mb-3">
                    Latest Pollution Reports
                </Text>

                <Trending posts={latestPosts ?? []} />
            </View>
            <View className="w-full flex-1 pt-5 pb-8">
                <Text className="text-lg font-pregular text-gray-100 mb-3">
                    Latest Events
                </Text>

                <FlatList
                    data={latestEvents}
                    keyExtractor={(item) => item.$id}
                    renderItem={({ item }) => (
                        <EventCard
                            title={item.title}
                            description={item.description}
                            date={item.date}
                            location={item.location}
                            badge={item.badge}
                            eventId={item.$id}
                            showJoinButton={!item.users.some(u => u.$id === user.$id)}
                        />
                    )}
                />
            </View>
            <View className="w-full flex-1 pt-5 pb-8">
                <Text className="text-lg font-pregular text-gray-100 mb-3">
                    Latest Trash Collections
                </Text>

                <Trending posts={latestCollections ?? []} />
            </View>
            <View className="w-full flex-1 pt-5 pb-8">
                <Text className="text-lg font-pregular text-gray-100 mb-3">
                    Feed - Users Pollution Reports
                </Text>
            </View>
        </View>
    ), [latestPosts, latestEvents, latestCollections, user]);

    return (
        <SafeAreaView className="bg-primary">
            <FlatList
                data={posts}
                keyExtractor={(item) => item.$id}
                renderItem={({ item }) => (
                    <ReportCard
                        title={item.title}
                        thumbnail={item.thumbnail}
                        video={item.video}
                        creator={item.creator.username}
                        avatar={item.creator.avatar}
                    />
                )}
                ListHeaderComponent={listHeaderComponent}
                ListEmptyComponent={() => (
                    <EmptyState
                        title="No Videos Found"
                        subtitle="No videos created yet"
                    />
                )}
                refreshControl={
                    <RefreshControl refreshing={refreshing} onRefresh={onRefresh} />
                }
            />
        </SafeAreaView>
    );
};

export default Home;
