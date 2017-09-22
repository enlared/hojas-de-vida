import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { routing }       from './users.routing';
import { Users } from './users.component';
import { Edituser } from './components/edituser/edituser.component';
import { Newuser } from './components/newuser/newuser.component';
import { Viewusers } from './components/viewusers/viewusers.component';
import { Deleteuser } from './components/deleteuser/deleteuser.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    routing
  ],
  declarations: [
    Users,
    Edituser,
    Newuser,
    Viewusers,
    Deleteuser
  ],
  providers: [

  ]
})
export class UsersModule {}
