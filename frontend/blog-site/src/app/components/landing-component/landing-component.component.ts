import {
  Component,
  OnInit
} from '@angular/core';

import {
  ArticleData
} from '../../articleCardMockData';

import {
  CategoryOptions
} from '../../categoryMockData';

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
