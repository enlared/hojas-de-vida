import { Injectable } from '@angular/core';
import { TipoEmpleadoData } from './TipoEmpleadoData';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class TypeEmployeesService {

  private url = 'http://localhost:8080/tipoEmpleado';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private typeEmployeesData: TipoEmpleadoData = new TipoEmpleadoData();

  constructor(private http: Http) {

  }


  deleteTypeEmployees(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getTypeEmployees(): Observable<TipoEmpleadoData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getTypeEmployeesData(id: number): Observable<TipoEmpleadoData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addTypeEmployees(typeEmployeesData: TipoEmpleadoData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(typeEmployeesData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putTypeEmployees(typeEmployeesData: TipoEmpleadoData) {

    let url = `${this.url}/edit/${typeEmployeesData.id}`;
    let iJson = JSON.stringify(typeEmployeesData);
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
