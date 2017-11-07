import { Injectable } from '@angular/core';

import {
  Http,
  Headers,
  RequestOptions,
  Response
} from '@angular/http';

import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../app.constants';

@Injectable()
export class PlaceService {

  private resourceUrl = SERVER_API_URL + 'api/places';
  constructor(private http: Http) { }

  getUserPlace(user: any): Observable<any> {
    return this.http.get(SERVER_API_URL + 'api/users_places', user);
  }


}
