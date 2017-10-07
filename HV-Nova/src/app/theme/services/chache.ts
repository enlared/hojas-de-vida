import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';


@Injectable()

export class chache {

  private  id:number ;
  constructor() {
  }
   getid():number {
    return this.id;
  }

   setid(idd:number):void {
     this.id= idd;
  }

}

