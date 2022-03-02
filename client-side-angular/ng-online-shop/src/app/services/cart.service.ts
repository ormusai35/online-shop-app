import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HTTP_URI } from '../constants/app.constants';
import { ICart } from '../models/ICart.interface';
import { IProduct } from '../models/IProduct.interface';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(public http: HttpClient) { }

  updateCart(cartId:any, productId:any, quantity: any) {

    let queryParams = new HttpParams();
    queryParams = queryParams.append("cartId",cartId);
    queryParams = queryParams.append("productId",productId);
    queryParams = queryParams.append("quantity",quantity);

    const uri = HTTP_URI + `update-cart/${productId}`;
    return this.http.put<IProduct>(uri, {params: queryParams});
  }

  getOrCreateCart(userId: number) :Observable<ICart>{
    return this.http.get<ICart>(HTTP_URI + `get-cart-by-user/${userId}`);
  }

  getCartId(userId: number) {
    let temp = sessionStorage.getItem('cartId');
    if(!temp){
      this.getOrCreateCart(userId).subscribe(data => {
        sessionStorage.setItem('cartId',data.cartId.toString())
      },
      error=> {
        console.log(error);
      })
    }
  }

 addProductToCart(product: IProduct, userId: number) {
    // let itemId = this.getItem(cartId, product.id);
    // if(cartId) this.updateCart(cartId,product.id,1);
    // else console.log("empty cart id")
  }
}
  

