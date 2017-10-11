package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.GradoInfluencia;


@Transactional
public interface GradoInfluenciaDao extends CrudRepository<GradoInfluencia, Long> {
	static final Logger log = Logger.getLogger(GradoInfluenciaDao.class);

	@Override
	public List<GradoInfluencia> findAll();

}




