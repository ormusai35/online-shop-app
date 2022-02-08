import { Component, OnInit } from '@angular/core';
import { IProduct } from 'src/app/models/IProduct.interface';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  
  products: IProduct[] = [];
  filteredProducts: IProduct[] = [];

  ngOnInit(): void {
  }

  constructor(private productsService: ProductsService) { 
    // productsService.getAll().subscribe(
    //   data => this.filteredProducts = this.products = data
    // );
  }
 

  // filterByCategory(category){
  //   this.filteredProducts = (category != 'All') ? this.products.filter(p => p.category === category)
  //   : this.products;
  // }

}
