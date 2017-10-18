import { Injectable } from '@angular/core';
import { Users } from './users';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';
import { Utilidades } from '../../../theme/services/Utilidades.service';

@Injectable()

export class ViewUsersService {

  private url = '/usuario';
  private headers = new Headers({ 'Content-Type': 'application/json' });


  constructor(private http: Http,
    private util: Utilidades) {
    this.url = util.getServidor + this.url;
  }

  delete(id: number): Observable<Users> {
    let url = `${this.url}/delete`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  get(id: Users): Observable<Users> {
    const url = `${this.url}/find`;
    return this.http.post(url, id).
      map(res => res.json())
      .catch(this.handleError);
  }


  getAll(): Observable<Users[]> {
    let url = `${this.url}/findAll`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  add(user: Users) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(user);
    return this.http.post(url, iJson)
      .map(r => r.json())
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {

    let errMsg: string;
    if (error instanceof Response) {
      let body = error.json() || '';
      let err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;

    } else {

      errMsg = error.message ? error.message : error.toString();
    }
    return Observable.throw(errMsg);
  }
}
