import { Injectable } from '@angular/core';
import { EjecutivoNegocios } from './EjecutivoNegocios';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class EjecutivoNegociosService {

  private url = 'http://localhost:7070/ejecutivoNegocio';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private keyBusinessData: EjecutivoNegocios = new EjecutivoNegocios();

  constructor(private http: Http) {

  }


  deleteKeyBusiness(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getKeyBusiness(): Observable<EjecutivoNegocios[]> {
    let url = `${this.url}/findAll`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getKeyBusinessData(id: number): Observable<EjecutivoNegocios> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addKeyBusiness(ejecutivoNegocios: EjecutivoNegocios) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(ejecutivoNegocios);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putKeyBusiness(ejecutivoNegocios: EjecutivoNegocios) {

    let url = `${this.url}/edit/${ejecutivoNegocios.id}`;
    let iJson = JSON.stringify(ejecutivoNegocios);
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
