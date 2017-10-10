import {Pipe, PipeTransform} from '@angular/core';
import {layoutPaths} from '../../../theme';

@Pipe({name: 'baAppPicture'})
export class VAlidarTexto implements PipeTransform {
  transform(value: any, args?: any): any {
    let valor;
    if (value.length > 0) {
      for (let index = 0; index < value.length; index++) {
         if ((/^[a-zA-Z ]/.test(value[index].toString()))) {
          valor = this.validarIndefinido(valor) + (value[index].toString());

        }

      }
    }
    console.log(valor.toString());
    return this.validarIndefinido(valor).toString(); ;
  }

  validarIndefinido(dato) {
    let valor='';
    if (dato !== undefined) {
      valor = dato;
    }
      return valor;

  }
}
