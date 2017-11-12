import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  // CSRFService,
  // AuthServerProvider,
  // AccountService,
  // UserService,
  // StateStorageService,
  // LoginService,
  //  Principal,
  //  HasAnyAuthorityDirective,
  LoginComponent
} from './';

import { AuthServerProvider } from './auth/auth-session.service';
import { AccountService } from './auth/account.service';
import { StateStorageService } from './auth/state-storage.service';
import { Principal } from './auth/principal.service';
import { LoginService } from './login/login.service';
@NgModule({
  imports: [
    CommonModule,
  ],

  declarations: [
    //        HasAnyAuthorityDirective
  ],

  // declarations: []
  providers: [
    LoginService,
    AccountService,
    StateStorageService,
    Principal,
    // CSRFService,
    AuthServerProvider,
    // UserService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }
