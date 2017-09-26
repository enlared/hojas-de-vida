import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ContactsService } from '../../../../theme/services/contactsService/contacts.service';
import { ContactsData } from '../../../../theme/services/contactsService/contactsData';
import { IMyDpOptions } from 'mydatepicker';

@Component({
  selector: 'contacts',
  styleUrls: ['./contacts.scss'],
  templateUrl: './contacts.html'
})
export class Contacts {

   msgError: string;
  contactDatas: ContactsData[];
  contactsData: ContactsData = new ContactsData();
 
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _contactsDataService: ContactsService,
  ) {

  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }


  resetForm() {
    if (confirm("¿Desea cancelar la acción?") == true) {
 

    }

  }
  goSLA() {
    if (confirm("¿Desea guardar y agregar un SLA?") == true) {

      //this.saveBusinessData();
      let link = ['pages/accountmanagement/servicelevelagreement'];
      this.router.navigate(link);
    }


  }

  saveContactsData() {
    if (confirm("¿Desea guardar un Contacto?") == true) {

      this._contactsDataService.addContacts(this.contactsData)
        .subscribe(
        rt => console.log(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }
 
}
