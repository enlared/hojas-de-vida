package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Correctivo;


@Transactional
public interface CorrectivoDAO extends CrudRepository<Correctivo, Long> {
	static final Logger log = Logger.getLogger(CorrectivoDAO.class);

	public List<Correctivo> findAll();

	
}