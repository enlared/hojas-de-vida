package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Categoria;


@Transactional
public interface CategoriaDAO extends CrudRepository<Categoria, Long> {
	static final Logger log = Logger.getLogger(CategoriaDAO.class);

	public List<Categoria> findAll();

	
}