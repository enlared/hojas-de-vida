import { Routes, RouterModule }  from '@angular/router';

import { Accountmanagement } from './accountmanagement.component';
import { Headquarters } from './components/headquarters/headquarters.component';
import { Opposition } from './components/opposition/opposition.component';
import { Businessdata } from './components/businessdata/businessdata.component';
import { Contacts } from './components/contacts/contacts.component';
import { Generaldata } from './components/generaldata/generaldata.component';
import { Servicelevels } from './components/servicelevels/servicelevels.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Accountmanagement,
    children: [
      { path: 'headquarters', component: Headquarters },
      { path: 'headquarters/:id', component: Headquarters },
      { path: 'businessdata', component: Businessdata },
      { path: 'generaldata', component: Generaldata },
      { path: 'contacts', component: Contacts },
      { path: 'servicelevels', component: Servicelevels },
      { path: 'opposition', component: Opposition },
    ]
  }
];

export const routing = RouterModule.forChild(routes);
