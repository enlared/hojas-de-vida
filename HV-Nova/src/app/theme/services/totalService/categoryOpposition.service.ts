import { Injectable } from '@angular/core';
import { ParametroGenerico } from './genericoParametro';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Utilidades } from '../Utilidades.service';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()
export class CategoryOppositionService {

  private url = '/categoriaCompetencia';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private categoryData: ParametroGenerico = new ParametroGenerico();

  constructor(private http: Http,
    private util: Utilidades) {
      this.url = util.getServidor + this.url;

  }


  deleteCategory(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getCategory(): Observable<ParametroGenerico[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getCategoryData(id: number): Observable<ParametroGenerico> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addCategory(categoryData: ParametroGenerico) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(categoryData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putCategory(categoryData: ParametroGenerico) {

    let url = `${this.url}/edit/${categoryData.id}`;
    let iJson = JSON.stringify(categoryData);
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
