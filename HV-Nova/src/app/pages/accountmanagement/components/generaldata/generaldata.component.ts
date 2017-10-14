import { Component, Input, Output } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { GeneralData } from '../../../../theme/services/generalDataService/generalData';
import { GeneralDataService } from '../../../../theme/services/generalDataService/generalData.service';
import { HeadQuarters } from '../../../../theme/services/headQuartersService/headQuarters';
import { HeadQuartersService } from '../../../../theme/services/headQuartersService/headQuarters.service';
import { KeyAccountService } from '../../../../theme/services/totalService/keyAccount.service';
import { EjecutivoCuenta } from '../../../../theme/services/totalService/EjecutivoCuenta';
import { RegionalsService } from '../../../../theme/services/totalService/regionals.service';
import { RegionalsData } from '../../../../theme/services/totalService/regionals';
import { EjecutivoNegociosService } from '../../../../theme/services/totalService/EjecutivoNegocios.service';
import { EjecutivoNegocios } from '../../../../theme/services/totalService/EjecutivoNegocios';
import { TipoCliente } from '../../../../theme/services/totalService/TipoCliente';
import { TipoClienteService } from '../../../../theme/services/totalService/TipoCliente.service';
import { IMyDpOptions } from 'mydatepicker';
import { cache } from '../../../../theme/services/cache';
import { Utilidades } from '../../../../theme/services/Utilidades.service';

@Component({
  selector: 'generaldata',
  templateUrl: './generaldata.html',
  styleUrls: ['./generaldata.scss'],
})

export class Generaldata {

  msgError: string;
  mostrarDataCliente: boolean = false;
  dataEdicion: boolean = false;

  generalDatas: GeneralData[];
  generalData: GeneralData = new GeneralData();

  keyBusinessData: EjecutivoNegocios = new EjecutivoNegocios();
  keyBusinessDatas: EjecutivoNegocios[];
  keyAccountData: EjecutivoCuenta = new EjecutivoCuenta();
  keyAccountDatas: EjecutivoCuenta[];
  headQuartersData: HeadQuarters = new HeadQuarters();
  headQuartersDatas: HeadQuarters[];

  tipoCliente: TipoCliente = new TipoCliente();
  tipoClientes: TipoCliente[];

  regionalsData: RegionalsData = new RegionalsData();
  regionalsDatas: RegionalsData[];
  idCliente: string;
  regexTest: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _generalDataService: GeneralDataService,
    private _keyAccountDataService: KeyAccountService,
    private _keyBusinessDataService: EjecutivoNegociosService,
    private _headQuartersDataService: HeadQuartersService,
    private _regionalsDataService: RegionalsService,
    private _tipoClienteService: TipoClienteService,
    private cache: cache,
    private utilidades: Utilidades,
  ) {

    this.loadKeyAccounts();
    this.loadKeyBusiness();
    this.loadRegionals();
    this.loadHeadQuarters();
    this.loadTipoCliente();
    this.regexTest = this.utilidades.getRegexLetras;

  }

  myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd',
  };

  ngOnitInit() {

    if (this.cache != null) {
      this.dataEdicion = true;
      this.consultarId();
    }

  }


  resetForm() {
    if (confirm('¿Desea cancelar la acción?')) {
      this.generalData = new GeneralData();
      this.generalData.fechaFinObjeto = null;
      this.generalData.fechaInicioObjeto = null;
      this.dataEdicion = false;

    }

  }
  goSedes() {
    if (confirm('¿Desea guardar y agregar una Sede?')) {
      if (this.validarFormulario()) {
        this.cache.setid(this.generalData.id);
        const link = ['pages/accountmanagement/headquarters'];
        this.router.navigate(link);
      }

    }
  }

  validarFormulario(): boolean {
    return this.validarVigenciaContrato();
  }

  loadKeyAccounts() {
    this._keyAccountDataService.getKeyAccount()
      .subscribe(keyAccountDatas => this.keyAccountDatas = keyAccountDatas, error => this.msgError = <any>error);
  }

  loadKeyBusiness() {
    this._keyBusinessDataService.getKeyBusiness()
      .subscribe(keyBusinessDatas => this.keyBusinessDatas = keyBusinessDatas, error => this.msgError = <any>error);
  }

  loadRegionals() {
    this._regionalsDataService.getRegionals()
      .subscribe(regionalsDatas => this.regionalsDatas = regionalsDatas, error => this.msgError = <any>error);
  }

  loadHeadQuarters() {
    this._headQuartersDataService.getHeadQuarters()
      .subscribe(headQuartersData => this.headQuartersDatas = headQuartersData, error => this.msgError = <any>error);
  }

  loadTipoCliente() {
    this._tipoClienteService.getTipoClienteAll()
      .subscribe(tipoCliente => this.tipoClientes = tipoCliente, error => this.msgError = <any>error);

  }

  saveGeneralData() {

    if (confirm('¿Desea guardar?')) {
      this.generalData.fechafin = this.generalData.fechaFinObjeto.formatted;
      this.generalData.fechainicio = this.generalData.fechaInicioObjeto.formatted;
      if (this.validarFormulario()) {
        this._generalDataService.addGeneralData(this.generalData)
          .subscribe(
          rt => console.log(rt),
          error => this.msgError = <any>error,
          () => console.log('Terminado'),
        );
        alert('Cliente Guardado Con exito');

      }

    }
    this.dataEdicion = true;

  }

  cargarConsulta(datos: GeneralData) {
    this.cache.setid(datos.id);
    this.dataEdicion = true;
    this.generalData = datos;
    this.generalData.fechaFinObjeto = this.crearFechaDate(datos.fechafin);
    this.generalData.fechaInicioObjeto = this.crearFechaDate(datos.fechainicio);
    this.generalData.tipoCliente = this.seleccionarTipoCliente(this.generalData.tipoCliente);
    this.generalData.ejecutivoNegocio = this.seleccionarEjecutivoNegocio(this.generalData.ejecutivoNegocio);
    this.generalData.ejecutivoCuenta = this.seleccionarEjecutivoCuenta(this.generalData.ejecutivoCuenta);
    this.generalData.regional = this.seleccionarRegional(this.generalData.regional);

  }

  seleccionarTipoCliente(tipoCliente: TipoCliente) {
    let tipoClienteSeleccion;
    this.tipoClientes.forEach(element => {
      if (tipoCliente.id === element.id) {
        tipoClienteSeleccion = element;
      }
    });
    return tipoClienteSeleccion;
  }

  crearFechaDate(formater) {
    let dato = new Date(formater);

    let fecha = {
      'date': {
        'year': dato.getFullYear(),
        'month': dato.getMonth() + 1,
        'day': dato.getDate(),
      },
      'jsdate': formater + 'T05:00:00.000Z',
      'formatted': formater,
      'epoc': 1507438800,
    };

    return fecha;
  }

  seleccionarEjecutivoNegocio(ejecutivo: EjecutivoNegocios) {
    let seleccion;
    this.keyBusinessDatas.forEach(element => {
      if (ejecutivo.id === element.id) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarEjecutivoCuenta(ejecutivo: EjecutivoCuenta) {
    let seleccion;
    this.keyAccountDatas.forEach(element => {
      if (ejecutivo.id === element.id) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarRegional(regional: RegionalsData) {
    let seleccion;
    this.regionalsDatas.forEach(element => {
      if (regional.id === element.id) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  consultarCliente() {
    this.mostrarDataCliente = true;

    this._generalDataService.consultarClienteCodigoSap(this.generalData)
      .subscribe(
      rt => this.cargarConsulta(rt),
      error => this.msgError = <any>error,
      () => console.log('Terminado'),
    );
  }

  clienteNuevoCliente() {
    this.mostrarDataCliente = true;
    this.generalData = new GeneralData();
  }


  consultarId() {
    this.mostrarDataCliente = true;

    this._generalDataService.getGeneralData(this.idCliente)
      .subscribe(
      rt => this.cargarConsulta(rt),
      error => this.msgError = <any>error,
      () => console.log('Terminado'),
    );
  }

  validarNombre() {
    this.generalData.razonsocial = this.utilidades.validarTexto(this.generalData.razonsocial);
    $("#nameComercial").val(this.generalData.razonsocial).change();
  }

  validarNit() {
    this.generalData.nit = this.utilidades.validarTelefono(this.generalData.nit);
    $("#nit").val(this.generalData.nit).change();
  }
  validarDireccion() {
    this.generalData.direccion = this.utilidades.validarTexto(this.generalData.direccion);
    $("#address").val(this.generalData.direccion).change();
  }

  validarBarrio() {
    this.generalData.barrio = this.utilidades.validarTexto(this.generalData.barrio);
    $("#barrio").val(this.generalData.barrio).change();
  }
  validarTelefono() {
    this.generalData.telfonofijo = this.utilidades.validarTelefono(this.generalData.telfonofijo);
    $("#telephone").val(this.generalData.telfonofijo).change();
  }

  validarCelular() {
    this.generalData.numerocelular = this.utilidades.validarTelefono(this.generalData.numerocelular);
    $("#celphone").val(this.generalData.numerocelular).change();
  }

  validarEmail(valor) {
    if (this.utilidades.validarEmail(valor)) {
      alert('Email: Campo requerido');
    }
  }

  validarVigenciaContrato(): boolean {
    if (this.generalData.fechaFinObjeto === null || this.generalData.fechaFinObjeto === undefined) {
      alert('La fecha de inicio debe ser ingresada');
      return false;
    }
    if (this.generalData.fechaFinObjeto === null || this.generalData.fechaFinObjeto === undefined) {
      alert('La fecha de fin debe ser ingresada');
      return false;
    }
    const dateObj = new Date(this.generalData.fechaInicioObjeto.formatted);
    const dateFin = new Date(this.generalData.fechaFinObjeto.formatted);

    if (dateObj > dateFin) {
      alert('La fecha de inicio no puede ser mayor, que la fecha fin del contrato');
      return false;
    }
    return true;
  }
}
