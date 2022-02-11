import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from '../models/IProduct.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private path: string = "http://localhost:8081/";

  constructor(private http:HttpClient){}

  getAllProducts(): Observable<IProduct[]>{
    let uri: string = this.path + "products";
    return this.http.get<IProduct[]>(uri);
  }
}
