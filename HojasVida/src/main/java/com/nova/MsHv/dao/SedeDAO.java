package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Sede;


@Transactional
public interface SedeDAO extends CrudRepository<Sede, Long> {
	static final Logger log = Logger.getLogger(SedeDAO.class);

	public Sede findById(Integer id);

	public List<Sede> findAll();

	
}