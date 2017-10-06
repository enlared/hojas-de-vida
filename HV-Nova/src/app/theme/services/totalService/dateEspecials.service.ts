import { Injectable } from '@angular/core';
import { DateEspecialsData } from './dateEspecials';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class DateEspecialsService {

  private url = 'http://45.55.95.110:7070/dateEspecials';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private dateEspecialsData: DateEspecialsData = new DateEspecialsData();

  constructor(private http: Http) {

  }

  
  deleteDateEspecials(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getDateEspecials(): Observable<DateEspecialsData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getDateEspecialsData(id: number): Observable<DateEspecialsData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addDateEspecials(dateEspecialsData: DateEspecialsData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(dateEspecialsData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putDateEspecials(dateEspecialsData: DateEspecialsData) {

    let url = `${this.url}/edit/${dateEspecialsData.iddtspc}`;
    let iJson = JSON.stringify(dateEspecialsData);
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