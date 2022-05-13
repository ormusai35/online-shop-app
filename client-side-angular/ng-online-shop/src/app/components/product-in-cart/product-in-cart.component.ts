import { Component, Input, OnInit } from '@angular/core';
import { CartLine } from 'src/app/models/CartLine';

@Component({
  selector: 'app-product-in-cart',
  templateUrl: './product-in-cart.component.html',
  styleUrls: ['./product-in-cart.component.css']
})
export class ProductInCartComponent implements OnInit {

  @Input() cartLine:CartLine;

  constructor() { }

  ngOnInit(): void {
    
  }

}
