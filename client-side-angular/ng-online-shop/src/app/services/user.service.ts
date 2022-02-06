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

  login(email: string, password: string): Observable<IUser> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append("email",email);
    queryParams = queryParams.append("password",password);

    const uri = this.path + "check-user-auth";
    return this.http.get<IUser>(uri, {params: queryParams});
  }

  getUserName(): string {
    return this.currentUser.userName;
  }

  setUser(user: IUser): void {
    this.currentUser = user;
  }

  signUp(newUser: IUser): Observable<IUser> {
    const uri: string = this.path + 'add-user'; 
    return this.http.post<IUser>(uri,newUser);
  }

  getMes(): Observable<{mes: string}> {
    return this.http.get<{mes: string}>("http://localhost:8081/test");
  }
}
 