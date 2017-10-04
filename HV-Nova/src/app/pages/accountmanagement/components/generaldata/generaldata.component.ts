import {Component} from '@angular/core';
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

@Component({
  selector: 'generaldata',
  templateUrl: './generaldata.html',
  styleUrls: ['./generaldata.scss']
})

export class Generaldata {
  msgError: string;
  mostrarDataCliente: boolean= false;

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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _generalDataService: GeneralDataService,
    private _keyAccountDataService: KeyAccountService,
    private _keyBusinessDataService: EjecutivoNegociosService,
    private _headQuartersDataService: HeadQuartersService,
    private _regionalsDataService: RegionalsService,
    private _tipoClienteService: TipoClienteService,

  ) {

this.loadKeyAccounts();
this.loadKeyBusiness();
this.loadRegionals();
this.loadHeadQuarters();
this.loadTipoCliente();
  }

  public myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd',
  };

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
      this.generalData = new GeneralData();


    }

  }
  goSedes() {
    if (confirm("¿Desea guardar y agregar una Sede?") == true) {

      //this.saveGeneralData();
      let link = ['pages/accountmanagement/headquarters'];
      this.router.navigate(link);
    }


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
    if (confirm("¿Desea guardar?") == true) {
      this.generalData.fechafin = this.generalData.fechaFinObjeto.formatted;
      this.generalData.fechainicio = this.generalData.fechaInicioObjeto.formatted;

      this._generalDataService.addGeneralData(this.generalData)
        .subscribe(
        rt => console.log(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  cargarConsulta(datos: GeneralData) {
    this.generalData = datos;
    this.generalData.fechaFinObjeto = datos.fechafin;
    this.generalData.fechaInicioObjeto = datos.fechainicio;
    this.generalData.tipoCliente = this.seleccionarTipoCliente(this.generalData.tipoCliente);
    this.generalData.ejecutivoNegocio = this.seleccionarEjecutivoNegocio(this.generalData.ejecutivoNegocio);
    this.generalData.ejecutivoCuenta = this.seleccionarEjecutivoCuenta(this.generalData.ejecutivoCuenta);
    this.generalData.regional = this.seleccionarRegional(this.generalData.regional);

  }

  seleccionarTipoCliente(tipoCliente: TipoCliente){
    let tipoClienteSeleccion;
    this.tipoClientes.forEach(element => {
      if( tipoCliente.id === element.id ) {
        tipoClienteSeleccion = element;
      }
    });
    return tipoClienteSeleccion;
  }

  seleccionarEjecutivoNegocio(ejecutivo: EjecutivoNegocios){
    let seleccion;
    this.keyBusinessDatas.forEach(element => {
      if( ejecutivo.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarEjecutivoCuenta(ejecutivo: EjecutivoCuenta){
    let seleccion;
    this.keyAccountDatas.forEach(element => {
      if( ejecutivo.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarRegional(regional: RegionalsData) {
    let seleccion;
    this.regionalsDatas.forEach(element => {
      if( regional.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  consultarCliente(){
    this.mostrarDataCliente = true;

    this._generalDataService.consultarClienteCodigoSap(this.generalData)
    .subscribe(
    rt =>   this.cargarConsulta(rt),
    error => this.msgError = <any>error,
    () => console.log('Terminado'),
  );
  }
}
