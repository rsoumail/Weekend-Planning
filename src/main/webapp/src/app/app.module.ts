import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { SharedModule, LoginComponent } from './shared';
import { LayoutsModule, FooterComponent} from './layouts';
import { AccountModule, RegisterComponent } from './account';
// import { DashboardComponent } from './dashboard/dashboard.component';



const appRoutes:Routes = [
  {
    path: 'register',
    component: RegisterComponent
  },
  // {
  //   path: 'dashboard',
  //   component: DashboardComponent
  // }
]


@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
  //  LayoutsModule,
    AccountModule
  ],
  declarations: [
    AppComponent,
    // DashboardComponent,
    //LoginComponent,
   FooterComponent
  ],
  providers: [],

  schemas: [NO_ERRORS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
