import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

import { Router } from '@angular/router';
import { IUser } from 'src/app/models/IUser.interface';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  sigunUpUser:IUser = {
    id:-1,
    userName:'',
    email:'',
    password:'',
    isAdmin:false
  }

  invalidLogin:boolean = true;

  message:string = "";

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit(): void {
    this.invalidLogin = true;
  }

  signUp(){
    this.userService.signUp(this.sigunUpUser).subscribe(
      data => {
        if (data != null){
          this.invalidLogin = true;
          this.router.navigate(['']);
        }
        else {
          this.invalidLogin = false;
        }
      },
      error => {
        console.log(error)
        if(error.error.text){
          window.alert(error.error.text);
        } else {
          window.alert(error.error.errors[0].defaultMessage);
        }
        
      }
    );
  }

}
