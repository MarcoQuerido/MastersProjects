import { IProductCategory } from 'app/shared/model/product-category.model';

export interface IProduct {
  id?: number;
  name?: string;
  barcode?: string;
  description?: string | null;
  price?: number;
  stockCurrent?: number;
  stockCritical?: number;
  productCategory?: IProductCategory | null;
}

export const defaultValue: Readonly<IProduct> = {};
