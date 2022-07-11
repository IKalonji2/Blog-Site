import { createReducer, on } from '@ngrx/store';
import { userFetchAPISuccess } from './store.actions';
import { User } from '../models/User';

export const userState: User = {
  username: '',
};
 
export const userReducer = createReducer(
    userState,
  on(userFetchAPISuccess, (state, { user }) => {
    return user;
  })
);