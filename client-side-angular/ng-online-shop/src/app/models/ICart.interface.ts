import { CartLine } from "./CartLine";
import { IUser } from "./IUser.interface";

export class ICart {
    cartId:number;
    user:IUser;
    cartLines:Array<CartLine>;
    total:number;
}