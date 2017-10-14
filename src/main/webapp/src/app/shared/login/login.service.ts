import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from '../../app.constants';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  login(credentials: any) : Observable<any> {

  		const data = 'username=' + encodeURIComponent(credentials.login) + '&password=' + encodeURIComponent(credentials.password);
  		const headers = new Headers({
  			'Content-Type': 'application/x-www-form-urlencoded'
  		});
  		return this.http.post(SERVER_API_URL + 'api/authentification', credentials, { headers });
  }
}
