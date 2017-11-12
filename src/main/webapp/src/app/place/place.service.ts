import { Injectable } from '@angular/core';
import {HttpModule} from '@angular/http'

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

  getUserPlaces(id: any): Observable<any> {
    return this.http.get(SERVER_API_URL + 'api/user_places/'+id).map((res: Response) => res.json());;
  }
  
//  getUserPlaces(): Observable<any> {
//    return this.http.get(SERVER_API_URL + 'api/places').map((res: Response) => res.json());
//  }
//  
//  updateUserPlaces(): Observable<any> {
//    return this.http.post(SERVER_API_URL + 'api/place',{id:"2",name:"ffff"});
//  }
  


}
