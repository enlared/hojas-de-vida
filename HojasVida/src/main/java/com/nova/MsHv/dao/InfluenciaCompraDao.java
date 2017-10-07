package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.InfluenciaCompra;


@Transactional
public interface InfluenciaCompraDao extends CrudRepository<InfluenciaCompra, Long> {
	static final Logger log = Logger.getLogger(InfluenciaCompraDao.class);

	@Override
	public List<InfluenciaCompra> findAll();

}




