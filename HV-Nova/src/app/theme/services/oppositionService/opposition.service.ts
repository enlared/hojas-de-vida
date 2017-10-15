import { Injectable } from '@angular/core';
import { OppositionData } from './opposition';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';
import { Utilidades } from '../../../theme/services/Utilidades.service';

@Injectable()

export class OppositionService {

  private url = '/competencia';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private opposition: OppositionData = new OppositionData();

  constructor(private http: Http,
        private util: Utilidades,
  ) {
    this.url = util.getServidor + this.url;

  }


  deleteOpposition(id: OppositionData)  {
    let url = `${this.url}/delete`;
    return this.http.post(url, id)
      .map(r => r.json())
      .catch(this.handleError);
  }
  getOpposition(id: OppositionData): Observable<OppositionData[]> {
    const url = `${this.url}/find/`;
    return this.http.post(url, id)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addOpposition(oppositionData: OppositionData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(oppositionData);
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
