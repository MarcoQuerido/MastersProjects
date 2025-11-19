export interface IAddress {
  id?: number;
  city?: string;
  municipality?: string;
  firstLine?: string;
  secondLine?: string | null;
  postalCode?: string | null;
  notes?: string | null;
}

export const defaultValue: Readonly<IAddress> = {};
