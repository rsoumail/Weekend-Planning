import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ActivityService } from './activity/activity.service';
import { PlaceService } from './place/place.service';
import { ActivityComponent } from './activity/activity.component';
import { PlaceComponent } from './place/place.component';

 import {
   SharedModule,
   LoginService,
   AuthServerProvider,
   AccountService,
   StateStorageService,
   Principal,
   EventManager,
   UserRouteAccessService,
   LoginComponent,
   HasAnyAuthorityDirective,
//   SharedLibsModule,
//   LoginComponent,
//   //UserRouteAccessService
 } from './shared';

import { SharedLibsModule } from './shared/shared-libs.module'
// import { AuthServerProvider } from './shared/auth/auth-session.service';
// import { AccountService } from './shared/auth/account.service';
// import { StateStorageService } from './shared/auth/state-storage.service';
// import { Principal } from './shared/auth/principal.service';
// import { LoginComponent } from './shared/login/login.component'
//  //import { LoginService } from './shared';
// import { EventManager } from './shared/event-manager.service';
// import { HasAnyAuthorityDirective } from './shared/auth/has-any-authority.directive';
// import { UserRouteAccessService } from './shared/auth/user-route-access-service';

//import { LoginComponent } from './shared/login/login.component'

import {
  LayoutsModule,
  FooterComponent,
  HeaderComponent,
  NavbarComponent,
} from './layouts';

import {
  AccountModule,
  RegisterComponent
} from './account';


// import { NotificationService } from './notification/notification.service'
import { NotificationComponent } from './notification/notification.component';
import { appRouting } from './app.routing';



@NgModule({
  imports: [
    appRouting,
    SharedLibsModule,
    BrowserModule,
  //  SharedModule,
    LayoutsModule,
    AccountModule,
    HttpClientModule,
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    ActivityComponent,
    PlaceComponent,
    NavbarComponent,
    NotificationComponent,
  ],
  providers: [
    ActivityService,
    PlaceService,
    LoginService,
    Principal,
    AccountService,
    AuthServerProvider,
    //UserRouteAccessService
  ],

  schemas: [NO_ERRORS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule {}
