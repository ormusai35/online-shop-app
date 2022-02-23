import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HTTP_URI } from '../components/constants/app.constants';
import { IProduct } from '../models/IProduct.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  categories: string[] = ["ALL","COATS & JACKETS","JEANS","SHIRTS"];

  constructor(private http:HttpClient){}

  getCategories() :string[] {
    return this.categories;
  }

  getAllProducts(): Observable<IProduct[]>{
    let uri: string = HTTP_URI + "products";
    return this.http.get<IProduct[]>(uri);
  }

  updateProduct(product: IProduct): Observable<IProduct>{
    let uri = HTTP_URI + "update-product";
    return this.http.put<IProduct>(uri, product);
  }

  createProduct(product: IProduct): Observable<IProduct>{
    let uri = HTTP_URI + "insert-new-product";
    return this.http.post<IProduct>(uri, product);
  }

  getProduct(id: string) {
    let uri = HTTP_URI + `get-product/${id}`;
    return this.http.get<IProduct>(uri);
  }

}
