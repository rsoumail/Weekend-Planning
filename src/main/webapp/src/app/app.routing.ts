import { RegisterComponent } from './account';
import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActivityComponent } from './activity/activity.component';
import { PlaceComponent } from './place/place.component';
import { NotificationComponent } from './notification/notification.component';
import { LoginComponent } from './shared/login/login.component';


const appRoutes: Routes = [
 {
   path: 'inscription',
   component: RegisterComponent
 },
 {
   path: '',
   component: LoginComponent,
   data: {
       authorities: [],
       pageTitle: 'Connexion'
   }
 },
 {
   path: 'mes_lieux',
   component: PlaceComponent
 },
 {
   path: 'mes_sports',
   component: ActivityComponent
 },
 {
   path: 'mes_notifications',
   component: NotificationComponent
 },
];

export const appRouting: ModuleWithProviders = RouterModule.forRoot(appRoutes);
