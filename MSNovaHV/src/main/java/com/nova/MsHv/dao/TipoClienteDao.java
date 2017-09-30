package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.TipoCliente;

@Transactional
public interface TipoClienteDao extends CrudRepository<TipoCliente, Long> {
	static final Logger log = Logger.getLogger(TipoClienteDao.class);

	public List<TipoCliente> findAll();

}




