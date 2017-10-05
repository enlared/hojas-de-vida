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
import { TypeMachineData } from '../../../../theme/services/totalService/typeMachine';
import { AnchorageService } from '../../../../theme/services/totalService/anchorage.service';
import { AnchorageData } from '../../../../theme/services/totalService/anchorage';
import { CategoryService } from '../../../../theme/services/totalService/category.service';
import { CategoryData } from '../../../../theme/services/totalService/category';
import { ListPricesService } from '../../../../theme/services/totalService/listPrices.service';
import { ListPricesData } from '../../../../theme/services/totalService/listPrices';

@Component({
  selector: 'businessdata',
  templateUrl: './businessdata.html',
  styleUrls: ['./businessdata.scss']
})
export class Businessdata {

  msgError: string;
  businessDatas: BusinessData[];
  businessData: BusinessData = new BusinessData();
  typeMachineDatas: TypeMachineData[];
  typeMachineData: TypeMachineData = new TypeMachineData();
  listPricesDatas: ListPricesData[];
  listPricesData: ListPricesData = new ListPricesData();
  categoryDatas: CategoryData[];
  categoryData: CategoryData = new CategoryData();
  anchorageDatas: AnchorageData[];
  anchorageData: AnchorageData = new AnchorageData();
  typeNegociationDatas: TypeNegociationData[];
  typeNegociationData: TypeNegociationData = new TypeNegociationData();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _businessDataService: BusinessDataService,
    private _typeNegociationDataService: TypeNegociationService,
    private _typeMachineDataService: TypeMachineService,
    private _listPricesDataService: ListPricesService,
    private _categoryDataService: CategoryService,
    private _anchorageDataService: AnchorageService,

  ) {

this.loadAnchorage();
this.loadCategory();
this.loadInformationBusiness();
this.loadListPrices();
this.loadTypeMachine();
this.loadTypeNegociation();

  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
      this.businessData= new BusinessData();

    }

  }
  goContacts() {
    if (confirm("¿Desea guardar y agregar un contacto?") == true) {

      //this.saveBusinessData();
      let link = ['pages/accountmanagement/contacts'];
      this.router.navigate(link);
    }


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
    this._businessDataService.getBusinessDatas()
    .subscribe(businessDatas => this.businessDatas = businessDatas, error => this.msgError = <any>error);
  }

  saveBusinessData() {
    if (confirm("¿Desea guardar un Negocio?") == true) {

      this._businessDataService.addBusinessData(this.businessData)
        .subscribe(
        rt => console.log(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }


}
