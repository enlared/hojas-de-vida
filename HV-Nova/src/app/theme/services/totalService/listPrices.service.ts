import { Injectable } from '@angular/core';
import { ListPricesData } from './listPrices';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class ListPricesService {

  private url = 'http://localhost:7070/listPrices';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private listPricesData: ListPricesData = new ListPricesData();

  constructor(private http: Http) {

  }

  
  deleteListPrices(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getListPrices(): Observable<ListPricesData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getListPricesData(id: number): Observable<ListPricesData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addListPrices(listPricesData: ListPricesData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(listPricesData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putListPrices(listPricesData: ListPricesData) {

    let url = `${this.url}/edit/${listPricesData.idlstprc}`;
    let iJson = JSON.stringify(listPricesData);
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