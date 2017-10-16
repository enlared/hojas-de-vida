package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.CategoriaCompetencia;


@Transactional
public interface CategoriaCompetenciaDAO extends CrudRepository<CategoriaCompetencia, Long> {
	static final Logger log = Logger.getLogger(CategoriaCompetenciaDAO.class);

	public List<CategoriaCompetencia> findAll();

	
}