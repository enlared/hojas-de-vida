import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ServiceLevelsService } from '../../../../theme/services/serviceLevelsService/serviceLevels.service';
import { ServiceLevelsData } from '../../../../theme/services/serviceLevelsService/serviceLevels';
import { BillingService } from '../../../../theme/services/totalService/billing.service';
import { BillingData } from '../../../../theme/services/totalService/billing';
import { DateEspecialsService } from '../../../../theme/services/totalService/dateEspecials.service';
import { DateEspecialsData } from '../../../../theme/services/totalService/dateEspecials';
import { IMyDpOptions } from 'mydatepicker';

@Component({
    selector: 'servicelevels',
    styleUrls: ['./servicelevels.scss'],
    templateUrl: './servicelevels.html'
})
export class Servicelevels {

    msgError: string;
    serviceLevels: ServiceLevelsData[];
    serviceLevel: ServiceLevelsData = new ServiceLevelsData();
    billingData: BillingData[];
    billingDatas: BillingData = new BillingData();
    dateEspecialsData: DateEspecialsData[];
    dateEspecialsDatas: DateEspecialsData = new DateEspecialsData();
    constructor(
      private route: ActivatedRoute,
      private router: Router,
      private _serviceLevelsService: ServiceLevelsService,
      private _billingService: BillingService,
      private _dateEspecialsService : DateEspecialsService,
    ) {
  
    }
  
    ngOnitInit() {
      let id = this.route.snapshot.params['id'];
      if (!id) return;
      console.log(id);
    }
  
  
    resetForm() {
      if (confirm("¿Desea cancelar la acción?") == true) {
    
      }
  
    }
    goCompetence() {
      if (confirm("¿Desea guardar y agregar la competencia?") == true) {
  
        //this.saveBusinessData();
        let link = ['pages/accountmanagement/opposition'];
        this.router.navigate(link);
      }
  
  
    }
  
    saveServiceLevels() {
      if (confirm("¿Desea guardar un SLA?") == true) {
  
        this._serviceLevelsService.addServiceLevels(this.serviceLevel)
          .subscribe(
          rt => console.log(rt),
          error => this.msgError = <any>error,
          () => console.log('Terminado'),
        );
      }
    }
  
    }


