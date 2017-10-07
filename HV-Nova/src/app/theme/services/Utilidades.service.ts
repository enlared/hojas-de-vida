import { Injectable } from '@angular/core';

@Injectable()

export class Utilidades {

  private servidor = 'http://localhost:7070';

  constructor() {

  }
  get getServidor(): string  {
    return this.servidor;
  }

}

