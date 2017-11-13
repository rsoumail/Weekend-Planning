import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from './login.service';
//import { StateStorageService } from '../auth/state-storage.service';
import { EventManager } from '../event-manager.service'

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

  constructor(
    private loginService: LoginService,
    //private stateStorageService: StateStorageService,
    private router: Router,
    //private eventManager: EventManager
  ) {
    this.credentials = {};
   }

   ngOnInit() {
   }

   login() {


  this.loginService.login({
            username: this.username,
            password: this.password,
            // rememberMe: this.rememberMe
        }).then(() => {
            this.authenticationError = false;
            // this.activeModal.dismiss('login success');
            if (this.router.url === '/inscription' || (/^\/activate\//.test(this.router.url)) ||
                (/^\/reset\//.test(this.router.url))) {
                this.router.navigate(['']);
            }
            this.router.navigate(['mes_lieux']);

            // this.eventManager.broadcast({
            //     name: 'authenticationSuccess',
            //     content: 'Sending Authentication Success'
            // });

            // previousState was set in the authExpiredInterceptor before being redirected to login modal.
            // since login is succesful, go to stored previousState and clear previousState
            //  const redirect = this.stateStorageService.getUrl();
            //  if (redirect) {
            //      this.stateStorageService.storeUrl(null);
            //      this.router.navigate([redirect]);
            //  }

        }).catch(() => {
            this.authenticationError = true;
        });
}
  cancel() {
        this.credentials = {
            username: null,
            password: null,
        };
        this.authenticationError = false;
        // this.activeModal.dismiss('cancel');
    }

    register(){}

}
