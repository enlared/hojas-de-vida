import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';
import { Utilidades } from '../../../theme/services/Utilidades.service';
import { ParametroGenerico } from '../../../theme/services/totalService/genericoParametro';


@Injectable()

export class RoleService {

  private url = '/rol/findall';
  private headers = new Headers({ 'Content-Type': 'application/json' });

constructor(private http: Http,
  private util: Utilidades) {
    this.url = util.getServidor + this.url;
}

getRole(): Observable<ParametroGenerico[]> {
let url = `${this.url}`;
 return this.http.get(url)
 .map(r => r.json())
 .catch(this.handleError);
}

private handleError(error: Response | any){

let errMsg: string;
if(error instanceof Response) {
let body = error.json() || '';
let err =  body.error || JSON.stringify(body);
errMsg = `${error.status} - ${error.statusText || '' } ${err}`;

}else{

  errMsg= error.message ? error.message : error.toString();
}
return Observable.throw(errMsg);
}


}
