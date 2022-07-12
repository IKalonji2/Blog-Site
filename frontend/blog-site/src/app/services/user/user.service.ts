import { Injectable } from '@angular/core';
import { User } from '../../models/User';
import { USER } from '../../mock-user';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  private userUrl =
    'http://ec2-13-244-233-86.af-south-1.compute.amazonaws.com:5000/username';

    getUser(): Observable<User> {
    const user = this.http.get<User>(this.userUrl);;
    return user;
  }
}
