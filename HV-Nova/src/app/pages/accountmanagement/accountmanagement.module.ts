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
import { KeyAccountService } from '../../theme/services/totalService/keyAccount.service'; 
import { KeyAccountData } from '../../theme/services/totalService/keyAccount'; 
import { KeyBusinessService } from '../../theme/services/totalService/keyBusiness.service'; 
import { KeyBusinessData } from '../../theme/services/totalService/keyBusiness'; 
import { SectorService } from '../../theme/services/totalService/sector.service'; 
import { SectorData } from '../../theme/services/totalService/sector'; 
import { TypeEmployeesService } from '../../theme/services/totalService/typeEmployees.service'; 
import { TypeEmployeesData } from '../../theme/services/totalService/typeEmployees'; 
import { RegionalsService } from '../../theme/services/totalService/regionals.service'; 
import { RegionalsData } from '../../theme/services/totalService/regionals';
import { HeadQuartersService } from '../../theme/services/headQuartersService/headQuarters.service';
import { BusinessDataService } from '../../theme/services/businessDataService/businessData.service';
import { GeneralDataService } from '../../theme/services/generalDataService/generalData.service';
import { ContactsService } from '../../theme/services/contactsService/contacts.service';
import { ContactsData } from '../../theme/services/contactsService/contactsData';
import { ServiceLevelsService } from '../../theme/services/serviceLevelsService/serviceLevels.service';
import { OppositionService } from '../../theme/services/oppositionService/opposition.service';
import { CategoryService } from '../../theme/services/totalService/category.service'; 
import { CategoryData } from '../../theme/services/totalService/category'; 
import { ListPricesService } from '../../theme/services/totalService/listPrices.service'; 
import { ListPricesData } from '../../theme/services/totalService/listPrices'; 
import { TypeMachineService } from '../../theme/services/totalService/typeMachine.service'; 
import { TypeMachineData } from '../../theme/services/totalService/typeMachine'; 
import { TypeNegociationService } from '../../theme/services/totalService/typeNegociation.service'; 
import { TypeNegociationData } from '../../theme/services/totalService/typeNegociation'; 
import { AnchorageService } from '../../theme/services/totalService/anchorage.service'; 
import { AnchorageData } from '../../theme/services/totalService/anchorage'; 
import { ContactHseqService } from '../../theme/services/totalService/contactHseq.service'; 
import { ContactHseqData } from '../../theme/services/totalService/contactHseq'; 
import { PurseService } from '../../theme/services/totalService/purse.service'; 
import { PurseData } from '../../theme/services/totalService/purse'; 
import { BillingService } from '../../theme/services/totalService/billing.service'; 
import { BillingData } from '../../theme/services/totalService/billing'; 
import { DateEspecialsService } from '../../theme/services/totalService/dateEspecials.service'; 
import { DateEspecialsData } from '../../theme/services/totalService/dateEspecials'; 
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
    ContactsService,
    ServiceLevelsService,
    OppositionService,
    TypeEmployeesService,
    SectorService,
    KeyAccountService,
    KeyBusinessService,
    RegionalsService,
    AnchorageService,
    ListPricesService,
    TypeNegociationService,
    TypeMachineService,
    CategoryService,
    ContactHseqService,
    PurseService,
    BillingService,
    DateEspecialsService,
  ]
})
export class AccountmanagementModule {
}
