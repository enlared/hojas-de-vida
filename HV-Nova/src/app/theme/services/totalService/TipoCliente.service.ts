import { Injectable } from '@angular/core';
import { TipoCliente } from './TipoCliente';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class TipoClienteService {

  private url = 'http://45.55.95.110:7070/tipoCliente';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private tipoCliente: TipoCliente = new TipoCliente();

  constructor(private http: Http) {

  }



  getTipoClienteAll(): Observable<TipoCliente[]> {
    let url = `${this.url}/findAll`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getTipoCliente(id: number): Observable<TipoCliente> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  adicionarTipoCliente(ejecutivoNegocios: TipoCliente) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(ejecutivoNegocios);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

editarTipoCliente(tipoCliente: TipoCliente) {

    let url = `${this.url}/edit/${tipoCliente.id}`;
    let iJson = JSON.stringify(tipoCliente);
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
