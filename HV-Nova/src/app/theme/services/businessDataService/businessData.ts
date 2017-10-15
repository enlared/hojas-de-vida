import { typeGlass } from '../totalService/typeGlass';
import { AnchorageData } from '../totalService/anchorage';
import { TypeNegociationData } from '../totalService/typeNegociation';
import { ParametroGenerico } from '../totalService/genericoParametro';
import { ListPricesData } from '../totalService/listPrices';

export class BusinessData {

id: number;
clienteid: number;
numeromaquina: number;
tipoVasoId: number;
totalsale: number;
anclaje: AnchorageData;
tipoNegociacion: TypeNegociationData;
tipoMaquina: ParametroGenerico;
listaPrecio: ListPricesData;
categoria: ParametroGenerico;

}
