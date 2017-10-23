import { ParametroGenerico } from '../../../theme/services/totalService/genericoParametro';
import { Users } from '../../../theme/services/viewUsersService/users';

export class RolUsuarios {

    id: number;
    fechaRegistro: Date;
    rol: ParametroGenerico = new ParametroGenerico();
    usuario: Users= new Users();
    edicion: boolean;
    }
