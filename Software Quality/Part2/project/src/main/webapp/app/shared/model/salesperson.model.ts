import { IPerson } from 'app/shared/model/person.model';

export interface ISalesperson {
  id?: number;
  person?: IPerson;
}

export const defaultValue: Readonly<ISalesperson> = {};
