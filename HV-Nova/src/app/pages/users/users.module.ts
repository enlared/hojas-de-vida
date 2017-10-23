import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { routing } from './users.routing';
import { Users } from './users.component';
import { Newuser } from './components/newuser/newuser.component';
import { ViewUsers } from './components/viewusers/viewusers.component';
import { ViewUsersService } from '../../theme/services/viewUsersService/viewusers.service';
import { RolUsuarioService } from '../../theme/services/viewUsersService/rolUsuario.service';
import { cache } from '../../theme/services/cache';

import { HttpModule } from '@angular/http';
import { RoleService } from '../../theme/services/roleService/role.service';
import { Utilidades } from '../../theme/services/Utilidades.service';

import { Ng2SmartTableModule } from 'ng2-smart-table';
import { DataTableModule } from 'angular2-datatable';
import { DataFilterPipe } from './data-filter.pipe';
import { HotTable, HotTableModule } from 'ng2-handsontable';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    NgbModalModule,
    NgbDropdownModule,
    routing,
    HttpModule,
    Ng2SmartTableModule,
    DataTableModule,


  ],
  declarations: [
    Users,
    Newuser,
    ViewUsers,
    DataFilterPipe,
  ],
  entryComponents: [

   ],
  providers: [
  ViewUsersService,
  RoleService,
  Utilidades,
  RolUsuarioService,
  cache,
  ]
})
export class UsersModule {}
