package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.CruceCartera;


@Transactional
public interface CruceCarteraDAO extends CrudRepository<CruceCartera, Long> {
	static final Logger log = Logger.getLogger(CruceCarteraDAO.class);

	public List<CruceCartera> findAll();

	
}