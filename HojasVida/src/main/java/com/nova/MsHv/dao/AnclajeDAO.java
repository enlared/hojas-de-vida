package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Anclaje;


@Transactional
public interface AnclajeDAO extends CrudRepository<Anclaje, Long> {
	static final Logger log = Logger.getLogger(AnclajeDAO.class);

	public List<Anclaje> findAll();

	
}