import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../app.constants';

@Injectable()
export class ActivityService {

  constructor(private http: Http) {}

  getAll(){
    return this.http.get(SERVER_API_URL + 'api/activities');
  }

  add(activity: any): Observable <any> {
    return this.http.post(SERVER_API_URL + 'api/activities', activity);
  }

}
