import { Injectable } from '@angular/core';
import { BusinessData } from './businessData';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

import { Utilidades } from '../Utilidades.service';

@Injectable()

export class BusinessDataService {

  private url = '/negocio';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private businessData: BusinessData = new BusinessData();

  constructor(
    private http: Http,
    private util: Utilidades) {
  this.url = util.getServidor + this.url;
  }


  deleteBusinessData(data: BusinessData)  {
    let url = `${this.url}/delete/`;
    return this.http.post(url, data)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addBusinessData(businessData: BusinessData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(businessData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  getClienteBusinessData(clienteid: BusinessData): Observable<BusinessData[]> {
    const url = `${this.url}/findCliente`;
    return this.http.post(url, clienteid)
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
