import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  name: string = '';
  email: string = '';
  password: string = '';

  constructor(private router: Router, private authService : AuthService) {}

  onSubmit() {
    this.authService.register(this.name, this.email, this.password).subscribe(
      response => {
        console.log('User registered successfully', response);
        alert("User Details Registered");
        // Navigate to login page or dashboard after successful registration
        this.router.navigate(['/login']);
      },
      error => {
        console.error('Error occurred during registration', error);
        alert('Registration failed');
      }
    );
  }
}
