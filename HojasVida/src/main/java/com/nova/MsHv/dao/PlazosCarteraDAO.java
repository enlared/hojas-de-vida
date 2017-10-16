package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.PlazosCartera;


@Transactional
public interface PlazosCarteraDAO extends CrudRepository<PlazosCartera, Long> {
	static final Logger log = Logger.getLogger(PlazosCarteraDAO.class);

	public List<PlazosCartera> findAll();

	
}