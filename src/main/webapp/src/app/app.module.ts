import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {ActivityComponent} from './activity/activity.component';
import {PlaceComponent} from './place/place.component';
import {SharedModule, LoginComponent} from './shared';
import {LayoutsModule, FooterComponent, HeaderComponent} from './layouts';
import {AccountModule, RegisterComponent} from './account';
import { appRouting } from './app.routing';
// import { DashboardComponent } from './dashboard/dashboard.component';



const appRoutes: Routes = [
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'activities', component: ActivityComponent
  }
];


@NgModule({
  imports: [
    appRouting,
    BrowserModule,
    FormsModule,
    LayoutsModule,
    AccountModule,
    SharedModule,
  ],
  declarations: [
    AppComponent,
    // DashboardComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    ActivityComponent,
    PlaceComponent
  ],
  providers: [],

  schemas: [NO_ERRORS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule {}
