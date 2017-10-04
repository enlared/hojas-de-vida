package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.ListaPrecio;


@Transactional
public interface ListaPreciosDAO extends CrudRepository<ListaPrecio, Long> {
	static final Logger log = Logger.getLogger(ListaPreciosDAO.class);

	public List<ListaPrecio> findAll();

	
}