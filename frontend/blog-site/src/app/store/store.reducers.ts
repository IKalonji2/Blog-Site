import { createReducer, on } from '@ngrx/store';
import { userStore, userTokenStore } from './store.actions';
import { User, UserTokens } from '../models/User';

export const userState: User = {
  username: '',
};
 
export const userTokenState: UserTokens = {
  access_token: '',
  expires_in: 0,
  id_token: '',
  refresh_token: '',
  token_type: ''
};

export const userReducer = createReducer(
    userState,
  on(userStore, (state, { user }) => {
    return user;
  })
);

export const userTokenReducer = createReducer(
  userTokenState,
  on(userTokenStore, (state, { token }) => {
    return token;
  })
);