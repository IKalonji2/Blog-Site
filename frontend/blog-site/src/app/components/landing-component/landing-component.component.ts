import {
  Component,
  OnInit
} from '@angular/core';

import {
  ArticleData
} from 'src/app/articleCardMockData';

import {
  CategoryOptions
} from 'src/app/categoryMockData';

@Component({
  selector: 'app-landing-component',
  templateUrl: './landing-component.component.html',
  styleUrls: ['./landing-component.component.css']
})
export class LandingComponentComponent implements OnInit {

  article= ArticleData;

  category= CategoryOptions;

  constructor() { }

  ngOnInit(): void {
  }

}
