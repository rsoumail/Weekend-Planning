import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
// import {
//   SharedLibsModule,
//   AuthServerProvider,
//   AccountService,
//   UserService,
//   StateStorageService,
//   LoginService,
//   Principal,
//   HasAnyAuthorityDirective,
//   LoginComponent,
//   UserRouteAccessService,
//   EventManager
// } from './';

import { SharedLibsModule } from './shared-libs.module'
import { AuthServerProvider } from './auth/auth-session.service';
import { AccountService } from './auth/account.service';
import { StateStorageService } from './auth/state-storage.service';
import { Principal } from './auth/principal.service';
import { LoginComponent } from './login/login.component'
import { LoginService } from './login/login.service';
import { EventManager } from './event-manager.service';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import { UserRouteAccessService } from './auth/user-route-access-service';


@NgModule({
  imports: [
    SharedLibsModule,
  ],

  declarations: [
    LoginComponent,
    HasAnyAuthorityDirective
  ],

  providers: [
    LoginService,
    AccountService,
    StateStorageService,
    Principal,
    AuthServerProvider,
    EventManager,
    UserRouteAccessService,
    AuthServerProvider,
  ],
  exports: [
        SharedLibsModule,
        LoginComponent,
        HasAnyAuthorityDirective,
    ],
  entryComponents: [LoginComponent],

  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }
