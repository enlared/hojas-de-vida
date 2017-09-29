import { Component } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ContactsService } from '../../../../theme/services/contactsService/contacts.service';
import { ContactsData } from '../../../../theme/services/contactsService/contactsData';
import { PurseService } from '../../../../theme/services/totalService/purse.service';
import { PurseData } from '../../../../theme/services/totalService/purse';
import { ContactHseqService } from '../../../../theme/services/totalService/contactHseq.service';
import { ContactHseqData } from '../../../../theme/services/totalService/contactHseq';

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
  purseDatas: PurseData[];
  purseData: PurseData = new PurseData();
  contactHseqData: ContactHseqData = new ContactHseqData();
  contactHseqDatas: ContactHseqData[];

  constructor(


    private route: ActivatedRoute,
    private router: Router,
    private _contactsDataService: ContactsService,
    private _purseDataService: PurseService,
    private _contactHseqService: ContactHseqService,
  ) {

    this.loadContacts();

  }

  ngOnitInit() {
    let id = this.route.snapshot.params['id'];
    if (!id) return;
    console.log(id);
  }

  loadContacts() {
    this._contactsDataService.getContacts()
    .subscribe(contactDatas => this.contactDatas = contactDatas, error => this.msgError = <any>error);
  }

  resetForm() {
    if (confirm("¿Desea cancelar la acción?") === true) {
 

    }

  }
  goSLA() {
    if (confirm("¿Desea guardar y agregar un SLA?") === true) {

      //this.saveBusinessData();
      let link = ['pages/accountmanagement/servicelevelagreement'];
      this.router.navigate(link);
    }


  }


  saveContactsData() {
    if (confirm("¿Desea guardar un Contacto?") === true) {

      this._contactsDataService.addContacts(this.contactsData)
        .subscribe(
        rt => console.log(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }
 
}
