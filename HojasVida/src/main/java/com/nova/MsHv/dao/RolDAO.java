package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Rol;


@Transactional
public interface RolDAO extends CrudRepository<Rol, Long> {
	static final Logger log = Logger.getLogger(RolDAO.class);

	public List<Rol> findAll();

	
}