import { NgModule } from '@angular/core';
import { CommonModule }  from '@angular/common';
import { NgaModule } from '../../theme/nga.module';
import { FormsModule } from '@angular/forms';

import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { routing } from './dynamicreports.routing';
import { Dynamicreports } from './dynamicreports.component';
import { Reports } from './components/reports/reports.component';




@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    NgbModalModule,
    routing,
  ],
  declarations: [
    Dynamicreports,
    Reports,
   
  ],
   entryComponents: [
   
  ],
  providers: [
  
  ]
})
export class DynamicreportsModule {
}

