import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginInfo: any;
  success: boolean;

  constructor(private loginService: LoginService) { }

  ngOnInit() {

  	this.success = false;
  	this.loginInfo = {};

  }

  login(){

  	this.loginService.login(this.loginInfo).subscribe(() => {
  		/* TO DO */
  	}, () => {
  		/* TO DO */
  	});

  }

}
