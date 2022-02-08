import { Component, OnInit } from '@angular/core';
// import { UsersserviceService } from 'src/app/Services/usersservice.service';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authUser = {
    email:'',
    password:''
  }

  invalidLogin:boolean = true;

  constructor(public userService: UserService, private router:Router) {
   }

  ngOnInit(): void {
    this.invalidLogin = true;
  }

  loginBt(){
    this.userService.login(this.authUser.email,this.authUser.password).subscribe(
      data => {
        if (data != null) {
          this.userService.setUser(data);
          sessionStorage.setItem('authenticaterUser',data.userName);
          this.invalidLogin = true;
          this.router.navigate(['']);
        } 
        else this.invalidLogin = false;
      }
    );
  }
}
