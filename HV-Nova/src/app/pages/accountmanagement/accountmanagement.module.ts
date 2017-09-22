import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';

import { NgaModule } from '../../theme/nga.module';
import { FormsModule } from '@angular/forms';

import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { routing } from './accountmanagement.routing';
import { Accountmanagement } from './accountmanagement.component';
import { Headquarters } from './components/headquarters/headquarters.component';
import { HttpModule } from '@angular/http';
import { Businessdata } from './components/businessdata/businessdata.component';
import { Contacts } from './components/contacts/contacts.component';
import { Servicelevels } from './components/servicelevels/servicelevels.component';
import { Generaldata } from './components/generaldata/generaldata.component';
import { Opposition } from './components/opposition/opposition.component';


import { HeadQuartersService } from '../../theme/services/headQuartersService/headQuarters.service';
import { BusinessDataService } from '../../theme/services/businessDataService/businessData.service';
import { GeneralDataService } from '../../theme/services/generalDataService/generalData.service';
import { MyDatePickerModule } from 'mydatepicker';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    NgbDropdownModule,
    NgbModalModule,
    HttpModule,
    routing,
    MyDatePickerModule,
  ],
  declarations: [
    Headquarters,

    Businessdata,
    Contacts,
    Servicelevels,
    Generaldata,
    Opposition,
    Accountmanagement,


  ],
  entryComponents: [

  ],
  providers: [
    HeadQuartersService,
    BusinessDataService,
    GeneralDataService,
  ]
})
export class AccountmanagementModule {
}
