import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { OppositionService } from '../../../../theme/services/oppositionService/opposition.service';
import { OppositionData } from '../../../../theme/services/oppositionService/opposition';
import { TypeMachineService } from '../../../../theme/services/totalService/typeMachine.service';
import { TypeMachineData } from '../../../../theme/services/totalService/typeMachine';
import { CategoryService } from '../../../../theme/services/totalService/category.service';
import { CategoryData } from '../../../../theme/services/totalService/category';

import { IMyDpOptions } from 'mydatepicker';


@Component({
  selector: 'opposition',
  templateUrl: './opposition.html',
  styleUrls: ['./opposition.scss']
})
export class Opposition {
  msgError: string;
  oppositionDatas: OppositionData[];
  oppositionData: OppositionData = new OppositionData();
  categoryDatas: CategoryData[];
  categoryData: CategoryData = new CategoryData();
  typeMachineDatas: TypeMachineData[];
  typeMachineData: TypeMachineData = new TypeMachineData();
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _oppositionDataService: OppositionService,
    private _categoryDataService: CategoryService,
    private _typeMachineDataService: TypeMachineService,
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


  saveOpposition() {
    if (confirm("¿Desea guardar información de la competencia?") == true) {

      this._oppositionDataService.addOpposition(this.oppositionData)
        .subscribe(
        rt => console.log(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }
}
