package com.nova.MsHv.dao;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Negocio;


@Transactional
public interface NegocioDAO extends CrudRepository<Negocio, Long> {
	static final Logger log = Logger.getLogger(NegocioDAO.class);
	
}