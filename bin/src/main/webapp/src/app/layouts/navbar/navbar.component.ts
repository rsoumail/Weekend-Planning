import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  LoginService
} from '../../shared/login/login.service';

import { Principal } from '../../shared';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(
    private loginService: LoginService,
    private router: Router,
    private principal: Principal
  ) { }

  ngOnInit() {
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['']);
  }

  isAuthenticated() {
      return this.principal.isAuthenticated();
  }

}
