import { Injectable } from '@angular/core';
import { TypeNegociationData } from './typeNegociation';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class TypeNegociationService {

  private url = 'http://localhost:8080/typeNegociation';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private typeNegociationData: TypeNegociationData = new TypeNegociationData();

  constructor(private http: Http) {

  }

  
  deleteTypeNEgociation(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getTypeNegociation(): Observable<TypeNegociationData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getTypeNegociationData(id: number): Observable<TypeNegociationData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addTypeNegociation(typeNegociationData: TypeNegociationData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(typeNegociationData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putTypeNegociation(typeNegociationData: TypeNegociationData) {

    let url = `${this.url}/edit/${typeNegociationData.idtpngc}`;
    let iJson = JSON.stringify(typeNegociationData);
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