import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
    //CSRFService,
    //AuthServerProvider,
    //AccountService,
    //UserService,
    //StateStorageService,
    LoginService,
  //  Principal,
  //  HasAnyAuthorityDirective,
    LoginComponent
   } from './';
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
        // AccountService,
        // StateStorageService,
        // Principal,
        // CSRFService,
        // AuthServerProvider,
        // UserService
      ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }
