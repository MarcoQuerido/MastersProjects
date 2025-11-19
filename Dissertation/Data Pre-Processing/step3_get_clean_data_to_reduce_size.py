import pandas as pd
import os

# Step 3

# Load the CSV in chunks to handle large file size
os.chdir('C:\\Users\\marko\\OneDrive\\Desktop\\ISEP\\2oAno\\Dissertação\\Datasets\\Copernicus_Portugal\\2025')

csv_name = "20250101-20250131_cmems_obs-oc_atl_bgc-plankton_myint_l4-multi-1km_P1M.csv"
chunk_size = 500000  # Adjust based on memory capacity

# Define threshold for missing data (50%)
threshold = 0.5

# Process chunks and filter data
filtered_chunks = []
for chunk in pd.read_csv(csv_name, chunksize=chunk_size):
    # Calculate the percentage of missing values per row
    missing_percentage = chunk.isnull().mean(axis=1)

    # Keep rows with less than 40% missing values
    chunk_filtered = chunk[missing_percentage < threshold]

    # Append to list
    filtered_chunks.append(chunk_filtered)

# Combine all chunks into a final DataFrame
df_filtered = pd.concat(filtered_chunks, ignore_index=True)

# Save the filtered data to a new CSV file
name = os.path.basename(csv_name).split('.')[0]

filtered_csv_path = name + "_reduced.csv"
df_filtered.to_csv(filtered_csv_path, index=False)

print(f"Filtered data saved to {filtered_csv_path}")
