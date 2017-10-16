import { Injectable } from '@angular/core';
import { ParametroGenerico } from './genericoParametro';
import { Utilidades } from '../Utilidades.service';

import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class TipoVentaService {

  private url = '/tipoVenta';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private billingData: ParametroGenerico = new ParametroGenerico();

  constructor(private http: Http,
        private util: Utilidades) {
    this.url = util.getServidor + this.url;
  }


  delete(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getAll(): Observable<ParametroGenerico[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getId(id: number): Observable<ParametroGenerico> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addSave(billingData: ParametroGenerico) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(billingData);
    return this.http.post(url, iJson, { headers: this.headers })
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
