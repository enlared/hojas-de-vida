import { Component } from '@angular/core';
import { RoleService } from '../../../../theme/services/roleService/role.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { Observable } from 'rxjs/Rx';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewUsersService } from '../../../../theme/services/viewUsersService/viewusers.service';
import { RolUsuarioService } from '../../../../theme/services/viewUsersService/rolUsuario.service';

import { Users } from '../../../../theme/services/viewUsersService/users';
import { RolUsuarios } from '../../../../theme/services/viewUsersService/rolUsuarios';
import { RespuestaRolUsuario } from '../../../../theme/services/respuestaRolUsuario';

import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'newuser',
  styleUrls: ['./newuser.scss'],
  templateUrl: './newuser.html',
})

export class Newuser {

  rolUsuarios: RolUsuarios = new RolUsuarios();
  user: Users = new Users();

  submitted = false;
  roles: ParametroGenerico[];
  msgError: string;
  role: ParametroGenerico = new ParametroGenerico();

  constructor(
    private _roleService: RoleService,
    private _viewUsersService: ViewUsersService,
    private _rolUsuarioService: RolUsuarioService,
    private route: ActivatedRoute,
    private router: Router) {

    this.loadRoles();
  }

  ngOnitInit() {

  }


  resetForm() {

    if( confirm("¿Desea Cancelar la acción?") == true) {
     }

  }

  saveUser() {
    if(  confirm("¿Desea Guardar el Usuario?") === true) {
      this.usuarioExiste() ;
    }
  }
  usuarioExiste() {
    this._rolUsuarioService.getXUsuario(this.rolUsuarios)
    .subscribe(rt => this.guardar(rt),
    error => this.msgError = <any>error,
    () => console.log('Terminado')
    );
  }

  guardar(rt: RespuestaRolUsuario) {
    if(rt.respuesta.estado === "OK" && rt.rolUsuario === null) {
      this.rolUsuarios.usuario = this.user;
      this._rolUsuarioService.add(this.rolUsuarios)
      .subscribe(rt => this.actualizar(rt),error => this.msgError = <any>error,() => console.log('Terminado')
      );
    }else{
      alert("Usuario ya registrado ");

    }

  }
  actualizar(data: RolUsuarios) {
    alert("Usuario guardado con exito ");
  }

  loadRoles() {

    this._roleService.getRole().subscribe(roles => this.roles = roles, error => this.msgError = <any>error);
  }

}
