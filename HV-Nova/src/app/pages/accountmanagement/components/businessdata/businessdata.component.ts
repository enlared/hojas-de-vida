import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BusinessDataService } from '../../../../theme/services/businessDataService/businessData.service';
import { BusinessData } from '../../../../theme/services/businessDataService/businessData';
import { IMyDpOptions } from 'mydatepicker';
import { TypeNegociationService } from '../../../../theme/services/totalService/typeNegociation.service';
import { TypeNegociationData } from '../../../../theme/services/totalService/typeNegociation';
import { TypeMachineService } from '../../../../theme/services/totalService/typeMachine.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { AnchorageService } from '../../../../theme/services/totalService/anchorage.service';
import { AnchorageData } from '../../../../theme/services/totalService/anchorage';
import { CategoryService } from '../../../../theme/services/totalService/category.service';
import { ListPricesService } from '../../../../theme/services/totalService/listPrices.service';
import { ListPricesData } from '../../../../theme/services/totalService/listPrices';
import { cache } from '../../../../theme/services/cache';

@Component({
  selector: 'businessdata',
  templateUrl: './businessdata.html',
  styleUrls: ['./businessdata.scss']
})
export class Businessdata {

  msgError: string;
  businessDatas: BusinessData[];
  businessData: BusinessData = new BusinessData();
  typeMachineDatas: ParametroGenerico[];
  typeMachineData: ParametroGenerico = new ParametroGenerico();
  listPricesDatas: ListPricesData[];
  listPricesData: ListPricesData = new ListPricesData();
  categoryDatas: ParametroGenerico[];
  categoryData: ParametroGenerico = new ParametroGenerico();
  anchorageDatas: AnchorageData[];
  anchorageData: AnchorageData = new AnchorageData();
  typeNegociationDatas: TypeNegociationData[];
  typeNegociationData: TypeNegociationData = new TypeNegociationData();
  businessLists: BusinessData[];
  cliente: BusinessData = new BusinessData();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _businessDataService: BusinessDataService,
    private _typeNegociationDataService: TypeNegociationService,
    private _typeMachineDataService: TypeMachineService,
    private _listPricesDataService: ListPricesService,
    private _categoryDataService: CategoryService,
    private _anchorageDataService: AnchorageService,
    private cache: cache,
  ) {
    this. ngOnitInit();
    this.loadAnchorage();
    this.loadCategory();
    this.loadListPrices();
    this.loadTypeMachine();
    this.loadTypeNegociation();
    this.loadInformationBusiness();

  }

  ngOnitInit() {
    if (this.cache.getid() === null || this.cache.getid() === undefined) {
      alert('Es necesario buscar el cliente');

      const link = ['pages/accountmanagement/generaldata'];
      this.router.navigate(link);
    }
    this.loadInformationBusiness();
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
      this.businessData = new BusinessData();

    }

  }
  goContacts() {
    if (confirm("¿Desea guardar y agregar un contacto?") == true) {

      //this.saveBusinessData();
      let link = ['pages/accountmanagement/contacts'];
      this.router.navigate(link);
    }
    this.loadInformationBusiness();

  }

  loadTypeMachine() {
    this._typeMachineDataService.getTypeMachine()
      .subscribe(typeMachineDatas => this.typeMachineDatas = typeMachineDatas, error => this.msgError = <any>error);
  }

  loadTypeNegociation() {
    this._typeNegociationDataService.getTypeNegociation()
      .subscribe(typeNegociationDatas =>
        this.typeNegociationDatas = typeNegociationDatas, error => this.msgError = <any>error);
  }

  loadCategory() {
    this._categoryDataService.getCategory()
      .subscribe(categoryDatas => this.categoryDatas = categoryDatas, error => this.msgError = <any>error);
  }

  loadAnchorage() {
    this._anchorageDataService.getAnchorage()
      .subscribe(anchorageDatas => this.anchorageDatas = anchorageDatas, error => this.msgError = <any>error);
  }

  loadListPrices() {
    this._listPricesDataService.getListPrices()
      .subscribe(listPricesDatas => this.listPricesDatas = listPricesDatas, error => this.msgError = <any>error);
  }

  loadInformationBusiness() {
    this.cliente.clienteid = this.cache.getid();
    this._businessDataService.getClienteBusinessData(this.cliente)
      .subscribe(businessLists => this.businessLists = businessLists, error => this.msgError = <any>error);
  }

  saveBusinessData() {
    if (confirm("¿Desea guardar un Negocio?") == true) {
      this.businessData.clienteid = this.cache.getid();
      this._businessDataService.addBusinessData(this.businessData)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }
  actualizar(data) {
    this.loadInformationBusiness();

  }

  eliminar(data: BusinessData) {
    if (confirm('¿Desea eliminar la Sede?')) {
      this._businessDataService.deleteBusinessData( data )
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  editar(data: BusinessData) {
    this.businessData = data;
    this.businessData.categoria = this.seleccionarCategoria(data.categoria);
    this.businessData.tipoNegociacion = this.seleccionarTipoNegocio(data.tipoNegociacion);
    this.businessData.anclaje = this.seleccionarAnclaje(data.anclaje);
    this.businessData.listaPrecio = this.seleccionarLIstaPrecio(data.listaPrecio);
    this.businessData.tipoMaquina = this.seleccionarTipoMaquina(data.tipoMaquina);
  }

  seleccionarTipoMaquina(ejecutivo: ParametroGenerico) {
    let seleccion;
    this.typeMachineDatas.forEach(element => {
      if ( ejecutivo.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarLIstaPrecio(data: ListPricesData) {
    let seleccion;
    this.listPricesDatas.forEach(element => {
      if ( data.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarAnclaje(data: AnchorageData) {
    let seleccion;
    this.anchorageDatas.forEach(element => {
      if ( data.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarTipoNegocio(data: TypeNegociationData) {
    let seleccion;
    this.typeNegociationDatas.forEach(element => {
      if ( data.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }

  seleccionarCategoria(data: ParametroGenerico) {
    let seleccion;
    this.categoryDatas.forEach(element => {
      if ( data.id === element.id ) {
        seleccion = element;
      }
    });
    return seleccion;
  }
}
