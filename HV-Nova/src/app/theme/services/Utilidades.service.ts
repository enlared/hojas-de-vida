import { Injectable } from '@angular/core';

@Injectable()

export class Utilidades {

  private servidor = 'http://localhost:7070';
  private regexTelefono = "";
  private regexNumeros = "/^[0-9]*$/";
  private regexEmail = "";

  private regexLetras = "/[^a-zA-Z .]/g";

  constructor() {

  }
  get getServidor(): string {
    return this.servidor;
  }
  get getRegexNumeros(): string {
    return this.regexNumeros;
  }
  get getRegexLetras(): string {
    return this.regexLetras;
  }

  get getRegexEmail(): string {
    return this.regexEmail;
  }

  get getRegexTelefono(): string {
    return this.regexTelefono;
  }

  validarTexto(value): any {
    let retorno = '';
    if (!value) {
      retorno = '';
    } else {
      const lista = value.replace(/[^a-zA-Z .]/g, '').split('');
      lista.forEach(element => {
        retorno = retorno + element;
      });
    }
    let copy = JSON.parse(JSON.stringify(retorno));
    return copy;
  }
  validarTelefono(value): any {
    let retorno = '';
    if (!value) {
      retorno = '';
    } else {
      const lista = value.replace(/[^0-9]/g, '').split('');
      lista.forEach(element => {
        retorno = retorno + element;
      });
    }
    let copy = JSON.parse(JSON.stringify(retorno));
    return copy;
  }

  validarEmail(value): boolean {
    var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return !reg.test(value);
    }

}

