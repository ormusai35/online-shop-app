import { IProduct } from "./IProduct.interface";


export class CartLine {
    cartLineId:number;
    product:IProduct;
    quantity:number;
}