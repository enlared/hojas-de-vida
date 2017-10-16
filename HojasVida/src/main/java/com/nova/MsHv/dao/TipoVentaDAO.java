package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.TipoVenta;


@Transactional
public interface TipoVentaDAO extends CrudRepository<TipoVenta, Long> {
	static final Logger log = Logger.getLogger(TipoVentaDAO.class);

	public List<TipoVenta> findAll();

	
}