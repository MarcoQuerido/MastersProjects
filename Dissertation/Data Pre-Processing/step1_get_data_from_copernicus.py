import copernicusmarine

# To avoid warning messages
import warnings
warnings.filterwarnings('ignore')

DS = copernicusmarine.open_dataset(dataset_id="cmems_obs-oc_atl_bgc-plankton_my_l4-gapfree-multi-1km_P1D")

print(DS)

DS.to_csv("cmems_obs-oc_atl_bgc-plankton_my_l4-gapfree-multi-1km_P1D.csv")
