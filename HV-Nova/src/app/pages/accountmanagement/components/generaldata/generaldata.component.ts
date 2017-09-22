import {Component} from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BusinessDataService } from '../../../../theme/services/businessDataService/businessData.service';
import { GeneralData } from '../../../../theme/services/generalDataService/generalData';
import { GeneralDataService } from '../../../../theme/services/generalDataService/generalData.service';
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
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _generalDataService: GeneralDataService,
  ) {

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
      this.generalData.address = '';
      this.generalData.barrio = '';
      this.generalData.celphone = '';
      this.generalData.email = '';
      this.generalData.telephone = '';

    }

  }
  goSedes() {
    if (confirm("¿Desea guardar y agregar una Sede?") == true) {

      //this.saveGeneralData();
      let link = ['pages/accountmanagement/headquarters'];
      this.router.navigate(link);
    }


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
