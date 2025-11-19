export interface IPerson {
  id?: number;
  firstName?: string;
  lastName?: string;
  idNumber?: string;
  email?: string;
  phone1?: string;
  phone2?: string;
}

export const defaultValue: Readonly<IPerson> = {};
