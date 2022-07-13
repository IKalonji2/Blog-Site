import {
  ArticleService
} from './../../services/article.service';

import {
  Input,
  OnInit,
  Component,
 } from '@angular/core';

 import {
  CategoryModel
} from 'src/app/models/categoryModel';

@Component({
  selector: 'app-category-filter',
  templateUrl: './category-filter.component.html',
  styleUrls: ['./category-filter.component.css']
})
export class CategoryFilterComponent implements OnInit {

  @Input() category: CategoryModel = {

    name: '',
    color: {
      background: '',
    },
  };

  constructor(private articleService: ArticleService) {
  }

  getArticles() {
    console.log(this.category.name)
  }

  ngOnInit(): void {
  }

}
