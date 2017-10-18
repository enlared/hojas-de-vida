package com.nova.MsHv.dao;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Usuario;


@Transactional
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
	static final Logger log = Logger.getLogger(UsuarioDAO.class);
	
	public Usuario findByNombreUsuario (String user);

}
