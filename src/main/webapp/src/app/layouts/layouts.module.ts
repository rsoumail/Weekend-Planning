import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { LayoutsRoutingModule } from './layouts-routing.module';
import { SharedLibsModule } from '../shared'
// import { NavbarComponent } from './navbar/navbar.component';
// import { FooterComponent } from './footer/footer.component';
// import { HeaderComponent } from './header/header.component';

@NgModule({
  imports: [
    SharedLibsModule,
    LayoutsRoutingModule,
  ],
  // declarations: [FooterComponent, HeaderComponent],
  schemas: [NO_ERRORS_SCHEMA],
  // declarations: [NavbarComponent]
})
export class LayoutsModule { }
