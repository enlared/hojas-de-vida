import { Component } from "@angular/core";
import { RoleService } from "../../../../theme/services/roleService/role.service";
import { ParametroGenerico } from "../../../../theme/services/totalService/genericoParametro";
import { Observable } from "rxjs/Rx";
import { Validators } from "@angular/forms";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { ViewUsersService } from "../../../../theme/services/viewUsersService/viewusers.service";
import { RolUsuarioService } from "../../../../theme/services/viewUsersService/rolUsuario.service";
import { cache } from "../../../../theme/services/cache";
import { Utilidades } from "../../../../theme/services/Utilidades.service";

import { Users } from "../../../../theme/services/viewUsersService/users";
import { RolUsuarios } from "../../../../theme/services/viewUsersService/rolUsuarios";
import { RespuestaRolUsuario } from "../../../../theme/services/respuestaRolUsuario";

import { Location } from "@angular/common";
import "rxjs/add/operator/switchMap";

@Component({
  selector: "newuser",
  styleUrls: ["./newuser.scss"],
  templateUrl: "./newuser.html"
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
    private router: Router,
    private cache: cache,
    private utilidades: Utilidades,
  ) {
    this.loadRoles();

    setTimeout(() => {
      this.ngOnitInit();
    }, 1000);
  }

  ngOnitInit() {
    const s = this.cache.getrolUsuario();
    if (s !== null && s !== undefined) {
      this.rolUsuarios = s;
      this.user = s.usuario;
      this.rolUsuarios.rol = this.cargarRol(s.rol);
    }
  }
  cargarRol(rol: ParametroGenerico) {
    let res;
    if (this.roles != null) {
      this.roles.forEach(element => {
        if (rol.id === element.id) {
          res = element;
        }
      });
    }

    return res;
  }

  resetForm() {
    if (confirm("¿Desea Cancelar la acción?")) {
      this.rolUsuarios= new RolUsuarios();
      this.user = new Users();

    }
  }

  saveUser() {
    if (confirm("¿Desea Guardar el Usuario?")) {
      if(this.rolUsuarios.edicion){
        this. ejecutarGuardado();
      }else{
        this.usuarioExiste();

      }
    }
  }
  usuarioExiste() {
    this._rolUsuarioService
      .getXUsuario(this.rolUsuarios)
      .subscribe(
        rt => this.guardar(rt),
        error => (this.msgError = <any>error),
        () => console.log("Terminado")
      );
  }

  guardar(rt: RespuestaRolUsuario) {
    if (rt.respuesta.estado === "OK" && rt.rolUsuario === null) {
        this. ejecutarGuardado();
    } else {
      alert("Usuario ya registrado ");
    }
  }

  ejecutarGuardado(){
    this.rolUsuarios.usuario = this.user;
    this._rolUsuarioService
      .add(this.rolUsuarios)
      .subscribe(
        rt => this.actualizar(rt),
        error => (this.msgError = <any>error),
        () => console.log("Terminado")
      );
  }
  actualizar(data: RolUsuarios) {
    this.rolUsuarios = new RolUsuarios();
    this.user = new Users();
    this.cache.setrolUsuario(null);
    alert("Usuario guardado con exito ");
  }

  loadRoles() {
    this._roleService
      .getRole()
      .subscribe(
        roles => (this.roles = roles),
        error => (this.msgError = <any>error)
      );
  }

  validarNombre() {
    this.user.nombreCompleto = this.utilidades.validarTexto(this.user.nombreCompleto);
    $("#name").val(this.user.nombreCompleto).change();
  }

  validarUsuario() {
    this.user.nombreUsuario = this.utilidades.validarTexto(this.user.nombreUsuario);
    $("#nameuser").val(this.user.nombreUsuario).change();
  }

  validarEmail(valor) {
    if (this.utilidades.validarEmail(valor)) {
      alert('Email: Campo requerido');
    }
  }
}
