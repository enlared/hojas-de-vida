import { Injectable } from '@angular/core';
import { ContactHseqData } from './contactHseq';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class ContactHseqService {

  private url = 'http://45.55.95.110:7070/contactHseq';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private contactHseqData: ContactHseqData = new ContactHseqData();

  constructor(private http: Http) {

  }


  deleteContactHseq(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getContactHseq(): Observable<ContactHseqData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getContactHseqData(id: number): Observable<ContactHseqData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addContactHseq(contactHseqData: ContactHseqData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(contactHseqData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putContactHseq(contactHseqData: ContactHseqData) {

    let url = `${this.url}/edit/${contactHseqData.idcnthseq}`;
    let iJson = JSON.stringify(contactHseqData);
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
