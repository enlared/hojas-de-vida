package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.RequiereCompra;


@Transactional
public interface RequiereCompraDAO extends CrudRepository<RequiereCompra, Long> {
	static final Logger log = Logger.getLogger(RequiereCompraDAO.class);

	public List<RequiereCompra> findAll();

	
}