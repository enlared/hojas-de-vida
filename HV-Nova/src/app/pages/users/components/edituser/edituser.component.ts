import { Component, OnInit } from '@angular/core';
import { RoleService } from '../../../../theme/services/roleService/role.service';
import { ParametroGenerico } from '../../../../theme/services/totalService/genericoParametro';
import { Observable } from 'rxjs/Rx';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ViewUsersService } from '../../../../theme/services/viewUsersService/viewusers.service';
import { Users } from '../../../../theme/services/viewUsersService/users';
import { ViewUsers } from '../viewusers/viewusers.component';

@Component({
  selector: 'edituser',
  templateUrl: './edituser.html',
  styleUrls: ['./edituser.scss'],

})

export class Edituser implements OnInit {

  roles: ParametroGenerico[];
  user: Users = new Users();
  msgError: string;
  users = [];
  rol: ParametroGenerico = new ParametroGenerico();
  idnuser: number;


  constructor(
    private _roleService: RoleService,
    private _viewUsersService: ViewUsersService,
    private route: ActivatedRoute,
    private router: Router) {
    this.loadRoles();

  }

  ngOnInit(): void {

  }

  resetForm() {

    if(confirm("¿Desea cancelar la accion?")){

    }


  }


  updateUser() {

    if(confirm("¿Desea guardar el usuario editado?")) {
    }
  }

  loadRoles() {
    this._roleService.getRole().subscribe(roles => this.roles = roles, error => this.msgError = <any>error);
  }
}
