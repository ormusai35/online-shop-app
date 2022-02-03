import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../models/IUser.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private path: string = "http://localhost:8081/";

  currentUser: IUser = {
    id: 456,
    userName: "hadas",
    email: "hadas@gmail.com",
    password: "AAAA",
    isAdmin: false
  }

  constructor(public http: HttpClient) { }

  isUserLoginIn(): boolean {
    return true;
  }

  // getUsers(): Observable<IUser[]> {
  //   return this.http.get<Iuser[]>()
  // }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.path + "get-users");
  }

  getUserName(): string {
    return this.currentUser.userName;
  }

  setUserName(user: IUser): void {
    this.currentUser = user;
  }
}
