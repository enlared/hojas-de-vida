import { Injectable } from '@angular/core';
import { KeyBusinessData } from './keyBusiness';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class KeyBusinessService {

  private url = 'http://localhost:8080/keyBusiness';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private keyBusinessData: KeyBusinessData = new KeyBusinessData();

  constructor(private http: Http) {

  }

  
  deleteKeyBusiness(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getKeyBusiness(): Observable<KeyBusinessData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getKeyBusinessData(id: number): Observable<KeyBusinessData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addKeyBusiness(keyBusinessData: KeyBusinessData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(keyBusinessData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putKeyBusiness(keyBusinessData: KeyBusinessData) {

    let url = `${this.url}/edit/${keyBusinessData.idkbsn}`;
    let iJson = JSON.stringify(keyBusinessData);
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