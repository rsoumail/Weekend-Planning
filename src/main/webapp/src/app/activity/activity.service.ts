import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../app.constants';

@Injectable()
export class ActivityService {

  constructor(private http: Http) {}

  getAll(): Observable<any>{
    return this.http.get(SERVER_API_URL + 'api/activities').map((res: Response) => res.json());

  }

  add(activity: any): Observable <any> {
    return this.http.post(SERVER_API_URL + 'api/activities', activity);
  }

}
