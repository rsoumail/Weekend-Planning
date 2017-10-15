import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegisterComponent} from './register/register.component';
import {RegisterService} from './register/register.service';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpModule
  ],
  declarations: [RegisterComponent],
  providers: [RegisterService],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AccountModule {}
