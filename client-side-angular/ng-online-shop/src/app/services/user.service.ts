import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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
    return false;
  }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.path + "get-users");
  }

  login1(email: string, password: string): Observable<IUser> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append("email",email);
    queryParams = queryParams.append("password",password);

    const uri = this.path + "log-user";
    return this.http.get<IUser>(uri, {params: queryParams});
  }

  getUserName(): string {
    return this.currentUser.userName;
  }

  setUser(user: IUser): void {
    this.currentUser = user;
  }

  signUp(newUser: IUser): Observable<IUser> {
    const uri: string = this.path + 'user-sign-up'; 
    return this.http.post<IUser>(uri,newUser);
  }
}
 