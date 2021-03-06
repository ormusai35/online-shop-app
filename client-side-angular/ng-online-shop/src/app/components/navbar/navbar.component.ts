import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public userService:UserService, private router:Router) { 
  }

  logout() {
    sessionStorage.clear();
    this.userService.resetUser();
    this.router.navigate(['']);
  }

  ngOnInit(): void {
  }

}
