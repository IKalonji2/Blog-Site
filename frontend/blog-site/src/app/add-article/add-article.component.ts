import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ArticleModel } from '../models/articleModel';
import { ArticleService } from '../services/article.service';

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

  constructor(private articleService: ArticleService) {}

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

    this.articleService.postNewArticle(this.article).subscribe(
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
}
