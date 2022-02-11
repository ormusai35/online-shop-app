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
    this.productsService.getAllProducts().subscribe(
      data => this.filteredProducts = this.products = data
    );
  }

  constructor(private productsService: ProductsService) { 
    
  }
 

  filterByCategory(category: string){
    this.filteredProducts = (category != 'ALL') ? this.products.filter(p => p.category === category)
    : this.products;
  }

}
