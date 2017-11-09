import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {AppComponent} from './app.component';
import { ActivityService } from './activity/activity.service';
import {ActivityComponent} from './activity/activity.component';
import {PlaceComponent} from './place/place.component';
import {SharedModule, LoginComponent} from './shared';
import {LayoutsModule, FooterComponent, HeaderComponent, NavbarComponent} from './layouts';
import {AccountModule, RegisterComponent} from './account';


//import { NotificationService } from './notification/notification.service'
import { NotificationComponent } from './notification/notification.component';
import { appRouting } from './app.routing';
// import { DashboardComponent } from './dashboard/dashboard.component';


@NgModule({
  imports: [
    appRouting,
    BrowserModule,
    FormsModule,
    LayoutsModule,
    AccountModule,
    SharedModule,
    HttpClientModule,
    NgbModule.forRoot(),
  ],
  declarations: [
    AppComponent,
    // DashboardComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    ActivityComponent,
    PlaceComponent,
    NavbarComponent,
    NotificationComponent,
  ],
  providers: [ActivityService, /*NotificationService*/],

  schemas: [NO_ERRORS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule {}
