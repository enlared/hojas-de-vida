package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.TipoNegociacion;


@Transactional
public interface TipoNegociacionDAO extends CrudRepository<TipoNegociacion, Long> {
	static final Logger log = Logger.getLogger(TipoNegociacionDAO.class);

	public List<TipoNegociacion> findAll();

	
}