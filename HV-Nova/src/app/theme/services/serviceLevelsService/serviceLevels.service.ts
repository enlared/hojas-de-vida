import { Injectable } from '@angular/core';
import { ServiceLevelsData } from './serviceLevels';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';
import { Utilidades } from '../../../theme/services/Utilidades.service';

@Injectable()

export class ServiceLevelsService {

  private url = '/nivelServicio';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private serviceLevels: ServiceLevelsData = new ServiceLevelsData();

  constructor(private http: Http,
  private util: Utilidades) {
    this.url = util.getServidor + this.url;
  }


  deleteServiceLevels(id: ServiceLevelsData)  {
    let url = `${this.url}/delete`;
    return this.http.post(url, id)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getServiceLevels(): Observable<ServiceLevelsData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getServiceLevel(id: number): Observable<ServiceLevelsData[]> {
    const data = {
      clienteid: id,
    };
    const url = `${this.url}/find/`;
    return this.http.post(url, data)
      .map(r => r.json())
      .catch(this.handleError);
  }

  add(serviceLevelsData: ServiceLevelsData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(serviceLevelsData);
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
