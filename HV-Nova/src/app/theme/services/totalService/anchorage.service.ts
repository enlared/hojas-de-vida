import { Injectable } from '@angular/core';
import { AnchorageData } from './anchorage';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class AnchorageService {

  private url = 'http://localhost:7070/anchorage';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private anchorageData: AnchorageData = new AnchorageData();

  constructor(private http: Http) {

  }

  
  deleteAnchorage(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getAnchorage(): Observable<AnchorageData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getAnchorageData(id: number): Observable<AnchorageData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addAnchorage(anchorageData: AnchorageData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(anchorageData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putAnchorage(anchorageData: AnchorageData) {

    let url = `${this.url}/edit/${anchorageData.idanchg}`;
    let iJson = JSON.stringify(anchorageData);
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