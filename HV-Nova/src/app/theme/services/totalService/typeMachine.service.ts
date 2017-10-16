import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Utilidades } from '../Utilidades.service';
import { ParametroGenerico } from '../../../theme/services/totalService/genericoParametro';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class TypeMachineService {

  private url = '/typeMachine';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private typeMachineData: ParametroGenerico = new ParametroGenerico();

  constructor(private http: Http,
  private util: Utilidades) {
    this.url = util.getServidor + this.url;

  }


  deleteTypeMachine(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getTypeMachine(): Observable<ParametroGenerico[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getTypeMachineData(id: number): Observable<ParametroGenerico> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addTypeMachine(typeMachineData: ParametroGenerico) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(typeMachineData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putTypeMachine(typeMachineData: ParametroGenerico) {

    let url = `${this.url}/edit/${typeMachineData.id}`;
    let iJson = JSON.stringify(typeMachineData);
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
