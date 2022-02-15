import { Component, Input, OnInit } from '@angular/core';
import { IProduct } from 'src/app/models/IProduct.interface';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input() product:IProduct;

  constructor(private cartService: CartService) { }
 
  ngOnInit(): void {
  }

  addToCart(product: IProduct){

    // this.cartService.addProductToCart(product);
    
  }

}
