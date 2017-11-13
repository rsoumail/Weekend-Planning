import {Injectable} from '@angular/core';
import {Http, Response, RequestOptions, Headers} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {SERVER_API_URL} from '../app.constants';

@Injectable()
export class ActivityService {

  constructor(private http: Http) {}

  getAll(): Observable<any> {
    return this.http.get(SERVER_API_URL + 'api/activities').map((res: Response) => res.json());

  }

  getUserActivities(id: any): Observable<any> {
    return this.http.get(SERVER_API_URL + 'api/user_activities/' + id).map((res: Response) => res.json());
  }
//push

  private extractData(res: Response) {
    if (res.status < 200 || res.status >= 300) {
      throw new Error('Bad response status: ' + res.status);
    }
    console.log(res);
    let body = res.json();
    return body.data || {};
  }

    updateUser(id, idActivity): Observable<any> {
      console.log(id);
      console.log(idActivity);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.put(SERVER_API_URL + 'api/update_user_activity/' + id + '/' + idActivity, {}, options)
      .map(this.extractData)
      .catch(this.handleError);
    }

    private handleError(error: any) {
    // In a real world app, we might send the error to remote logging infrastructure
    let errMsg = error.message || 'Server error';
    console.error(errMsg); // log to console instead
    console.log(errMsg);
    return Observable.throw(errMsg);
  }


}
