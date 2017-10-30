import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginService } from './login/login.service';
@NgModule({
  imports: [
    CommonModule,
  ],
  // declarations: []
  providers: [LoginService],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }
