import { Injectable } from '@angular/core';
import { ContactsData } from './contactsData';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';
import { Utilidades } from '../Utilidades.service';

@Injectable()

export class ContactsService {

  private url = '/contacto';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private contacts: ContactsData = new ContactsData();

  constructor(private http: Http,
     private util: Utilidades) {
    this.url = util.getServidor + this.url;

  }


  deleteContacts(id: ContactsData)  {
    let url = `${this.url}/delete`;
    return this.http.post(url, id)
      .map(r => r.json())
      .catch(this.handleError);
  }



  getContact(id: ContactsData): Observable<ContactsData[]> {
    const url = `${this.url}/find`;
    return this.http.post(url, id)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addContacts(contactsData: ContactsData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(contactsData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putContacts(contactsData: ContactsData) {

    let url = `${this.url}/edit/${contactsData.id}`;
    let iJson = JSON.stringify(contactsData);
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
