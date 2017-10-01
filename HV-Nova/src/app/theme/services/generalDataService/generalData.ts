
import { EjecutivoNegocios } from '../totalService/EjecutivoNegocios';
import { EjecutivoCuenta } from '../totalService/EjecutivoCuenta';
import { TipoCliente } from '../totalService/TipoCliente';
import { RegionalsData } from '../totalService/regionals';

export class GeneralData {

codigosap: number;
fechaInicioObjeto: any;
fechaFinObjeto: any;
fechainicio: Date;
fechafin: Date;
objetivoanual: string;
objetivomensual: string;
ejecutivoNegocio: EjecutivoNegocios;
ejecutivoCuenta: EjecutivoCuenta;
regional: RegionalsData;
razonsocial: string;
nit: string;
direccion: string;
barrio: string;
email: string;
telfonofijo: string;
numbersedes: string;
numerocelular: string;
tipoCliente: TipoCliente;

}
