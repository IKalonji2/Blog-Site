import { Component, OnInit, NgModule } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/User';
import { UserService } from '../../services/user/user.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
})
export class NavBarComponent implements OnInit {
  constructor(private userService: UserService) {}

  user: User = {
    username: '',
  };

  ngOnInit(): void {}

  getUser(): void {
    this.userService.getUser().subscribe((user) => {
      this.user = user;
      console.log(user);
    });
  }
}
