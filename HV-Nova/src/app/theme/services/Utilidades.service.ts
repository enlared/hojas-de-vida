import { Injectable } from '@angular/core';

@Injectable()

export class Utilidades {

  private servidor = 'http://45.55.95.110:7070';
  private regexTelefono = "";
  private regexNumeros = "/^[0-9]*$/";
  private regexEmail = "";

  private regexLetras = "/^[a-zA-Z]*$/";

  constructor() {

  }
  get getServidor(): string  {
    return this.servidor;
  }
  get getRegexNumeros(): string  {
    return this.regexNumeros;
  }
  get getRegexLetras(): string  {
    return this.regexLetras;
  }

  get getRegexEmail(): string  {
    return this.regexEmail;
  }

  get getRegexTelefono(): string  {
    return this.regexTelefono;
  }


}

