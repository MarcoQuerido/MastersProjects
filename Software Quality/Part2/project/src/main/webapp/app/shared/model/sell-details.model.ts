import { IProduct } from 'app/shared/model/product.model';
import { ISell } from 'app/shared/model/sell.model';

export interface ISellDetails {
  id?: number;
  units?: number;
  unitValue?: number;
  description?: string;
  product?: IProduct;
  sell?: ISell;
}

export const defaultValue: Readonly<ISellDetails> = {};
