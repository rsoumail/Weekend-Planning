import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LayoutsRoutingModule } from './layouts-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
// import { FooterComponent } from './footer/footer.component';
// import { HeaderComponent } from './header/header.component';

@NgModule({
  imports: [
    CommonModule,
    LayoutsRoutingModule,
  ],
  //declarations: [FooterComponent, HeaderComponent],
  schemas: [NO_ERRORS_SCHEMA],
  declarations: [NavbarComponent]
})
export class LayoutsModule { }
