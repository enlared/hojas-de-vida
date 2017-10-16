package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Preventivo;


@Transactional
public interface PreventivoDAO extends CrudRepository<Preventivo, Long> {
	static final Logger log = Logger.getLogger(PreventivoDAO.class);

	public List<Preventivo> findAll();

	
}