import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http'
import { ArticleModel } from '../models/articleModel';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  URL:string = environment.article_endpoint

  postArticle:string = '/Blog/new';
  AllArticles:string = '/Blog/all';
  ArticleByCategory:string = '/Blog/Category/categoryName';
  ArticleByAuthor:string = '/Blog/User/author';
  Categories:string = "/categories"

  categoriesList: string[] = [];

  constructor(private http: HttpClient) { }

  postNewArticle(
    article: ArticleModel
  ){
    return this.http.post(this.URL+this.postArticle, article)
  }

  getAllArticles(){
    return this.http.get('https://bs-loadbalance-1072678543.af-south-1.elb.amazonaws.com:8081/v1/Blog/all')
  }

  getArticleByCategory(category:string){
    return this.http.get(this.URL+this.ArticleByCategory+`/${category}`)
  }

  getArticleByAuthor(author:string){
    return this.http.get(this.URL+this.ArticleByAuthor+`/${author}`)
  }

  getCategories(){
    return this.http.get(this.URL+this.Categories)
  }

}
