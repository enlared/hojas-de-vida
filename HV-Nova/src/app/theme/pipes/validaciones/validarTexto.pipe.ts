import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'validarTexto'
})
export class ValidarTexto implements PipeTransform {
  transform(value: any, args?: any): string {
    let retorno='';
    if (!value) {
      retorno = '';
    } else {
      const lista = value.replace(/[^a-zA-Z .]/g, '').split('');
      lista.forEach(element => {
        retorno = retorno + element;
      });

    }

    value = '';
    return retorno;

  }


}
