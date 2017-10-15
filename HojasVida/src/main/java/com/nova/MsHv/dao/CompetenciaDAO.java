package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Competencia;

@Transactional
public interface CompetenciaDAO extends CrudRepository<Competencia, Integer> {
	static final Logger log = Logger.getLogger(CompetenciaDAO.class);


	public List<Competencia> findByClienteid(int i );

	
}
