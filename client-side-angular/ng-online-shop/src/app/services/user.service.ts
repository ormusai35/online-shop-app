import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../components/login/IUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public http: HttpClient) { }

  isUserLoginIn(): boolean {
    return false;
  }

  // getUsers(): Observable<IUser[]> {
  //   return this.http.get<Iuser[]>()
  // }

  getMes() :Observable<{mes: string}> {
    return this.http.get<{mes: string}>("http://localhost:8081/test");
  }
}
