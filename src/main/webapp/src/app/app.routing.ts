import {RegisterComponent } from './account';
import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ActivityComponent} from './activity/activity.component';
import {PlaceComponent} from './place/place.component';
import { LoginComponent } from './shared';


const appRoutes: Routes = [
 {
   path: 'register',
   component: RegisterComponent
 },
 {
   path: '',
   component: LoginComponent
 },
 {
   path: 'lieu',
   component: PlaceComponent
 },
 {path: 'activity', component: ActivityComponent},
];

export const appRouting: ModuleWithProviders = RouterModule.forRoot(appRoutes);