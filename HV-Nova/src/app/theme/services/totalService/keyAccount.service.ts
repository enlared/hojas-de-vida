import { Injectable } from '@angular/core';
import { KeyAccountData } from './keyAccount';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class KeyAccountService {

  private url = 'http://localhost:8080/keyAccount';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private keyAccountData: KeyAccountData = new KeyAccountData();

  constructor(private http: Http) {

  }

  
  deleteKeyAccount(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getKeyAccount(): Observable<KeyAccountData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getKeyAccountData(id: number): Observable<KeyAccountData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addKeyAccount(keyAccountData: KeyAccountData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(keyAccountData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putKeyAccount(keyAccountData: KeyAccountData) {

    let url = `${this.url}/edit/${keyAccountData.idkacnt}`;
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