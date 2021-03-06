import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';

import { NgaModule } from '../../theme/nga.module';
import { FormsModule } from '@angular/forms';

import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { MomentModule } from 'angular2-moment';

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
import { EjecutivoCuenta } from '../../theme/services/totalService/EjecutivoCuenta';
import { EjecutivoNegociosService } from '../../theme/services/totalService/EjecutivoNegocios.service';
import { EjecutivoNegocios } from '../../theme/services/totalService/EjecutivoNegocios';
import { SectorService } from '../../theme/services/totalService/sector.service';
import { SectorData } from '../../theme/services/totalService/SectorData';
import { TypeEmployeesService } from '../../theme/services/totalService/typeEmployees.service';
import { TipoEmpleadoData } from '../../theme/services/totalService/TipoEmpleadoData';
import { RegionalsService } from '../../theme/services/totalService/regionals.service';
import { RegionalsData } from '../../theme/services/totalService/regionals';
import { HeadQuartersService } from '../../theme/services/headQuartersService/headQuarters.service';
import { BusinessDataService } from '../../theme/services/businessDataService/businessData.service';
import { GeneralDataService } from '../../theme/services/generalDataService/generalData.service';
import { ContactsService } from '../../theme/services/contactsService/contacts.service';
import { contactoCarteraService } from '../../theme/services/contactsService/contactoCartera.service';
import { ContactoHseqService } from '../../theme/services/contactsService/contactoHseq.service';
import { ContactsData } from '../../theme/services/contactsService/contactsData';
import { ServiceLevelsService } from '../../theme/services/serviceLevelsService/serviceLevels.service';
import { OppositionService } from '../../theme/services/oppositionService/opposition.service';
import { CategoryService } from '../../theme/services/totalService/category.service';
import { CategoryOppositionService } from '../../theme/services/totalService/categoryOpposition.service';
import { ListPricesService } from '../../theme/services/totalService/listPrices.service';
import { ListPricesData } from '../../theme/services/totalService/listPrices';
import { TypeMachineService } from '../../theme/services/totalService/typeMachine.service';
import { TypeNegociationService } from '../../theme/services/totalService/typeNegociation.service';
import { TypeNegociationData } from '../../theme/services/totalService/typeNegociation';
import { AnchorageService } from '../../theme/services/totalService/anchorage.service';
import { AnchorageData } from '../../theme/services/totalService/anchorage';
import { PurseService } from '../../theme/services/totalService/purse.service';
import { PurseData } from '../../theme/services/totalService/purse';
import { CorrectivosService } from '../../theme/services/totalService/correctivos.service';
import { FumigacionesService } from '../../theme/services/totalService/fumigaciones.service';
import { PreventivosService } from '../../theme/services/totalService/preventivos.service';
import { TipoVentaService } from '../../theme/services/totalService/tipoVenta.service';
import { PlazoCarteraService } from '../../theme/services/totalService/plazoCartera.service';
import { PlazoArriendoService } from '../../theme/services/totalService/plazoArriendo.service';
import { CruceCarteraService } from '../../theme/services/totalService/cruceCartera.service';
import { RequiereCompraService } from '../../theme/services/totalService/requiereCompra.service';

import { TipoClienteService } from '../../theme/services/totalService/TipoCliente.service';
import { cache } from '../../theme/services/cache';
import { Utilidades } from '../../theme/services/Utilidades.service';
import { ModoService } from '../../theme/services/totalService/Modo.service';
import { InfluenciaCompra } from '../../theme/services/totalService/InfluenciaCompra.service';
import { GradoInfluencia } from '../../theme/services/totalService/GradoInfluencia.service';
import { Calendar } from '../../../app/pages/dashboard/calendar/calendar.component';
import { ValidarTexto } from '../../theme/pipes/validaciones/validarTexto.pipe';
import { ValidarNumero } from '../../theme/pipes/validaciones/validarNumero.pipe';

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
    MomentModule
,
  ],
  declarations: [
    Headquarters,
    ValidarTexto,
    ValidarNumero,
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
    EjecutivoNegociosService,
    RegionalsService,
    AnchorageService,
    ListPricesService,
    TypeNegociationService,
    TypeMachineService,
    CategoryService,
    CategoryOppositionService,
    PurseService,
    CorrectivosService,
    TipoClienteService,
    cache,
    Utilidades,
    ModoService,
    InfluenciaCompra,
    GradoInfluencia,
    contactoCarteraService,
    ContactoHseqService,
    Calendar,
    FumigacionesService,
    PreventivosService,
    TipoVentaService,
    PlazoCarteraService,
    PlazoArriendoService,
    CruceCarteraService,
    RequiereCompraService,
  ],
  exports: [

  ],
})
export class AccountmanagementModule {
}
