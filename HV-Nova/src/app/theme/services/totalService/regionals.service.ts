import { Injectable } from '@angular/core';
import { RegionalsData } from './regionals';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class RegionalsService {

  private url = 'http://45.55.95.110:7070/regionales';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private regionalsData: RegionalsData = new RegionalsData();

  constructor(private http: Http) {

  }


  deleteRegionals(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getRegionals(): Observable<RegionalsData[]> {
    let url = `${this.url}/findAll`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getRegionalsData(id: number): Observable<RegionalsData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addRegionals(regionalsData: RegionalsData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(regionalsData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putRegionals(regionalsData: RegionalsData) {

    let url = `${this.url}/edit/${regionalsData.id}`;
    let iJson = JSON.stringify(regionalsData);
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
