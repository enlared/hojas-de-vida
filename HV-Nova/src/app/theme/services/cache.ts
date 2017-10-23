import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { RolUsuarios } from './viewUsersService/rolUsuarios';


@Injectable()

export class cache {

  private id: number ;
  private rolUsuarios: RolUsuarios ;
  constructor() {
  }
   getid(): number {
    return this.id;
  }

   setid(idd: number): void {
     this.id = idd;
  }

  getrolUsuario(): RolUsuarios {
    return this.rolUsuarios;
  }

   setrolUsuario(idd: RolUsuarios): void {
     this.rolUsuarios = idd;
  }

}

