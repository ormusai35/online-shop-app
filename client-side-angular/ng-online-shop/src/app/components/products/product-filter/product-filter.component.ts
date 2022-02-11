import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-product-filter',
  templateUrl: './product-filter.component.html',
  styleUrls: ['./product-filter.component.css']
})
export class ProductFilterComponent implements OnInit {

  @Output() categoryFilter: EventEmitter<string> = new EventEmitter<string>();

  categories: string[] = ["ALL","COATS & JACKETS","JEANS","SHIRTS"];

  onPushType(category: string) {
    this.categoryFilter.emit(category);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
