import {
  CategoryModel
} from './categoryModel';

export interface ArticleModel {
  title:string,
  category: CategoryModel,
  author: string,
  date: string
  content: string
};
