import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from '../models/IProduct.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private path: string = "http://localhost:8081/";

  categories: string[] = ["ALL","COATS & JACKETS","JEANS","SHIRTS"];

  constructor(private http:HttpClient){}

  getCategories() :string[] {
    return this.categories;
  }

  getAllProducts(): Observable<IProduct[]>{
    let uri: string = this.path + "products";
    return this.http.get<IProduct[]>(uri);
  }

  updateProduct(product: IProduct): Observable<IProduct>{
    let uri = this.path + "update-product";
    return this.http.put<IProduct>(uri, product);
  }

  createProduct(product: IProduct): Observable<IProduct>{
    let uri = this.path + "insert-new-product";
    return this.http.post<IProduct>(uri, product);
  }

  getProduct(id: string) {
    let uri = this.path + `get-product/${id}`;
    return this.http.get<IProduct>(uri);
  }

}
