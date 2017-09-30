package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.EjecutivoNegocio;

@Transactional
public interface EjecutivoNegociosDao extends CrudRepository<EjecutivoNegocio, Long> {
	static final Logger log = Logger.getLogger(EjecutivoNegociosDao.class);

	public List<EjecutivoNegocio> findAll();

}




