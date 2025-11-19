import { IPerson } from 'app/shared/model/person.model';

export interface ICostumer {
  id?: number;
  person?: IPerson;
}

export const defaultValue: Readonly<ICostumer> = {};
