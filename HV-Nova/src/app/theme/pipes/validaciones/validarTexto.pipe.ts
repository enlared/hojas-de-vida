import { Pipe, PipeTransform, WrappedValue } from '@angular/core';

@Pipe({
  name: 'ValidarTexto',
})
export class ValidarTexto implements PipeTransform {
  transform(value: string, args?: string): string {
    let retorno = '';
    if (!value) {
      retorno = '';
    } else {
      const lista = value.replace(/[^a-zA-Z .]/g, '').split('');
     lista.forEach(element => {
        retorno = retorno + element;
      });

    }
    value=retorno;
    return String(JSON.parse(JSON.stringify(retorno)));
  }


}
