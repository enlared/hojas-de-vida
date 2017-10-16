import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { OppositionService } from '../../../../theme/services/oppositionService/opposition.service';
import { OppositionData } from '../../../../theme/services/oppositionService/opposition';
import { TypeMachineService } from '../../../../theme/services/totalService/typeMachine.service';
import { CategoryOppositionService } from '../../../../theme/services/totalService/categoryOpposition.service';
import { Utilidades } from '../../../../theme/services/Utilidades.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { cache } from '../../../../theme/services/cache';

import { IMyDpOptions } from 'mydatepicker';


@Component({
  selector: 'opposition',
  templateUrl: './opposition.html',
  styleUrls: ['./opposition.scss']
})
export class Opposition {
  msgError: string;
  oppositionDatas: OppositionData[];
  oppositionList: OppositionData[];
  oppositionData: OppositionData = new OppositionData();
  categoryDatas: ParametroGenerico[];
  categoryData: ParametroGenerico = new ParametroGenerico();
  typeMachineDatas: ParametroGenerico[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _oppositionDataService: OppositionService,
    private _categoryDataService: CategoryOppositionService,
    private _typeMachineDataService: TypeMachineService,
    private util: Utilidades,
    private cache: cache,

  ) {
    this.loadTypeMachine();
    this.loadCategory();
    this.ngOnitInit();
  }

  ngOnitInit() {
    if (this.cache.getid() === null || this.cache.getid() === undefined) {
      alert('Es necesario buscar el cliente');

      const link = ['pages/accountmanagement/Generaldata'];
      this.router.navigate(link);
    }
    this.actualizar(null);
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
      this.limpiar();

    }

  }
  loadTypeMachine() {
    this._typeMachineDataService.getTypeMachine()
      .subscribe(typeMachineDatas => this.typeMachineDatas = typeMachineDatas, error => this.msgError = <any>error);
  }

  loadCategory() {
    this._categoryDataService.getCategory()
      .subscribe(categoryData => this.categoryDatas = categoryData, error => this.msgError = <any>error);
  }

  loadOpposition() {
    const opposition: OppositionData = new OppositionData();
    opposition.clienteid = this.cache.getid();
    this._oppositionDataService.getOpposition(opposition)
      .subscribe(oppositionList => this.oppositionList = oppositionList, error => this.msgError = <any>error);
  }

  saveOpposition() {
    if (confirm("¿Desea guardar información de la competencia?") == true) {
      this.oppositionData.clienteid = this.cache.getid();
      this._oppositionDataService.addOpposition(this.oppositionData)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => this.limpiar(),
      );
    }
  }


  actualizar(datos) {
    this.loadOpposition();
  }
  limpiar() {
    this.oppositionData = new OppositionData();
  }
  validarNombre() {
    this.oppositionData.nombre = this.util.validarTexto(this.oppositionData.nombre);
    $("#nameCompetence").val(this.oppositionData.nombre).change();
  }
  remove(data) {
    this._oppositionDataService.deleteOpposition(data)
      .subscribe(rt => this.actualizar(rt),
      error => this.msgError = <any>error);
  }
  editar(data) {
    this.oppositionData = data;
    this.oppositionData.categoriaCompetencia = this.seleccionarCompetencia(data.categoriaCompetencia);
    this.oppositionData.tipoMaquina = this.seleccionarMaquinas(data.tipoMaquina);

  }

  seleccionarCompetencia(data) {
    let seleccion;
    this.categoryDatas.forEach(element => {
      if ( element.id === data.id) {
        seleccion = element;
      }
    });
  return seleccion;
  }

  seleccionarMaquinas(data) {
    let seleccion;
    this.typeMachineDatas.forEach(element => {
      if ( element.id === data.id) {
        seleccion = element;
      }
    });
  return seleccion;
  }
}
