import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { select, Store } from '@ngrx/store';
import { ArticleModel } from '../models/articleModel';
import { ArticleService } from '../services/article.service';
import { selectUser, selectUserToken } from '../store/store.selectors';


@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css'],
})
export class AddArticleComponent implements OnInit {
  article: ArticleModel = {
    title: '',
    category: {

      name: '',
    },
    date: '',
    content: '',
    author: '',
  };

  categories: string[] = [];

  titleControl = new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(50)])
  categoryControl = new FormControl('', [Validators.required])
  contentControl = new FormControl('', [Validators.required, Validators.maxLength(250)])

  constructor(private articleService: ArticleService,
    private store: Store) {}

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories() {
    this.articleService.getCategories().subscribe(
      (data) => {
        let response: any = data;

        if (response.result == 'Ok') {
          this.categories = response.data;
        } else {
          this.categories.push('Error getting categories');
        }
      },
      (error) => {
        console.log(error);
        this.categories.push('Error getting categories');
      }
    );
  }

  submitArticle(): void {
    this.article.date = new Date().toDateString();

    //get user from user service and assign value to article.author
    const token = this.getToken();

    if (token == ""){
      alert('There was an obtaining your token');
      return;
    }


    this.articleService.postNewArticle(this.article, token).subscribe(
      (data) => {
        let postArticleResponse: any = data;
        let result = postArticleResponse.result;
        if ((result = 'Ok')) {
          alert('Article successfully posted');
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
        console.log('token', s);
        return s.access_token
      }
    });
    return "";
  }

}
