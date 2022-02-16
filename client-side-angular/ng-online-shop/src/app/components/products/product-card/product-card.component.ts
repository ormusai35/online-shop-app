import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { IProduct } from 'src/app/models/IProduct.interface';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input() product:IProduct;

  constructor(private cartService: CartService, public userService: UserService, private router: Router, private route: ActivatedRoute) { }
 
  ngOnInit(): void {
  }

  addToCart(product: IProduct){

    // this.cartService.addProductToCart(product);
    
  }

  updateProduct(product: IProduct){
    this.router.navigate([`${this.product.id}`] ,{ relativeTo: this.route });
  }

}
