import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http'
import { ArticleModel } from '../models/articleModel';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  URL:string = environment.article_endpoint

  postArticle:string = '/article/new';
  AllArticles:string = '/article/all';
  ArticleByCategory:string = '/article/by-category/';
  ArticleByAuthor:string = '/article/author/';
  Categories:string = "/categories"

  categoriesList: string[] = [];

  constructor(private http: HttpClient) { }

  postNewArticle(article: ArticleModel) {
    return this.http.post(this.URL+this.postArticle, article)
  }

  getAllArticles() {
    return this.http.get(this.URL+this.AllArticles)
  }

  getArticleByCategory(category:string) {
    return this.http.get(this.URL+this.ArticleByCategory+`/${category}`)
  }

  getArticleByAuthor(author:string) {
    return this.http.get(this.URL+this.ArticleByAuthor+`/${author}`)
  }

  getCategories() {
    return this.http.get(this.URL+this.Categories)
  }
}
