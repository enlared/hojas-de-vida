import { typeGlass } from '../totalService/typeGlass';
import { AnchorageData } from '../totalService/anchorage';
import { TypeNegociationData } from '../totalService/typeNegociation';
import { TypeMachineData } from '../totalService/typeMachine';
import { ListPricesData } from '../totalService/listPrices';
import { CategoryData } from '../totalService/category';

export class BusinessData {

id: number;
clienteid: number;
numeromaquina: number;
tipoVasoId: number;
totalsale: number;
anclaje: AnchorageData;
tipoNegociacion: TypeNegociationData;
tipoMaquina: TypeMachineData;
listaPrecio: ListPricesData;
categoria: CategoryData;

}
