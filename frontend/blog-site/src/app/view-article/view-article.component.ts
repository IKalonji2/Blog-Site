import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-article',
  templateUrl: './view-article.component.html',
  styleUrls: ['./view-article.component.css'],
})
export class ViewArticleComponent implements OnInit {
  @Input()
  expectedProp!: { title: string; date: string; component: string };
  constructor(private router: ActivatedRoute, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.router.queryParams.subscribe((res) => {
      console.log(JSON.stringify(res));
    });
    this.route.queryParamMap
  .subscribe((params) => {
    const orderObj = { ...params.keys, ...params };
    console.log(orderObj)
  }
);
  }
}
