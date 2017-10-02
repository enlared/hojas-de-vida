package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.EjecutivoNegocio;

@Transactional
public interface EjecutivoNegocioDao extends CrudRepository<EjecutivoNegocio, Long> {
	static final Logger log = Logger.getLogger(EjecutivoNegocioDao.class);

	@Override
	public List<EjecutivoNegocio> findAll();

}




