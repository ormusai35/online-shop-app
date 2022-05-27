
import { Component, OnInit } from '@angular/core';
import { ICart } from 'src/app/models/ICart.interface';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  constructor(public cartService:CartService, private userService:UserService) { }

  ngOnInit(): void {
    
    this.cartService.getOrCreateCart(this.userService.getUser().id).subscribe(
      data => {
        this.cartService.setCurrentCart(data);
      }
    );
    
    setTimeout(()=>{ 
      console.log(this.userService.getUser().id);
      console.log(this.cartService.getCurrentCart())
    },5000);
  }
}
