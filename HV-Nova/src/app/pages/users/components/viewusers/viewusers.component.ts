import { Component } from '@angular/core';
import { ViewUsersService } from '../../../../theme/services/viewUsersService/viewusers.service';
import { RolUsuarioService } from '../../../../theme/services/viewUsersService/rolUsuario.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { RolUsuarios } from '../../../../theme/services/viewUsersService/rolUsuarios';

import { Observable } from 'rxjs/Rx';
import { Users } from '../../../../theme/services/viewUsersService/users';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Validators } from '@angular/forms';
import { cache } from '../../../../theme/services/cache';

@Component({
  selector: 'viewusers',
  templateUrl: './viewusers.html',
  styleUrls: ['./viewusers.scss'],


})

export class ViewUsers {

  user: RolUsuarios = new RolUsuarios();
  users: RolUsuarios[];
  msgError: string;
  filterQuery: string = "";
  rowsOnPage = 10;
  sortBy = 'name';
  sortOrder = 'asc';
  userSelection: RolUsuarios;

  constructor(private _viewUsersService: ViewUsersService,
    private _roleService: RolUsuarioService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private cache: cache) {

    this.loadRoles();
  }


  toInt(num: string) {
    return +num;
  }

  sortByWordLength = (a: any) => {
    return a.usuario.nombreCompleto.length;
  }


  goDeleteUser(user: RolUsuarios) {
    if (confirm("¿Desea borrar el usuario?") == true) {

      this._roleService.delete(user)
        .subscribe(
        rt => console.log(rt),
        er => console.log(er),
        () => this.loadRoles()

        );

    }


  }

  goEditUser(user: RolUsuarios) {
    if (confirm("¿Desea Editar el usuario?") == true) {
      user.edicion=true;
      this.cache.setrolUsuario(user);
      let link = ['pages/users/newuser'];
      this.router.navigate(link);

    }


  }

  loadRoles() {

    this._roleService.getAll().subscribe(users => this.users = users, error => this.msgError = <any>error);
  }


}
