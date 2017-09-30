import { Injectable } from '@angular/core';
import { EjecutivoCuenta } from './totalService/EjecutivoCuenta';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class EjecutivoCuentaService {

  private url = 'http://localhost:8080/ejecutivoCuentaImpl/findAll';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private ejecutivoCuenta: EjecutivoCuenta = new EjecutivoCuenta();

  constructor(private componentehttp: Http) {

  }
  get getArticulos() {
    return this.componentehttp.get(this.url).map(res => res.json());
  }

}
