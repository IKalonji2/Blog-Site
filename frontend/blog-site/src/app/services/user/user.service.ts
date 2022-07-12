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
    'https://api.github.com/users/mojombo';

  getUser(): Observable<User> {
    const user = this.http.get<User>(this.userUrl);
    return user;
  }

  getUserTokens(code: string): Observable<any> {
    return this.http.get(`https://bs-loadbalance-1072678543.af-south-1.elb.amazonaws.com:8081/v1/token?sub=${code}`)
  }
}
