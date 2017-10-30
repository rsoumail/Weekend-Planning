import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  password: string;
  username: string;
  credentials: any;
  authenticationError: boolean;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.credentials = {};
  }

  login() {
    this.credentials.username = this.username;
    this.credentials.password = this.password;
    this.loginService.login(this.credentials).subscribe(() => {
    //   this.success = true;
  }, (response) => {});
    this.authenticationError = true;
  }

  cancel() {
        this.credentials = {
            username: null,
            password: null,
        };
        this.authenticationError = false;
        //this.activeModal.dismiss('cancel');
    }

}
