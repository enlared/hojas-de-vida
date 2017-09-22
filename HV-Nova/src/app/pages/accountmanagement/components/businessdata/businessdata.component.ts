import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BusinessDataService } from '../../../../theme/services/businessDataService/businessData.service';
import { BusinessData } from '../../../../theme/services/businessDataService/businessData';
import { IMyDpOptions } from 'mydatepicker';

@Component({
  selector: 'businessdata',
  templateUrl: './businessdata.html',
  styleUrls: ['./businessdata.scss']
})
export class Businessdata {

  msgError: string;
  businessDatas: BusinessData[];
  businessData: BusinessData = new BusinessData();
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _businessDataService: BusinessDataService,
  ) {

  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
      this.businessData.idinfbsn = null;
      this.businessData.idanchg = null;
      this.businessData.idanlcmp = null;
      this.businessData.idctg = null;
      this.businessData.idlstprc = null;
      this.businessData.idsla = null;
      this.businessData.numbermachine = null;
      this.businessData.totalsale = null;
      this.businessData.typeglass = '';

    }

  }
  goContacts() {
    if (confirm("¿Desea guardar y agregar un contacto?") == true) {

      //this.saveBusinessData();
      let link = ['pages/accountmanagement/contacts'];
      this.router.navigate(link);
    }


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
