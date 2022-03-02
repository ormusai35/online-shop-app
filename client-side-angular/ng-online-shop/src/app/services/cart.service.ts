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

  updateCart(cart:any, product:any, quantity: any) {

    let queryParams = new HttpParams();
    queryParams = queryParams.append("cartId",cart);
    queryParams = queryParams.append("quantity",quantity);

    const uri = HTTP_URI + "update-cart";
    return this.http.put<IProduct>(uri, product, {params: queryParams});
  }

  getOrCreateCart(userId: number) :Observable<ICart>{
    return this.http.get<ICart>(HTTP_URI + `get-cart-by-user/${userId}`);
  }

  getCartId(userId: number) {
    let cartId = sessionStorage.getItem('cartId');
    if(!cartId){
      this.getOrCreateCart(userId).subscribe(data => {
        sessionStorage.setItem('cartId',data.cartId.toString())
      },
      error=> {
        console.log(error);
      })
    }
  }

 addProductToCart(product: IProduct, userId: number) { 
  let cartId = sessionStorage.getItem('cartId'); 
  if(cartId){
    this.updateCart(parseInt(cartId),product,1).subscribe(
      data => {
        console.log(data)
      },
      error => {
        console.log(error)
      }
      )
  }
    
    
  }
}
  

