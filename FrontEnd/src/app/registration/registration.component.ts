import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  registrationObj: any = {
    "registrationId": 0,
    "name": "",
    "age": 0,
    "gender": "",
    "rollNumber": "",
    "cource": "",
    "semester": "",
    "studentPhoto": "",
    "addtionalDocument": "",
  }

  constructor(private router: Router, private http: HttpClient) { }

  openLogin() {
    this.router.navigate(['/login']);
  }

  openRegister() {
    this.http.post("http://localhost:8080/POST/api/students", this.registrationObj).pipe(
      catchError(error => {
        console.error('Error occurred:', error);
        return of(null);
      })
    )
    .subscribe(response => {
      console.log('Response received:', response);
    });
  }
}
