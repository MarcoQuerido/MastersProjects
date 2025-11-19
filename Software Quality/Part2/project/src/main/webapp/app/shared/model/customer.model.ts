import { IPerson } from 'app/shared/model/person.model';

export interface ICustomer {
  id?: number;
  person?: IPerson;
}

export const defaultValue: Readonly<ICustomer> = {};
