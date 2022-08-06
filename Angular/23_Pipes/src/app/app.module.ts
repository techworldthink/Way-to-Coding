import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UsdInrPipe } from './pipes/usd-inr.pipe';

@NgModule({
  declarations: [
    AppComponent,
    UsdInrPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
