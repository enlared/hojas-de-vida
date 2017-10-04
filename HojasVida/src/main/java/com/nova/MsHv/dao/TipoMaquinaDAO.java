package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.TipoMaquina;


@Transactional
public interface TipoMaquinaDAO extends CrudRepository<TipoMaquina, Long> {
	static final Logger log = Logger.getLogger(TipoMaquinaDAO.class);


	public TipoMaquina findById(Integer id);

	public List<TipoMaquina> findAll();

	
}
