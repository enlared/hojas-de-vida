import { Component, Input } from '@angular/core';
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
import { cache } from '../../../../theme/services/cache';
import { Utilidades } from '../../../../theme/services/Utilidades.service';

@Component({
  selector: 'headquarters',
  templateUrl: './headquarters.html',
  styleUrls: ['./headquarters.scss'],
})
export class Headquarters {

  msgError: string;
  @Input() idCliente: number;
  headQuarters: HeadQuarters[];
  headQuarter: HeadQuarters = new HeadQuarters();
  typeEmployeesDatas: TipoEmpleadoData[];
  typeEmployeesData: TipoEmpleadoData = new TipoEmpleadoData();
  sectorData: SectorData = new SectorData();
  sectorDatas: SectorData[];
  sectoresClientes: HeadQuarters[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _headQuartersService: HeadQuartersService,
    private _sectorDataService: SectorService,
    private _typeEmployeesDataService: TypeEmployeesService,
    private cache: cache,
    private utilidades:Utilidades,
  ) {
    this.loadSector();
    this.loadTypeEmployees();
    this.ngOnitInit();
    this.consultaSectoresCliente();
  }

  ngOnitInit() {

    this.idCliente = this.cache.getid();
    if (this.cache.getid() === null || this.cache.getid() === undefined) {
      alert('Es necesario buscar el cliente');

      const link = ['pages/accountmanagement/Generaldata'];
      this.router.navigate(link);
    }
  }


  loadTypeEmployees() {
    this._typeEmployeesDataService.getTypeEmployees()
      .subscribe(typeEmployeesDatas => this.typeEmployeesDatas = typeEmployeesDatas, error => this.msgError = <any>error);
  }

  consultaSectoresCliente() {
    if (this.cache.getid() != null) {
      this._headQuartersService.getSectoresCliente(this.cache.getid())
        .subscribe(sectoresClientes => this.sectoresClientes = sectoresClientes, error => this.msgError = <any>error);
    }

  }

  loadSector() {
    this._sectorDataService.getSector()
      .subscribe(sectorDatas => this.sectorDatas = sectorDatas, error => this.msgError = <any>error);
  }

  resetForm() {
    if (confirm('¿Desea cancelar la acción?')) {
      this.headQuarter = new HeadQuarters();

    }

  }
  goBusiness() {
    if (confirm('¿Desea guardar y agregar un Negocio?')) {
      const link = ['pages/accountmanagement/businessdata'];
      this.router.navigate(link);
    }


  }

  saveHeadQuarters() {

    if (this.idCliente === null || this.idCliente === undefined) {
      alert('Es necesario buscar el cliente');
      return;
    }
    if (confirm('¿Desea guardar una Sede?')) {
      this.headQuarter.clienteid = this.idCliente;
      this._headQuartersService.addHeadQuarter(this.headQuarter)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }

  }
  editar(data) {
    this.headQuarter = data;
    this.headQuarter.tipoempleado = this.seleccionarTipoEmpleado(data.tipoempleado);
    this.headQuarter.sector = this.seleccionarSector(data.sector);

  }

  seleccionarTipoEmpleado(data: TipoEmpleadoData): TipoEmpleadoData {
    let seleccion;
    this.typeEmployeesDatas.forEach(element => {
      if ( element.id === data.id) {
        seleccion = element;
      }
    });
  return seleccion;
  }

  seleccionarSector(data: SectorData): SectorData {
    let seleccion;
    this.sectorDatas.forEach(element => {
      if ( element.id === data.id) {
        seleccion = element;
      }
    });
  return seleccion;
  }

  eliminar(data) {

    if (confirm('¿Desea eliminar la Sede?')) {
      this._headQuartersService.deleteHeadQuartes(data)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }

  }

  actualizar(rt) {
    this.consultaSectoresCliente();
  }

  validarNumero() {
    this.headQuarter.cantidadempleados= this.utilidades.validarTelefono(this.headQuarter.cantidadempleados);
    $("#numberEmployees").val(this.headQuarter.cantidadempleados).change();
  }
}
