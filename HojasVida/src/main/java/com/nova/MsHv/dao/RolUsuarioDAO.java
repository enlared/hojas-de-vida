package com.nova.MsHv.dao;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nova.MsHv.entidad.RolUsuario;


@Transactional
public interface RolUsuarioDAO extends CrudRepository<RolUsuario, Long> {
	static final Logger log = Logger.getLogger(RolUsuarioDAO.class);
	
	@Query("select r from RolUsuario r  where r.rol.id= :rol and r.usuario.nombreUsuario= :usuario")
	public RolUsuario consultaUser(@Param("rol")Integer rol,@Param("usuario")String usuario);

}
