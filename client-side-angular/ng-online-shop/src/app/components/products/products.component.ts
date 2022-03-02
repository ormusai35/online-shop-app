import { Component, OnInit } from '@angular/core';
import { IProduct } from 'src/app/models/IProduct.interface';
import { CartService } from 'src/app/services/cart.service';
import { ProductsService } from 'src/app/services/products.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  
  products: IProduct[] = [];
  filteredProducts: IProduct[] = [];
  currentCartId:number;

  ngOnInit(): void {
    this.productsService.getAllProducts().subscribe(
      data => this.filteredProducts = this.products = data
    );
    if(this.userService.getUser().id > 0){
      this.cartService.getCartId(this.userService.getUser().id);
    }
    
  }

  constructor(private productsService: ProductsService,
              private cartService:CartService,
              private userService:UserService) { 
    
  }

  filterByCategory(category: string){
    this.filteredProducts = (category != 'ALL') ? this.products.filter(p => p.category === category)
    : this.products;
  }

}
