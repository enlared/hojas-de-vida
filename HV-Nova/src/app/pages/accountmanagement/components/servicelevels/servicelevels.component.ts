import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ServiceLevelsService } from '../../../../theme/services/serviceLevelsService/serviceLevels.service';
import { ServiceLevelsData } from '../../../../theme/services/serviceLevelsService/serviceLevels';
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
    constructor(
      private route: ActivatedRoute,
      private router: Router,
      private _serviceLevelsService: ServiceLevelsService,
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


