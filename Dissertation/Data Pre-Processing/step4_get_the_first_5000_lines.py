import os

# Set working directory
os.chdir('C:\\Users\\marko\\OneDrive\\Desktop\\ISEP\\2oAno\\Dissertação\\Datasets\\Copernicus_Portugal\\2021')

# Define file names
input_file = "20210101-20210131_cmems_obs-oc_atl_bgc-plankton_my_l4-multi-1km_P1M"
input_file_csv = input_file + '.csv'

output_txt_file = input_file + ".txt"  # Output file name

# Open input and output files
with open(input_file_csv, "r", encoding="utf-8") as infile, open(output_txt_file, "w", encoding="utf-8") as outfile:
    for i, line in enumerate(infile):
        if i < 10819001:  # Skip lines
            continue
        if i >= 10824001:  # Stop after
            break
        outfile.write(line)

print("Lines were saved successfully!")
