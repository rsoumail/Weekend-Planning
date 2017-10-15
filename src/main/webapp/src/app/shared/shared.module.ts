import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginService } from './login/login.service';

@NgModule({
  imports: [
    CommonModule
  ],
  //declarations: []
  providers: [LoginService],
  schemas: [NO_ERRORS_SCHEMA]
})
export class SharedModule { }
