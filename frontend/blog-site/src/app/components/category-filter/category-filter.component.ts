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

  constructor() { }

  ngOnInit(): void {
  }

}
