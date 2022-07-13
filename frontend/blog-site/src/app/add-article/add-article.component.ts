import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { ArticleModel, NewArticleModel } from '../models/articleModel';
import { ArticleService } from '../services/article.service';
import { selectUser, selectUserToken } from '../store/store.selectors';


@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css'],
})
export class AddArticleComponent implements OnInit {
  article: NewArticleModel = {
    title: '',
    category:{
      categoryID: 0,
      categoryName: ''
    },
    time: '',
    body: '',
  };

  categories: NewArticleModel[] = [];
  accessToken: string = '';

  titleControl = new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)])
  categoryControl = new FormControl('', [Validators.required])
  contentControl = new FormControl('', [Validators.required, Validators.maxLength(250)])

  constructor(private articleService: ArticleService,
              private store: Store,
              private router: Router) {}

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories() {
    this.articleService.getCategories().subscribe(
      (data) => {
        let response: any = data;

        //console.log(response)

        if (data) {
          this.categories = response;
        } else {
          this.categories.push({category:{categoryID:-1,categoryName:"error"}} as NewArticleModel);
        }
      },
      (error) => {
        console.log(error);
        this.categories.push({category:{categoryID:-1,categoryName:"error"}} as NewArticleModel);
      }
    );
  }

  submitArticle(): void {
    this.article.time = new Date().toDateString();
    this.getToken();
    
    //get user from user service and assign value to article.author
    const token = this.accessToken;
    if (token == ""){
      alert('There was an error obtaining your token');
      return;
    }


    this.articleService.postNewArticle(this.article, 'token').subscribe(
      (data) => {
        let postArticleResponse: any = data;
        let result = postArticleResponse.result;
        if ((result = 'ok')) {
          alert('Article successfully posted');
          this.router.navigateByUrl('')
        }
      },
      (error) => {
        console.log(error);
        alert('There was an error posting your article');
      }
    );
  }

  getToken(): string{
    let token = this.store.pipe(select(selectUserToken));
    token.subscribe((s) => {
      if (!s) {
        return "";
      } else {
        this.accessToken = s.access_token;
        return s.access_token
      }
    });
    return "";
  }

}
