import { createReducer, on } from '@ngrx/store';
import { userStore, userTokenStore, articleStore } from './store.actions';
import { User, UserTokens } from '../models/User';
import { ArticleModel } from '../models/articleModel'

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

export const articleState: ArticleModel = {
  author: "",
  category: {
    name: ""
  },
  content:"",
  date: "",
  title: "",
}

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

export const articleReducer = createReducer(
  articleState,
  on(articleStore, (state, { article }) => {
    return article;
  })
);
