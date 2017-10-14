import {  Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'validarNumero',
})
@Injectable()
export class ValidarNumero implements PipeTransform {
  transform(value: any, args?: any): any {
    let retorno = '';
    if (!value) {
      retorno = '';
    } else {
      const lista = value.replace(/[^0-9 .]/g, '').split('');
     lista.forEach(element => {
        retorno = retorno + element;
      });

    }
    return retorno;
  }


}
