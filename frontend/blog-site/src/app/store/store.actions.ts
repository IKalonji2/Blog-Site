import { createAction, props } from '@ngrx/store';
import { User, UserTokens } from '../models/User';

export const userLoggedIn = createAction('[NavBar Component] User');

export const userStore = createAction(
  '[User API] Fetch API Success',
  props<{ user: User }>()
);

export const userTokenStore = createAction(
  '[User token] Success',
  props<{ token: UserTokens }>()
);