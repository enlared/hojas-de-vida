package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Modo;


@Transactional
public interface ModoDao extends CrudRepository<Modo, Long> {
	static final Logger log = Logger.getLogger(ModoDao.class);

	@Override
	public List<Modo> findAll();

}




