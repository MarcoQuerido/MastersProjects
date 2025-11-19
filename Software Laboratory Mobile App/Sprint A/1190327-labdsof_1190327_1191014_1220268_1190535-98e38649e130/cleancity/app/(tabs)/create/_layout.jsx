import { Stack } from "expo-router";

const CreateLayout = () => {
  return (
    <Stack
      screenOptions={{
        headerShown: false,
        contentStyle: { backgroundColor: "#161622" },
      }}
    />
  );
};

export default CreateLayout;
