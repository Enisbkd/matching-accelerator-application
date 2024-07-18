import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 8401,
  login: '~@5ur3\\Jimjn',
};

export const sampleWithPartialData: IUser = {
  id: 24406,
  login: 'K@DCLRn4',
};

export const sampleWithFullData: IUser = {
  id: 29718,
  login: '`5g|{*@Pb\\L2ZB7\\3EekVk\\7WD\\paQy1Nz',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
