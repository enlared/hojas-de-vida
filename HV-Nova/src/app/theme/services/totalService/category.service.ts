import { Injectable } from '@angular/core';
import { CategoryData } from './category';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class CategoryService {

  private url = 'http://localhost:7070/categoria';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private categoryData: CategoryData = new CategoryData();

  constructor(private http: Http) {

  }


  deleteCategory(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getCategory(): Observable<CategoryData[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getCategoryData(id: number): Observable<CategoryData> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addCategory(categoryData: CategoryData) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(categoryData);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putCategory(categoryData: CategoryData) {

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
