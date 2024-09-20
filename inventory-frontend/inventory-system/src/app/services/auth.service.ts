import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 // Java backend endpoint for Login
  private apiUrl = 'http://localhost:8083/api/auth';  


  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any> {
    const credentials = { email, password };
    const headers = { 'Content-Type': 'application/json' };
    return this.http.post<any>(`${this.apiUrl}/login`, credentials,{headers});
  }
  // Method to handle user registration
  register(name: string, email: string, password: string): Observable<any> {
    const user = { name, email, password };
    return this.http.post(`${this.apiUrl}/register`, user);
  }

}
