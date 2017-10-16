package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.PlazosArriendo;


@Transactional
public interface PlazosArriendoDAO extends CrudRepository<PlazosArriendo, Long> {
	static final Logger log = Logger.getLogger(PlazosArriendoDAO.class);

	public List<PlazosArriendo> findAll();

	
}