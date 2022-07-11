import {
  Component,
  OnInit,
  Input,
} from '@angular/core';

import {
  ArticleModel
} from 'src/app/models/articleModel';

import {
  CategoryOptions
} from 'src/app/categoryMockData';

@Component({
  selector: 'app-article-card',
  templateUrl: './article-card.component.html',
  styleUrls: ['./article-card.component.css']
})
export class ArticleCardComponent implements OnInit {

  @Input() article : ArticleModel = {

    //TOD: remove - ts.config
    author: "",
    category: CategoryOptions[0],
    content:"",
    date: "",
    title: "",
  };

  constructor() { }

  ngOnInit(): void {
  }

}
