import { Component, OnInit, Optional } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { InsuranceFormService } from './insurance-form.service';

@Component({
  selector: 'app-insurance-form',
  templateUrl: './insurance-form.component.html',
  styleUrls: ['./insurance-form.component.css']
})
export class InsuranceFormComponent implements OnInit
{
    constructor(private service: InsuranceFormService){}

    ngOnInit()
    {
        this.service.getCars().subscribe(response=> {console.log(response)});
    }

    driverDetailsForm = new FormGroup({
        age : new FormControl('',[Validators.required, Validators.max(120), Validators.min(16)]),
        experience : new FormControl('',[Validators.required, Validators.max(100), Validators.min(0)]),
        record : new FormControl('',[Validators.required, Validators.max(1000), Validators.min(0)]),
        claims : new FormControl('',[Validators.required, Validators.max(1000), Validators.min(0)]),
        car_value : new FormControl('',[Validators.required, Validators.max(9999999), Validators.min(0)]),
        car_annual_mileage : new FormControl('',[Validators.required, Validators.max(999999), Validators.min(0)]),
        insurance_history : new FormControl('',[Validators.required, Validators.max(100), Validators.min(0)])
    });
  
    quoteForm =
    {
        premium: 0,
        message: '',
        reference: ''
    };

    onSubmit(): void
    {
        let quote = this.service.getQuote(this.driverDetailsForm).subscribe(data => {
        let insuranceFormWrapper = document.getElementById('wrapper');
        insuranceFormWrapper ? insuranceFormWrapper.style.display = "none" : null;
        this.quoteForm.message = data.message;
        this.quoteForm.premium = data.premium;
        this.quoteForm.reference = data.reference;
        let quoteWrapper = document.getElementById('quote');
        quoteWrapper ? quoteWrapper.style.display = "block" : null;
        if(!data.available)
        {
            let premiumAmountDiv = document.getElementById('premium_amount');
            premiumAmountDiv ? premiumAmountDiv.style.display = "none" : null;
        }
        });
    }
    resetForm()
    {
        this.driverDetailsForm.reset();
    }
    checkInput(event: any)
    {
        return event.charCode >= 48 && event.charCode <= 57;
    }
    copyToClipboard(quote: any)
    {
        navigator.clipboard.writeText(quote.reference);
        let copy_text = document.getElementById("copy_notification");
        copy_text?.setAttribute("class","show");
        setTimeout(()=>{ copy_text?.setAttribute("class", "")}, 3000);
    }
    get age() { return this.driverDetailsForm.get('age')!; }

    get experience() { return this.driverDetailsForm.get('experience')!; }

    get record() { return this.driverDetailsForm.get('record')!; }

    get claims() { return this.driverDetailsForm.get('claims')!; }

    get car_value() { return this.driverDetailsForm.get('car_value')!; }

    get car_annual_mileage() { return this.driverDetailsForm.get('car_annual_mileage')!; }

    get insurance_history() { return this.driverDetailsForm.get('insurance_history')!; }
}
