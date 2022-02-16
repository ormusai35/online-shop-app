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
    id: 0,
    userName: "",
    email: "",
    password: "",
    isAdmin: false
  }

  admins = new Set<string>(["ormusai35@gmail.com"]);

  constructor(public http: HttpClient) { }

  isUserLogin(): boolean {
    return (sessionStorage.getItem('authenticaterUser') != null);
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
  }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.path + "get-users");
  }

  login(email: string, password: string): Observable<IUser> {
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
    this.checkAdmin(newUser);
    const uri: string = this.path + 'user-sign-up'; 
    return this.http.post<IUser>(uri,newUser);
  }

  checkAdmin(newUser: IUser) :void{
    if(this.admins.has(newUser.email)) newUser.isAdmin = true;
  } 
}

 
 