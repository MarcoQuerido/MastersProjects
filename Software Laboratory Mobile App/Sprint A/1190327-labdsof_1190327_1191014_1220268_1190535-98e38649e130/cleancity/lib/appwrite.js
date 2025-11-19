import {Account, Avatars, Client, Databases, ID, Query, Storage,} from "react-native-appwrite";

export const appwriteConfig = {
  endpoint: "https://cloud.appwrite.io/v1",
  platform: "com.company.cleancity",
  projectId: "6740d8e000019052cfcd",
  storageId: "6740dc530035e0130665",
  databaseId: "6740d9ec001b8a1c4d69",
  userCollectionId: "67422c1f00119ad0c808",
  reportCollectionId: "6740da9500212e555fe1",
  eventCollectionId: "6740db140004a777d812",
  collectionCollectionId: "6740dbc500177c12e5f9",
};

const client = new Client();

client
  .setEndpoint(appwriteConfig.endpoint)
  .setProject(appwriteConfig.projectId)
  .setPlatform(appwriteConfig.platform);

const account = new Account(client);
const storage = new Storage(client);
const avatars = new Avatars(client);
const databases = new Databases(client);

// Register user
export async function createUser(email, password, username) {
  try {
    const newAccount = await account.create(
      ID.unique(),
      email,
      password,
      username
    );

    if (!newAccount) throw Error;

    const avatarUrl = avatars.getInitials(username);

    await signIn(email, password);

    const newUser = await databases.createDocument(
      appwriteConfig.databaseId,
      appwriteConfig.userCollectionId,
      ID.unique(),
      {
        accountId: newAccount.$id,
        email: email,
        username: username,
        avatar: avatarUrl,
      }
    );

    return newUser;
  } catch (error) {
    throw new Error(error);
  }
}

// Sign In
export async function signIn(email, password) {
  try {
    const session = await account.createEmailSession(email, password);

    return session;
  } catch (error) {
    throw new Error(error);
  }
}

// Get Account
export async function getAccount() {
  try {
    const currentAccount = await account.get();

    return currentAccount;
  } catch (error) {
    throw new Error(error);
  }
}

// Get Current User
export async function getCurrentUser() {
  try {
    const currentAccount = await getAccount();
    if (!currentAccount) throw Error;

    const currentUser = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.userCollectionId,
      [Query.equal("accountId", currentAccount.$id)]
    );

    if (!currentUser) throw Error;

    return currentUser.documents[0];
  } catch (error) {
    console.log(error);
    return null;
  }
}

// Sign Out
export async function signOut() {
  try {
    const session = await account.deleteSession("current");

    return session;
  } catch (error) {
    throw new Error(error);
  }
}

// Upload File
export async function uploadFile(file, type) {
  if (!file) return;

  const { mimeType, ...rest } = file;
  const asset = { type: mimeType, ...rest };

  try {
    const uploadedFile = await storage.createFile(
      appwriteConfig.storageId,
      ID.unique(),
      asset
    );

    const fileUrl = await getFilePreview(uploadedFile.$id, type);
    return fileUrl;
  } catch (error) {
    throw new Error(error);
  }
}

// Get File Preview
export async function getFilePreview(fileId, type) {
  let fileUrl;

  try {
    if (type === "video") {
      fileUrl = storage.getFileView(appwriteConfig.storageId, fileId);
    } else if (type === "image") {
      fileUrl = storage.getFilePreview(
        appwriteConfig.storageId,
        fileId,
        2000,
        2000,
        "top",
        100
      );
    } else {
      throw new Error("Invalid file type");
    }

    if (!fileUrl) throw Error;

    return fileUrl;
  } catch (error) {
    throw new Error(error);
  }
}

// Create Report Post
export async function createReportPost(form) {
  try {
    const [thumbnailUrl, videoUrl] = await Promise.all([
      uploadFile(form.thumbnail, "image"),
      uploadFile(form.video, "video"),
    ]);

    const newPost = await databases.createDocument(
        appwriteConfig.databaseId,
        appwriteConfig.reportCollectionId,
        ID.unique(),
        {
          title: form.title,
          thumbnail: thumbnailUrl,
          video: videoUrl,
          prompt: form.prompt,
          creator: form.userId,
          latitude: parseFloat(form.latitude),
          longitude: parseFloat(form.longitude),
        }
    );

    return newPost;
  } catch (error) {
    throw new Error(error);
  }
}

// Get all report Posts
export async function getAllReportPosts() {
  try {
    const posts = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.reportCollectionId
    );

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get report posts created by user
export async function getUserReportPosts(userId) {
  try {
    const posts = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.reportCollectionId,
      [Query.equal("creator", userId)]
    );

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get report posts that matches search query
export async function searchReportPosts(query) {
  try {
    const posts = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.reportCollectionId,
      [Query.search("title", query)]
    );

    if (!posts) throw new Error("Something went wrong");

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get latest created report posts
export async function getLatestReportPosts() {
  try {
    const posts = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.reportCollectionId,
      [Query.orderDesc("$createdAt"), Query.limit(7)]
    );

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Event Creation
export async function createEvent(form) {
  try {
    // For badge upload, we'll need to handle the file upload for the badge image
    let rewardUrl = null;
    if (form.rewardType === "badge" && form.badgeImage) {
      rewardUrl = await uploadFile(form.badgeImage, "image");
      console.log("Badge uploaded:", rewardUrl); // Log the badge upload URL
    }

    // Create the event in the database
    const newEvent = await databases.createDocument(
      appwriteConfig.databaseId,
      appwriteConfig.eventCollectionId,
      ID.unique(),
      {
        title: form.title,
        description: form.description,
        date: form.date,
        rewardType: form.rewardType,
        rewardValue: form.rewardValue,
        badgeImage: rewardUrl,
        creator: form.userId,
        latitude: form.latitude,
        longitude: form.longitude
      }
    );

    console.log("Event Created:", newEvent);
    return newEvent;
  } catch (error) {
    console.error("Error creating event:", error);
    throw new Error(
      "Error creating the event. Please check the console for more details."
    );
  }
}

export const joinEvent = async (eventId, userId) => {
  try {
    const event = await databases.getDocument(appwriteConfig.databaseId, appwriteConfig.eventCollectionId, eventId);
    const updatedUsers = [...event.users, userId];

    // Check if the user is already part of the event
    const userExists = event.users.some(user => user.$id === userId);

    if (userExists) throw new Error("User has already joined this event.");

    await databases.updateDocument(appwriteConfig.databaseId, appwriteConfig.eventCollectionId, eventId, {
      users: updatedUsers,
    });
  } catch (error) {
    throw new Error(error.message);
  }
};

export async function getProfileEvents(userId) {
  try {
    const events = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.eventCollectionId
    );

    const userEvents = events.documents.filter(event =>
        event.users.some(user => user.accountId === userId)
    );

    return userEvents;
  } catch (error) {
    throw new Error(error);
  }
}

export async function getLatestEvents() {
  try {
    const events = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.eventCollectionId,
        [Query.orderDesc("$createdAt"), Query.limit(7)]
    );

    return events.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// View All Events
export async function getAllEvents() {
  try {
    const events = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.eventCollectionId
    );

    return events.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get Events Created by User
export async function getUserEvents(userId) {
  try {
    const events = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.eventCollectionId
    );

    const userEvents = events.documents.filter(event =>
        event.users.includes(userId)
    );

    return userEvents;
  } catch (error) {
    throw new Error(error);
  }
}

// Check if User already joined an Event
export async function hasUserJoinedEvent(eventId, userId) {
  try {
    const userEvents = await getUserEvents(userId);

    return userEvents.some(event => event.$id === eventId);
  } catch (error) {
    throw new Error(error);
  }
}

// Search Events by Query
export async function searchEvents(query) {
  try {
    const events = await databases.listDocuments(
      appwriteConfig.databaseId,
      appwriteConfig.eventCollectionId,
      [Query.search("title", query)]
    );

    if (!events) throw new Error("Something went wrong");

    return events.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Create Collection Post
export async function createCollectionPost(form) {
  try {
    const [thumbnailUrl, videoUrl] = await Promise.all([
      uploadFile(form.thumbnail, "image"),
      uploadFile(form.video, "video"),
    ]);

    const newPost = await databases.createDocument(
        appwriteConfig.databaseId,
        appwriteConfig.collectionCollectionId,
        ID.unique(),
        {
          thumbnail: thumbnailUrl,
          video: videoUrl,
          creator: form.userId,
          report: form.reportId,
        }
    );

    return newPost;
  } catch (error) {
    throw new Error(error);
  }
}

// Get all collection Posts
export async function getAllCollections() {
  try {
    const posts = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.collectionCollectionId
    );

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get collection posts created by user
export async function getUserCollections(userId) {
  try {
    const posts = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.collectionCollectionId,
        [Query.equal("creator", userId)]
    );

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get collection posts that matches search query
export async function searchCollections(query) {
  try {
    const posts = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.collectionCollectionId,
        [Query.search("title", query)]
    );

    if (!posts) throw new Error("Something went wrong");

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get latest created collection posts
export async function getLatestCollections() {
  try {
    const posts = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.collectionCollectionId,
        [Query.orderDesc("$createdAt"), Query.limit(7)]
    );

    return posts.documents;
  } catch (error) {
    throw new Error(error);
  }
}

// Get a Trash Collection Report with the specific Pollution Report ID
export async function getCollectionWithSpecificReport(reportId) {
  try {
    const result = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.collectionCollectionId,
        [Query.equal("report", reportId)] // Query by the specific reportId
    );

    return result.documents;
  } catch (error) {
    console.error("Error checking if collection exists:", error);
    throw new Error("Failed to check if collection exists");
  }
}

// Get ranking
export async function getRanking() {
  try {
    const users = await databases.listDocuments(
        appwriteConfig.databaseId,
        appwriteConfig.userCollectionId,
        [Query.orderDesc("points")]
    );

    return users.documents;
  } catch (error) {
    throw new Error(error);
  }
}

export const updateUserPoints = async (userId, points) => {
  try {
    await databases.updateDocument(
        appwriteConfig.databaseId,
        appwriteConfig.userCollectionId,
        userId, {
      points: points,
    });
  } catch (error) {
    throw new Error('Failed to update user points: ' + error.message);
  }
};
