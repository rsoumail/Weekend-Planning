import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {RegisterComponent} from './register/register.component';
import {RegisterService} from './register/register.service';
import { SharedLibsModule } from '../shared'
import {Routes, RouterModule} from '@angular/router';
import {HttpModule } from '@angular/http';
import {FormsModule } from '@angular/forms';
import {CommonModule } from '@angular/common';



@NgModule({
  imports: [
    SharedLibsModule,
    RouterModule,
    CommonModule,
    FormsModule,
    HttpModule
  ],
  declarations: [RegisterComponent],
  providers: [RegisterService],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AccountModule {}
