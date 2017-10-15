import { Component, Input, ChangeDetectionStrategy } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ContactsService } from '../../../../theme/services/contactsService/contacts.service';
import { ContactoHseqService } from '../../../../theme/services/contactsService/contactoHseq.service';
import { contactoCarteraService } from '../../../../theme/services/contactsService/contactoCartera.service';
import { ContactsData } from '../../../../theme/services/contactsService/contactsData';
import { ContactsHseqData } from '../../../../theme/services/contactsService/contactsHseqData';
import { ContactsCarteraData } from '../../../../theme/services/contactsService/contactsCarteraData';

import { PurseService } from '../../../../theme/services/totalService/purse.service';
import { PurseData } from '../../../../theme/services/totalService/purse';
import { cache } from '../../../../theme/services/cache';
import { ModoService } from '../../../../theme/services/totalService/Modo.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { InfluenciaCompra } from '../../../../theme/services/totalService/InfluenciaCompra.service';
import { GradoInfluencia } from '../../../../theme/services/totalService/GradoInfluencia.service';
import { Utilidades } from '../../../../theme/services/Utilidades.service';

import { IMyDpOptions } from 'mydatepicker';

@Component({
  selector: 'contacts',
  styleUrls: ['./contacts.scss'],
  templateUrl: './contacts.html',

})
export class Contacts {

  msgError: string;
  contactDatas: ContactsData[];
  @Input() contactsData: ContactsData = new ContactsData();
  contactsHseq: ContactsHseqData = new ContactsHseqData();
  contactsCartera: ContactsCarteraData = new ContactsCarteraData();
  dato: ContactsData = new ContactsData();
  contactoCartera: ContactsCarteraData[];
  contactoHseq: ContactsHseqData[];
  emailObligatorio: boolean = false;

  purseDatas: PurseData[];
  purseData: PurseData = new PurseData();
  modos: ParametroGenerico[];
  influenciaCompra: ParametroGenerico[];
  gradoInfluencia: ParametroGenerico[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private _contactsDataService: ContactsService,
    private _purseDataService: PurseService,
    private cache: cache,
    private modoService: ModoService,
    private influenciaC: InfluenciaCompra,
    private gradoInflu: GradoInfluencia,
    private contactoHseqService: ContactoHseqService,
    private contactoCarteraService: contactoCarteraService,
    private utilidades: Utilidades,
  ) {
    this.ngOnitInit();
    this.loadContacts();
    this.loadModo();
    this.loadFrecuenciaCompra();

    this.loadGradoInfluencia();
    this.loadContactsCartera();
    this.loadcontactoHseq();
  }

  ngOnitInit() {
    if (this.cache.getid() === null || this.cache.getid() === undefined) {
      alert('Es necesario buscar el cliente');

      const link = ['pages/accountmanagement/Generaldata'];
      this.router.navigate(link);
    }
  }

  loadContacts() {
    if (this.cache.getid() != null && this.cache.getid() != undefined) {
      this.dato.clienteid = this.cache.getid();
      this._contactsDataService.getContact(this.dato)
        .subscribe(contactData => this.contactDatas = contactData, error => this.msgError = <any>error);
    }
  }

  loadContactsCartera() {
    if (this.cache.getid() != null && this.cache.getid() != undefined) {
      this.dato.clienteid = this.cache.getid();
      this.contactoCarteraService.getContact(this.dato)
        .subscribe(contactsCartera => this.contactoCartera = contactsCartera, error => this.msgError = <any>error);
    }

  }


  validarNombre() {
    this.contactsData.nombre = this.utilidades.validarTexto(this.contactsData.nombre);
    $("#contactsName").val(this.contactsData.nombre).change();
  }

  validarTelefono() {
    this.contactsData.telefono = this.utilidades.validarTelefono(this.contactsData.telefono);
    $("#telephone").val(this.contactsData.telefono).change();
  }

  validarCelular() {
    this.contactsData.celular = this.utilidades.validarTelefono(this.contactsData.celular);
    $("#telephone").val(this.contactsData.celular).change();
  }

  validarEmail(valor) {
    if (this.utilidades.validarEmail(valor)) {
      alert('Email: Campo requerido');
    }
  }

  /* Informacion cartera */
  validarNombreCartera() {
    this.contactsCartera.nombre = this.utilidades.validarTexto(this.contactsCartera.nombre);
    $("#financialContact").val(this.contactsCartera.nombre).change();
  }

  validarTelefonoCartera() {
    this.contactsCartera.telefono = this.utilidades.validarTelefono(this.contactsCartera.telefono);
    $("#financialTelephone").val(this.contactsCartera.telefono).change();
  }

  validarCelularCartera() {
    this.contactsData.celular = this.utilidades.validarTelefono(this.contactsData.celular);
    $("#financialCelphone").val(this.contactsData.celular).change();
  }


  /* ************************* */

  validarNombreHSEQ() {
    this.contactsHseq.nombre = this.utilidades.validarTexto(this.contactsHseq.nombre);
    $("#hseqName").val(this.contactsHseq.nombre).change();
  }

  validarTelefonoHseq() {
    this.contactsHseq.telefono = this.utilidades.validarTelefono(this.contactsHseq.telefono);
    $("#hseqTelephone").val(this.contactsHseq.telefono).change();
  }
  /* */
  loadcontactoHseq() {
    if (this.cache.getid() != null && this.cache.getid() != undefined) {
      this.dato.clienteid = this.cache.getid();
      this.contactoHseqService.getContact(this.dato)
        .subscribe(contactoHseq => this.contactoHseq = contactoHseq, error => this.msgError = <any>error);
    }

  }

  loadModo() {
    this.modoService.getModo()
      .subscribe(modos => this.modos = modos, error => this.msgError = <any>error);
  }


  loadFrecuenciaCompra() {
    this.influenciaC.getAll()
      .subscribe(influenciaCompra => this.influenciaCompra = influenciaCompra, error => this.msgError = <any>error);
  }

  loadGradoInfluencia() {
    this.gradoInflu.getAll()
      .subscribe(gradoInfluencia => this.gradoInfluencia = gradoInfluencia, error => this.msgError = <any>error);
  }


  resetForm() {
    if (confirm('¿Desea cancelar la acción?')) {


    }

  }
  goSLA() {
    if (confirm('¿Desea guardar y agregar un SLA?')) {
      const link = ['pages/accountmanagement/servicelevelagreement'];
      this.router.navigate(link);
    }


  }


  saveContactsData() {
    if (confirm('¿Desea guardar un Contacto?')) {
      this.contactsData.fechacumpleanos = this.convertirFecha(this.contactsData);
      this.contactsData.clienteid = this.cache.getid();
      this._contactsDataService.addContacts(this.contactsData)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => this.limpiar(),
      );
    }
  }

  actualizar(datos) {
    this.loadContacts();
    this.loadContactsCartera();
    this.loadcontactoHseq();

  }
  limpiar() {
    this.contactsData = new ContactsData();
  }

  convertirFecha(datos: any) {
    return datos.fechacumpleanos.jsdate;
  }
  saveContactsCateraData() {
    if (confirm('¿Desea guardar un Contacto de cartera?')) {
      this.contactsCartera.clienteid = this.cache.getid();
      this.contactoCarteraService.addContacts(this.contactsCartera)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  saveContactsHseqData() {
    if (confirm('¿Desea guardar un Contacto de Hseq?')) {
      this.contactsHseq.clienteid = this.cache.getid();
      this.contactoHseqService.addContacts(this.contactsHseq)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  removeContactsCatera(data) {
    if (confirm('¿Desea eliminar un Contacto de cartera?')) {
      this.contactoCarteraService.deleteContacts(data)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  removeContactsHseq(data) {
    if (confirm('¿Desea eliminar un Contacto de Hseq?')) {
      this.contactoHseqService.deleteContacts(data)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  removeContact(data) {
    if (confirm('¿Desea eliminar un Contacto?')) {
      this._contactsDataService.deleteContacts(data)
        .subscribe(
        rt => this.actualizar(rt),
        error => this.msgError = <any>error,
        () => console.log('Terminado'),
      );
    }
  }

  editarContacto(dato: ContactsData) {
    this.contactsData.influenciaCompra = this.cargarDatoLista(dato.influenciaCompra, this.influenciaCompra);
    this.contactsData.gradoInfluencia = this.cargarDatoLista(dato.gradoInfluencia, this.gradoInfluencia);
    this.contactsData.modo = this.cargarDatoLista(dato.modo, this.modos);
    this.contactsData.fechacumpleanos = this.crearFechaDate(dato.fechacumpleanos);

    this.contactsData = dato;
  }

  editarContactoCartera(dato) {
    this.contactsCartera = dato;
  }


  editarContactoHseq(dato) {
    this.contactsHseq = dato;
  }

  cargarDatoLista(data: ParametroGenerico, lista) {
    let res;
    lista.forEach(element => {
      if (data.id === element.id) {
        res = element;
      }
    });
    return res;
  }

  crearFechaDate(formater) {
    const dato = new Date(formater);
    return dato;
  }

}
