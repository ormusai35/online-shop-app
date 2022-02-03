import { Component, OnInit } from '@angular/core';
import { IUser } from '../../models/IUser.interface';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  users: IUser[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
      this.userService.getUsers().subscribe(data => {
        this.users = data;
      })
  }

}
