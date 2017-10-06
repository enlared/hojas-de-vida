import {Component} from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { HeadQuartersService } from '../../../../theme/services/headQuartersService/headQuarters.service';
import { HeadQuarters } from '../../../../theme/services/headQuartersService/headQuarters';
import { SectorService } from '../../../../theme/services/totalService/sector.service';
import { SectorData } from '../../../../theme/services/totalService/SectorData';
import { TypeEmployeesService } from '../../../../theme/services/totalService/typeEmployees.service';
import { TipoEmpleadoData } from '../../../../theme/services/totalService/TipoEmpleadoData';
import { IMyDpOptions } from 'mydatepicker';
import { datosbasicos } from '../../../../theme/services/datosBasicos';
@Component({
  selector: 'headquarters',
  templateUrl: './headquarters.html',
  styleUrls: ['./headquarters.scss']
})
export class Headquarters {

  msgError: string;
  idCliente: number;
  headQuarters: HeadQuarters[];
  headQuarter: HeadQuarters = new HeadQuarters();
  typeEmployeesDatas: TipoEmpleadoData[];
  typeEmployeesData: TipoEmpleadoData = new TipoEmpleadoData();
  sectorData: SectorData = new SectorData();
  sectorDatas: SectorData[];
  sectoresClientes: HeadQuarters[];
  sectoresCli: HeadQuarters = new HeadQuarters();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _headQuartersService: HeadQuartersService,
    private _sectorDataService: SectorService,
    private _typeEmployeesDataService: TypeEmployeesService,
    private datosb: datosbasicos,

) {

  this.loadSector();
  this.loadTypeEmployees();
  this.ngOnitInit();
  this.consultaSectoresCliente();
  }

  ngOnitInit() {

      this.idCliente = this.datosb.getid();
  }


  loadTypeEmployees() {
    this._typeEmployeesDataService.getTypeEmployees()
    .subscribe(typeEmployeesDatas => this.typeEmployeesDatas = typeEmployeesDatas, error => this.msgError = <any>error);
  }

  consultaSectoresCliente() {
    if( this.datosb.getid() != null) {
      this._headQuartersService.getSectoresCliente(this.datosb.getid())
      .subscribe(sectoresClientes => this.sectoresClientes = sectoresClientes, error => this.msgError = <any>error);
    }

  }

  loadSector() {
    this._sectorDataService.getSector()
    .subscribe(sectorDatas => this.sectorDatas = sectorDatas, error => this.msgError = <any>error);
  }

  resetForm() {
    if(confirm("¿Desea cancelar la acción?")==true){
      this.headQuarter=new HeadQuarters();

    }

  }
  goBusiness() {
    if(confirm("¿Desea guardar y agregar un Negocio?")==true){

      //this.saveHeadQuarters();
      let link = ['pages/accountmanagement/businessdata'];
      this.router.navigate(link);
    }


  }

  saveHeadQuarters() {

    if(this.idCliente===null || this.idCliente===undefined){
      alert("Es necesario buscar el cliente");
      return;
    }
    if(confirm("¿Desea guardar una Sede?")==true){
      this.headQuarter.clienteid= this.idCliente;
     this._headQuartersService.addHeadQuarter(this.headQuarter)
       .subscribe(
       rt => console.log(rt),
       error => this.msgError = <any>error,
       () => console.log('Terminado'),
       );
    }
    ;
  }

}
