import { ArticleModel } from './../models/articleModel';
import { createSelector, createFeatureSelector } from '@ngrx/store';
import { User, UserTokens } from '../models/User';

export const selectArticle = createFeatureSelector<ArticleModel>('article');

export const selectUser = createFeatureSelector<User>('user');

export const selectUserToken = createFeatureSelector<UserTokens>('token')
