import { createAction, props } from '@ngrx/store';
import { User } from '../models/User';

export const userLoggedIn = createAction('[NavBar Component] User');

export const userFetchAPISuccess = createAction(
    '[User API] Fetch API Success',
    props<{ user: User }>()
  );