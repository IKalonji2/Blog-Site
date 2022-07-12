import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { selectUser } from '../../store/store.selectors';

@Component({
  selector: 'app-view-article',
  templateUrl: './view-article.component.html',
  styleUrls: ['./view-article.component.css'],
})
export class ViewArticleComponent implements OnInit {
  @Input()
  expectedProp!: { title: string; date: string; component: string };
  constructor(private router: ActivatedRoute, private route: ActivatedRoute, 
    private store: Store,) {}

  author: string = '';
  content: string = '';
  ngOnInit(): void {
    this.getUser()
  }

  async getUser(): Promise<void> {
    let shop = this.store.pipe(select(selectUser));
    shop.subscribe((s) => {
      if (!s) {
        return;
      } else {
        this.author = s.username;
        console.log('user', s);
      }
    });
  }
}