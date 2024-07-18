import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '89daafe9-986c-445c-9104-d691ee3432a2',
};

export const sampleWithPartialData: IAuthority = {
  name: '43cc0cca-71f1-46f4-9bdf-af87e422b800',
};

export const sampleWithFullData: IAuthority = {
  name: 'c05322c1-1f2f-4fe6-9c90-02d17082187e',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
