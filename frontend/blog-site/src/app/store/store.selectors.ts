import { createSelector, createFeatureSelector } from '@ngrx/store';
import { User } from '../models/User';

export const selectUser = createFeatureSelector<User>('user');
