import { Injectable } from '@angular/core';
import { IProduct } from '../models/IProduct.interface';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  addProductToCart(product: IProduct) {
    
  }

  constructor() { }
}
