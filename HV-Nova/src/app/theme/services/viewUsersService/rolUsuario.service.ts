import { Injectable } from '@angular/core';
import { Users } from './users';
import { RolUsuarios } from './rolUsuarios';
import { RespuestaRolUsuario } from '../respuestaRolUsuario';

import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';
import { Utilidades } from '../../../theme/services/Utilidades.service';

@Injectable()

export class RolUsuarioService {

  private url = '/rolUsuario';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  constructor(private http: Http,
    private util: Utilidades) {
    this.url = util.getServidor + this.url;
  }

  delete(id: RolUsuarios): Observable<RolUsuarios> {
    let url = `${this.url}/delete`;
    return this.http.post(url, id)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getAll(): Observable<RolUsuarios[]> {
    const url = `${this.url}/findAll`;
    return this.http.get(url).
      map(res => res.json())
      .catch(this.handleError);
  }

  get(id: number): Observable<RolUsuarios> {
    const url = `${this.url}/find`;
    return this.http.post(url, id).
      map(res => res.json())
      .catch(this.handleError);
  }

  getXUsuario(id: RolUsuarios): Observable<RespuestaRolUsuario> {
    const url = `${this.url}/consulta`;
    return this.http.post(url, id).
      map(res => res.json())
      .catch(this.handleError);
  }

  add(user: RolUsuarios):any {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(user);
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
