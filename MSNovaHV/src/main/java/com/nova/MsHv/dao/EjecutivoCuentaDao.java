package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.EjecutivoCuenta;

@Transactional
public interface EjecutivoCuentaDao extends CrudRepository<EjecutivoCuenta, Long> {
	static final Logger log = Logger.getLogger(EjecutivoCuentaDao.class);

	public List<EjecutivoCuenta> findAll();

}




