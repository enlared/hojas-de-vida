import { Injectable } from '@angular/core';
import { BillingData } from './billing';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class BillingService {

  private url = 'http://localhost:7070/billing';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private billingData: BillingData = new BillingData();

  constructor(private http: Http) {

  }

  
  deleteBilling(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  

  getBilling(): Observable<BillingData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getBillingData(id: number): Observable<BillingData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addBilling(billingData: BillingData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(billingData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putBilling(billingData: BillingData) {

    let url = `${this.url}/edit/${billingData.idbilling}`;
    let iJson = JSON.stringify(billingData);
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