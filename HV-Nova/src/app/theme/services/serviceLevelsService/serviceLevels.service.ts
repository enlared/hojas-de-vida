import { Injectable } from '@angular/core';
import { ServiceLevelsData } from './serviceLevels';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class ServiceLevelsService {

  private url = 'http://45.55.95.110:7070/serviceLevelAgreement';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private serviceLevels: ServiceLevelsData = new ServiceLevelsData();

  constructor(private http: Http) {

  }


  deleteServiceLevels(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getServiceLevels(): Observable<ServiceLevelsData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getServiceLevel(id: number): Observable<ServiceLevelsData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addServiceLevels(serviceLevelsData: ServiceLevelsData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(serviceLevelsData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putServiceLevels(serviceLevelsData: ServiceLevelsData) {

    let url = `${this.url}/edit/${serviceLevelsData.idsla}`;
    let iJson = JSON.stringify(serviceLevelsData);
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
