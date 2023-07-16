import { HttpClient } from '@angular/common/http';
import { Injectable, numberAttribute } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class InsuranceFormService
{
    constructor(private http: HttpClient) { }
    rootURL = 'http://localhost:8080';

    getCars()
    {
        return this.http.get('https://storage.googleapis.com/connex-th/insurance_assignment/car_model.json');
    }
    getQuote(form: FormGroup)
    {
        let response = {};
        return this.http.post<any>(this.rootURL + '/getQuote', form.value);
    }
}