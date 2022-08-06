import { Component } from '@angular/core';
import { FormGroup, FormControl, FormControlName,Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';

  loginForm = new FormGroup({
    user: new FormControl('',[Validators.required,Validators.email]),
    pass: new FormControl('',[Validators.required,Validators.minLength(5)]),
  })

  loginUser() {
    console.warn(this.loginForm.value);
  }

  get user(){
    return this.loginForm.get('user');
  }

  get pass(){
    return this.loginForm.get('pass');
  }

}
