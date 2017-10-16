import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ServiceLevelsService } from '../../../../theme/services/serviceLevelsService/serviceLevels.service';
import { ServiceLevelsData } from '../../../../theme/services/serviceLevelsService/serviceLevels';
import { CorrectivosService } from '../../../../theme/services/totalService/correctivos.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { FumigacionesService } from '../../../../theme/services/totalService/fumigaciones.service';
import { PreventivosService } from '../../../../theme/services/totalService/preventivos.service';
import { TipoVentaService } from '../../../../theme/services/totalService/tipoVenta.service';
import { PlazoCarteraService } from '../../../../theme/services/totalService/plazoCartera.service';
import { PlazoArriendoService } from '../../../../theme/services/totalService/plazoArriendo.service';
import { CruceCarteraService } from '../../../../theme/services/totalService/cruceCartera.service';
import { RequiereCompraService } from '../../../../theme/services/totalService/requiereCompra.service';
import { cache } from '../../../../theme/services/cache';
import { Utilidades } from '../../../../theme/services/Utilidades.service';

import { IMyDpOptions } from 'mydatepicker';

@Component({
  selector: 'servicelevels',
  styleUrls: ['./servicelevels.scss'],
  templateUrl: './servicelevels.html',
})
export class Servicelevels {

  msgError: string;
  listaserviceLevels: ServiceLevelsData[];
  level: ServiceLevelsData = new ServiceLevelsData();
  listaCorrectivos: ParametroGenerico[];
  listaFumigaciones: ParametroGenerico[];
  listaPreventivos: ParametroGenerico[];
  listaTiposVenta: ParametroGenerico[];
  listaplazosCartera: ParametroGenerico[];
  listaplazosArriendo: ParametroGenerico[];
  listaCruceCartera: ParametroGenerico[];
  listaRequiereCompra: ParametroGenerico[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _serviceLevelsService: ServiceLevelsService,
    private _correctivosService: CorrectivosService,
    private _fumigacionService: FumigacionesService,
    private _preventivosService: PreventivosService,
    private _tipoVentaService: TipoVentaService,
    private _plazoCartera: PlazoCarteraService,
    private _plazoArriendo: PlazoArriendoService,
    private _cruceCartera: CruceCarteraService,
    private _requiereCompra: RequiereCompraService,
    private cache: cache,
    private util: Utilidades,
  ) {
    this.loadCorrectivos();
    this.loadFumigaciones();
    this.loadTipoVenta();
    this.loadPreventivos();
    this.loadPlazoCartera();
    this.loadPlazoArriendo();
    this.loadCruceCartera();
    this.loadRequiereCompra();
    this.ngOnitInit();
    this.actualizar(null);
  }

  ngOnitInit() {
    if (this.cache.getid() === null || this.cache.getid() === undefined) {
      alert('Es necesario buscar el cliente');

      const link = ['pages/accountmanagement/Generaldata'];
      this.router.navigate(link);
    }
  }

  loadCorrectivos() {
    this._correctivosService.getAll()
      .subscribe(listaCorrectivos => this.listaCorrectivos = listaCorrectivos, error => this.msgError = <any>error);
  }

  loadFumigaciones() {
    this._fumigacionService.getAll()
      .subscribe(listaFumigaciones => this.listaFumigaciones = listaFumigaciones, error => this.msgError = <any>error);
  }

  loadPreventivos() {
    this._preventivosService.getAll()
      .subscribe(listaPreventivos => this.listaPreventivos = listaPreventivos, error => this.msgError = <any>error);
  }

  loadTipoVenta() {
    this._tipoVentaService.getAll()
      .subscribe(listaTiposVenta => this.listaTiposVenta = listaTiposVenta, error => this.msgError = <any>error);
  }

  loadPlazoCartera() {
    this._plazoCartera.getAll()
      .subscribe(listaplazosCartera => this.listaplazosCartera = listaplazosCartera, error => this.msgError = <any>error);
  }

  loadPlazoArriendo() {
    this._plazoArriendo.getAll()
      .subscribe(listaplazosArriendo => this.listaplazosArriendo = listaplazosArriendo, error => this.msgError = <any>error);
  }

  loadCruceCartera() {
    this._cruceCartera.getAll()
      .subscribe(listaCruceCartera => this.listaCruceCartera = listaCruceCartera, error => this.msgError = <any>error);
  }

  loadRequiereCompra() {
    this._requiereCompra.getAll()
      .subscribe(listaRequiereCompra => this.listaRequiereCompra = listaRequiereCompra, error => this.msgError = <any>error);
  }

  loadLevels() {
    this._serviceLevelsService.getServiceLevel(this.cache.getid())
      .subscribe(listaserviceLevels => this.listaserviceLevels = listaserviceLevels, error => this.msgError = <any>error);
    }

  resetForm() {
    if (confirm('¿Desea cancelar la acción?')) {
      this.level = new ServiceLevelsData();
    }

  }
  goCompetence() {
    if (confirm('¿Desea agregar la competencia?')) {
      const link = ['pages/accountmanagement/opposition'];
      this.router.navigate(link);
    }


  }

  saveServiceLevels() {
    if (confirm('¿Desea guardar un SLA?')) {
      this.level.clienteid = this.cache.getid();
      this._serviceLevelsService.add(this.level)
        .subscribe(
          rt => this.actualizar(rt),
          error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }
  actualizar(rt) {
    this.loadLevels();

  }
  remove(data) {
    this._serviceLevelsService.deleteServiceLevels(data)
      .subscribe(rt => this.actualizar(rt),
      error => this.msgError = <any>error);
  }
  editar(data) {
    this.level = data;

    this.level.correctivo = this.seleccionarElemento( this.level.correctivo, this.listaCorrectivos);
    this.level.fumigacione = this.seleccionarElemento( this.level.fumigacione, this.listaFumigaciones);
    this.level.preventivo = this.seleccionarElemento( this.level.preventivo, this.listaPreventivos);
    this.level.plazosCartera = this.seleccionarElemento( this.level.plazosCartera, this.listaplazosCartera);
    this.level.plazosArriendo = this.seleccionarElemento( this.level.plazosArriendo, this.listaplazosArriendo);
    this.level.requiereCompra = this.seleccionarElemento( this.level.requiereCompra, this.listaRequiereCompra);
    this.level.tipoVenta = this.seleccionarElemento( this.level.tipoVenta, this.listaTiposVenta);
    this.level.cruceCartera = this.seleccionarElemento( this.level.cruceCartera, this.listaCruceCartera);

  }

  seleccionarElemento(data: ParametroGenerico, lista) {
    let seleccion;
    if(data != null) {
      lista.forEach(element => {
        if ( element.id === data.id) {
          seleccion = element;
        }
      });
    }

  return seleccion;
  }

  validarNombre() {
    this.level.especificos = this.util.validarTexto(this.level.especificos);
    $("#especific").val(this.level.especificos).change();
  }


  validarCursosTecnicos() {
    this.level.tecnicoscursos = this.util.validarTexto(this.level.tecnicoscursos);
    $("#curses").val(this.level.tecnicoscursos).change();
  }

  validartecnicosotros() {
    this.level.tecnicosotros = this.util.validarTexto(this.level.tecnicosotros);
    $("#others").val(this.level.tecnicosotros).change();
  }

  validarbrigadalimpieza() {
    this.level.tecnicosotros = this.util.validarTexto(this.level.tecnicosbrigadalimpieza);
    $("#brigade").val(this.level.tecnicosbrigadalimpieza).change();
  }
  validarOperacionesCursos() {
    this.level.operacionescursos = this.util.validarTexto(this.level.operacionescursos);
    $("#operationCurses").val(this.level.operacionescursos).change();
  }

  validarFranjaHoraria() {
    this.level.operacionesfranjashorarias = this.util.validarTexto(this.level.operacionesfranjashorarias);
    $("#timeszones").val(this.level.operacionesfranjashorarias).change();
  }

  validarLugarRadicacion() {
    this.level.facturacionlugarradicacion = this.util.validarTexto(this.level.facturacionlugarradicacion);
    $("#place").val(this.level.facturacionlugarradicacion).change();
  }

  validarMotivo() {
    this.level.facturacionmotivo = this.util.validarTexto(this.level.facturacionmotivo);
    $("#motive").val(this.level.facturacionmotivo).change();
  }
}


