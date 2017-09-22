import { Routes, RouterModule }  from '@angular/router';

import { Users } from './users.component';
import { Edituser } from './components/edituser/edituser.component';
import { Newuser } from './components/newuser/newuser.component';
import { Viewusers } from './components/viewusers/viewusers.component';
import { Deleteuser} from './components/deleteuser/deleteuser.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Users,
    children: [
      { path: 'edituser', component: Edituser },
      { path: 'newuser', component: Newuser },
      { path: 'viewusers', component: Viewusers},
      { path: 'deleteuser', component: Deleteuser}
    ]
  }
];

export const routing = RouterModule.forChild(routes);
