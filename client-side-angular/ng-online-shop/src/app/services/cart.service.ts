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

  private getOrCreateCart(userId: number) :Observable<ICart>{
    return this.http.get<ICart>(HTTP_URI + `get-cart-by-user/${userId}`);
  }

  private getCartId(userId: number) {
    let cartId = sessionStorage.getItem('cartId');
    if (!cartId) {
        this.getOrCreateCart(userId).subscribe(data => {
          cartId = data.id;
        },
        error=> {
          console.log(error);
        })
    } 
    return cartId;
  }

  // getItem(cartId:any, productId:any) :Observable<IProduct{
  //   return this.http.get<IProduct>(HTTP_URI + `cart/${productId}`);
  // }

  updateCart(cartId:any, productId:any, quantity: any) {

    let queryParams = new HttpParams();
    queryParams = queryParams.append("cartId",cartId);
    queryParams = queryParams.append("productId",productId);
    queryParams = queryParams.append("quantity",quantity);

    const uri = HTTP_URI + `update-cart/${productId}`;
    return this.http.put<IProduct>(uri, {params: queryParams});
  }

 addProductToCart(product: IProduct, userId: number) {
    let cartId = this.getCartId(userId);
    // let itemId = this.getItem(cartId, product.id);
    if(cartId) this.updateCart(cartId,product.id,1);
    else console.log("empty cart id")
  }
}
  

