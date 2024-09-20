import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.email, this.password).subscribe(
      response => {
        // Store JWT token and navigate to the dashboard or another page
        localStorage.setItem('token', response.token);
        this.router.navigate(['/dashboard']);
      },
      error => {
        console.error('Login failed', error);
        alert('Invalid credentials');
      }
    );
  }

  onRegister() {
    // Navigate to the register page or perform other actions
    console.log("Register clicked");
    this.router.navigate(['/register']);  // Example: Redirect to a registration page
  }
}
