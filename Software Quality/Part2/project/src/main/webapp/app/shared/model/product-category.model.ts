export interface IProductCategory {
  id?: number;
  code?: string;
  name?: string;
  parent?: IProductCategory | null;
}

export const defaultValue: Readonly<IProductCategory> = {};
