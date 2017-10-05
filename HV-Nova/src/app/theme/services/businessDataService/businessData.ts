import { typeGlass } from '../totalService/typeGlass';
import { AnchorageData } from '../totalService/anchorage';
import { TypeNegociationData } from '../totalService/typeNegociation';
import { TypeMachineData } from '../totalService/typeMachine';
import { ListPricesData } from '../totalService/listPrices';
import { CategoryData } from '../totalService/category';

export class BusinessData {

id: number;
clienteId: number;
numeroMaquina: number;
tipoVasoId: number;
totalsale: number;
anclaje: AnchorageData;
tipoNegociacion: TypeNegociationData;
numeromaquina: TypeMachineData;
listaPrecio: ListPricesData;
categoria: CategoryData;

}
