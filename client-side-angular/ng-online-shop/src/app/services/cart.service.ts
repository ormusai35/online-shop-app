import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HTTP_URI } from '../constants/app.constants';
import { ICart } from '../models/ICart.interface';

@Injectable({
  providedIn: 'root'
})
export class CartService {

private currentCart:ICart = {
    cartId: 0,
    user:{
          id:0,
          userName:"",
          email:"",
          password:"",
          isAdmin:false
        },
    cartLines:[],
    total:0
  }

  constructor(public http: HttpClient) { }

  isCartExists() :boolean{
    if(this.currentCart.cartId != 0) return true;
    else return false; 
  }

  getCurrentCart() :ICart{
    return this.currentCart;
  }

  setCurrentCart(currentCart: ICart) {
    this.currentCart = currentCart;
  }

  resetCurrentCart() {
    this.currentCart = {
      cartId: 0,
      user:{
            id:0,
            userName:"",
            email:"",
            password:"",
            isAdmin:false
          },
      cartLines:[],
      total:0
    }
  }

  updateCart(cart:ICart, productId:number, quantity: number) {

    let queryParams = new HttpParams();
    queryParams = queryParams.append("cartId",cart.cartId);
    queryParams = queryParams.append("productId",productId);
    queryParams = queryParams.append("quantity",quantity);

    const uri = HTTP_URI + "update-cart";
    return this.http.put<ICart>(uri,cart, {params: queryParams});
  }

  getOrCreateCart(userId: number) :Observable<ICart>{
    return this.http.get<ICart>(HTTP_URI + `get-cart-by-user/${userId}`);
  }

  getCartId(userId: number) {
    let cartId = sessionStorage.getItem('cartId');
    if(!cartId){
      this.getOrCreateCart(userId).subscribe(data => {
        sessionStorage.setItem('cartId',data.cartId.toString())
      })
    }
  }

 addProductToCart(productId: number) { 
   console.log("1",this.currentCart)
    if(this.isCartExists()) this.updateCart(this.currentCart,productId,1).subscribe(
      data => {
        console.log(data)
        this.currentCart = data

      }
    )
 }
}
  

