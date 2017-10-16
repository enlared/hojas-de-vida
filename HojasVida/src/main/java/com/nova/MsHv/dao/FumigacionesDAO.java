package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Fumigacione;


@Transactional
public interface FumigacionesDAO extends CrudRepository<Fumigacione, Long> {
	static final Logger log = Logger.getLogger(FumigacionesDAO.class);

	public List<Fumigacione> findAll();

	
}