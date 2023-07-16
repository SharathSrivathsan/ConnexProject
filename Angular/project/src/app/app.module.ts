import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { InsuranceFormComponent } from './insurance-form/insurance-form.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { InsuranceFormService } from './insurance-form/insurance-form.service';

@NgModule({
  declarations: [
    AppComponent,
    InsuranceFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
    ]),
  ],
  providers: [
    HttpClient, 
    InsuranceFormService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
