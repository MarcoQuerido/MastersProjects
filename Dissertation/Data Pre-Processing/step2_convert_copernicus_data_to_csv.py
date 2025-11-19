import xarray as xr
import os
from pathlib import Path

os.chdir('F:\\Dissertação\\Dataset_Copernicus\\2011')

path = 'F:\\Dissertação\\Dataset_Copernicus\\2011'

for file in os.listdir(path):
    if file.endswith('.nc'):
        dataset_name = Path(file).stem
        dataset_name_nc = dataset_name + '.nc'
        dataset_name_csv = dataset_name + '.csv'

        print(dataset_name)

        # Open the NetCDF dataset
        ds = xr.open_dataset(dataset_name_nc)

        # Convert the dataset to a DataFrame
        df = ds.to_dataframe().reset_index()

        # Save the DataFrame as a CSV file
        # print(f'Converting {dataset_name} to csv...')
        # Remover linhas com valores vazios em qualquer coluna
        df_limpo = df.dropna()

        # Selecionar as primeiras 5000 linhas (ou menos se o ficheiro tiver menos)
        df_limpo = df_limpo.head(5000)

        df_limpo_csv = dataset_name + '_clean.csv'

        # Guardar o resultado num novo CSV
        df_limpo.to_csv(df_limpo_csv, index=False, sep=',')

        output_txt_file = dataset_name + '.txt'

        # Open input and output files
        with open(df_limpo_csv, "r", encoding="utf-8") as infile, open(output_txt_file, "w",
                                                                       encoding="utf-8") as outfile:
            for i, line in enumerate(infile):
                outfile.write(line)
            print(f"File {outfile} written")

        #df.to_csv(dataset_name_csv, index=False)

        print(f"Data saved to {dataset_name_csv}")
