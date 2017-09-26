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
import { KeyAccountData } from '../../../../theme/services/totalService/keyAccount'; 
import { RegionalsService } from '../../../../theme/services/totalService/regionals.service'; 
import { RegionalsData } from '../../../../theme/services/totalService/regionals'; 
import { KeyBusinessService } from '../../../../theme/services/totalService/keyBusiness.service'; 
import { KeyBusinessData } from '../../../../theme/services/totalService/keyBusiness'; 

import { IMyDpOptions } from 'mydatepicker';

@Component({
  selector: 'generaldata',
  templateUrl: './generaldata.html',
  styleUrls: ['./generaldata.scss']
})

export class Generaldata {
  msgError: string;
  generalDatas: GeneralData[];
  generalData: GeneralData = new GeneralData();

  keyBusinessData: KeyBusinessData = new KeyBusinessData();
  keyBusinessDatas: KeyBusinessData[];
  keyAccountData: KeyAccountData = new KeyAccountData();
  keyAccountDatas: KeyAccountData[];
  headQuartersData: HeadQuarters = new HeadQuarters();
  headQuartersDatas: HeadQuarters[];
  regionalsData: RegionalsData = new RegionalsData();
  regionalsDatas: RegionalsData[];




  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _generalDataService: GeneralDataService,
    private _keyAccountDataService: KeyAccountService,
    private _keyBusinessDataService: KeyBusinessService,
    private _headQuartersDataService: HeadQuartersService,
    private _regionalsDataService: RegionalsService,

  ) {

this.loadKeyAccounts();
this.loadKeyBusiness();
this.loadRegionals();
this.loadHeadQuarters();

  }

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
      this.generalData.codsap = null;
      this.generalData.idhqrt = '';
      this.generalData.idinfbsn = '';
      this.generalData.idkacnt = '';
      this.generalData.idkbsn = '';
      this.generalData.idrgn = '';
      this.generalData.contractend = '';
      this.generalData.contractstart = '';
      this.generalData.objetivemonth = null;
      this.generalData.objetiveyear = null;

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

  saveGeneralData() {
    if (confirm("¿Desea guardar?") == true) {

      this._generalDataService.addGeneralData(this.generalData)
        .subscribe(
        rt => console.log(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

}
