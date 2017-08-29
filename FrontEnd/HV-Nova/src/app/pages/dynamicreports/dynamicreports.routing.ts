import { Routes, RouterModule } from '@angular/router';

import { Dynamicreports } from './dynamicreports.component';
import { Reports } from './components/reports/reports.component';


// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Dynamicreports,
    children: [
      { path: 'reports', component: Reports },

    ]
  }
];

export const routing = RouterModule.forChild(routes);
