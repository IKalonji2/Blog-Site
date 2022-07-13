import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http'
import { ArticleModel } from '../article-model';

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

  
  /*
  post article endpoint - /article/new
  body:
  {
    author: 
    date:
    category:
    title:
    content:
  }

  returns
  {
    result:
    data: []
    error:
  }
  */

  postNewArticle(
    article: ArticleModel
  ){
    return this.http.post(this.URL+this.postArticle, article)
  }
  
  /*
  get all article endpoint - /article/all

  returns
  {
    result:
    data: [
      {
        author: 
        date:
        category:
        title:
        content:
      }
    ]
    error:
  }
  */

  getAllArticles(){
    return this.http.get(this.URL+this.AllArticles)
  }

  /*
  get article by category endpoint - /article/by-category/<category>

  returns
  {
    result:
    data: [
      {
        author: 
        date:
        category:
        title:
        content:
      }
    ]
    error:
  }
  */

  getArticleByCategory(category:string){
    return this.http.get(this.URL+this.ArticleByCategory+`/${category}`)
  }
  
  /*
  get article by author endpoint - /article/author/<author>

  returns
  {
    result:
    data: [
      {
        author: 
        date:
        category:
        title:
        content:
      }
    ]
    error:
  }
  */
  getArticleByAuthor(author:string){
    return this.http.get(this.URL+this.ArticleByAuthor+`/${author}`)
  }

  /*
  get categories endpoint - /categories

  returns
  {
    result:
    data: [
      "",""
    ]
    error:
  }
  */
  getCategories(){
    return this.http.get(this.URL+this.Categories)
  }

}
