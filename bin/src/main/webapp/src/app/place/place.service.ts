import {Injectable} from '@angular/core';
import {HttpModule} from '@angular/http'

import {
  Http,
  Headers,
  RequestOptions,
  Response
} from '@angular/http';

import {Observable} from 'rxjs/Observable';
import {SERVER_API_URL} from '../app.constants';

@Injectable()
export class PlaceService {

  private resourceUrl = SERVER_API_URL + 'api/places';
  constructor(private http: Http) {}

  getUserPlaces(id: any): Observable<any> {
    return this.http.get(SERVER_API_URL + 'api/user_places/' + id).map((res: Response) => res.json());;
  }

  updateUser(id, nom, code): Observable<any> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.put(SERVER_API_URL + 'api/update_user_place/' + id + '/' + nom + '/' + code, {}, options)
      .map(this.extractData)
      .catch(this.handleErrorObservable);
  }

  //  updatePlace(): Observable<any>{
  //    let headers = new Headers({ 'Content-Type': 'application/json' });
  //    let options = new RequestOptions({ headers: headers });
  //    return this.http.put(SERVER_API_URL + 'api/update_place',{}, options)
  //               .map(this.extractData)
  //               .catch(this.handleErrorObservable);
  //  }
  //  
  private extractData(res: Response) {
    let body = res.json();
    return body.data || {};
  }
  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}
