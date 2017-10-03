import { Injectable } from '@angular/core';
import { PurseData } from './purse';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class PurseService {

  private url = 'http://45.55.95.110:7070/purse';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private purseData: PurseData = new PurseData();

  constructor(private http: Http) {

  }

  
  deletePurse(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getPurse(): Observable<PurseData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getPurseData(id: number): Observable<PurseData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addPurse(purseData: PurseData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(purseData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putPurse(purseData: PurseData) {

    let url = `${this.url}/edit/${purseData.idpurse}`;
    let iJson = JSON.stringify(purseData);
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