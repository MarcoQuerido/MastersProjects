import pandas as pd
import os

os.chdir('C:\\Users\\marko\\OneDrive\\Desktop\\ISEP\\2oAno\\Dissertação\\Datasets\\Copernicus_Portugal\\2024')

dataset_name = '2024_cmems_obs-oc_atl_bgc-plankton_myint_l4-multi-1km_P1M'
final_txt = dataset_name + '.txt'
output_file = dataset_name + ".csv"

# Adjust 'delimiter' if the file uses a different separator
df = pd.read_csv(final_txt, delimiter=',')
df.to_csv(output_file, index=False)

print('Finished')
