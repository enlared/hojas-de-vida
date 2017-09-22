import {Component} from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { HeadQuartersService } from '../../../../theme/services/headQuartersService/headQuarters.service';
import { HeadQuarters } from '../../../../theme/services/headQuartersService/headQuarters';
import { IMyDpOptions } from 'mydatepicker';

@Component({
  selector: 'headquarters',
  templateUrl: './headquarters.html',
  styleUrls: ['./headquarters.scss']
})
export class Headquarters {

  msgError: string;
  headQuarters: HeadQuarters[];
  headQuarter: HeadQuarters = new HeadQuarters();
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _headQuartersService: HeadQuartersService,
) {

  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }


  resetForm() {
    if(confirm("¿Desea cancelar la acción?")==true){
      this.headQuarter.idhqrt= null;
      this.headQuarter.name = '';
      this.headQuarter.nameSector = '';
      this.headQuarter.number = null;
     
    }
  
  }
  goBusiness() {
    if(confirm("¿Desea guardar y agregar un Negocio?")==true){

      //this.saveHeadQuarters();
      let link = ['pages/accountmanagement/businessdata'];
      this.router.navigate(link);
    }
    
  
  }

  saveHeadQuarters() {
    if(confirm("¿Desea guardar una Sede?")==true){
    
     this._headQuartersService.addHeadQuarter(this.headQuarter)
       .subscribe(
       rt => console.log(rt),
       error => this.msgError = <any>error,
       () => console.log('Terminado'),
       );
    }
  }

}
