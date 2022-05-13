import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AUTHENTICATE_USER, HTTP_URI } from '../constants/app.constants';
import { IUser } from '../models/IUser.interface';
import { filter, map } from 'rxjs/operators'; 
import { CartService } from './cart.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser: IUser = {
    id: 0,
    userName: "",
    email: "",
    password: "",
    isAdmin: false
  }

  admins = new Set<string>(["ormusai@gmail.com"]);

  constructor(public cartService:CartService, public http: HttpClient) { }

  isUserLogin(): boolean {
    return (sessionStorage.getItem(AUTHENTICATE_USER) != null);
  }

  isUserAdmin(): boolean {
    return this.currentUser.isAdmin;
  }

  resetUser() {
    this.currentUser = {
      id: 0,
      userName: "",
      email: "",
      password: "",
      isAdmin: false
    }
    this.cartService.resetCurrentCart();
  }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(HTTP_URI + "get-users");
  }

  login(email: string, password: string): Observable<IUser> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append("email",email);
    queryParams = queryParams.append("password",password);

    const uri = HTTP_URI + "log-user";
    return this.http.get<IUser>(uri, {params: queryParams});
  }

  getUserName(): string {
    return this.currentUser.userName;
  }

  getUser(): IUser {
    return this.currentUser;
  }

  setUser(user: IUser): void {
    this.currentUser = user;
  }

  signUp(newUser: IUser): Observable<IUser> {
    this.checkAdmin(newUser);
    const uri: string = HTTP_URI + 'user-sign-up'; 
    return this.http.post<IUser>(uri,newUser);
  }

  checkAdmin(newUser: IUser) :void{
    if(this.admins.has(newUser.email)) newUser.isAdmin = true;
  } 
}

 
 