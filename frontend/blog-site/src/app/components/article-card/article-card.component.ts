import { selectArticle } from './../../store/store.selectors';
import { articleStore } from './../../store/store.actions';
import {
  Component,
  OnInit,
  Input,
} from '@angular/core';

import {
  ArticleModel
} from '../../models/articleModel';

import { select, Store } from '@ngrx/store';

@Component({
  selector: 'app-article-card',
  templateUrl: './article-card.component.html',
  styleUrls: ['./article-card.component.css']
})
export class ArticleCardComponent implements OnInit {

  @Input() article : ArticleModel = {

    //TOD: remove - ts.config
    author: "",
    category: {
      name: "",
    },
    content:"",
    date: "",
    title: "",
  };

  constructor(private store: Store) { }

  ngOnInit(): void {
  }

  showArticle() {
    this.store.dispatch(
      articleStore({ article: this.article })
    );

    let getArticle = this.store.pipe(select(selectArticle));
    getArticle.subscribe((s) => {
      if (!s) {
        return;
      } else {
        console.log('article: ', s);
      }
    });
  }
}
