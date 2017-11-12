import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CookieModule } from 'ngx-cookie';

@NgModule({
    imports: [
        NgbModule.forRoot(),
        CookieModule.forRoot()
    ],
    exports: [
        FormsModule,
        HttpModule,
        CommonModule,
        NgbModule
    ]
})
export class SharedLibsModule {}
