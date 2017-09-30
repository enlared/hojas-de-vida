import { Injectable } from '@angular/core';
import { EjecutivoCuenta } from './EjecutivoCuenta';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class KeyAccountService {

  private url = 'http://localhost:8080/ejecutivoCuenta';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private keyAccountData: EjecutivoCuenta = new EjecutivoCuenta();

  constructor(private http: Http) {

  }


  deleteKeyAccount(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getKeyAccount(): Observable<EjecutivoCuenta[]> {
    let url = `${this.url}/findAll`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getKeyAccountData(id: number): Observable<EjecutivoCuenta> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addKeyAccount(keyAccountData: EjecutivoCuenta) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(keyAccountData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putKeyAccount(keyAccountData: EjecutivoCuenta) {

    let url = `${this.url}/edit/${keyAccountData.id}`;
    let iJson = JSON.stringify(keyAccountData);
    return this.http.put(url, iJson, { headers: this.headers })
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
