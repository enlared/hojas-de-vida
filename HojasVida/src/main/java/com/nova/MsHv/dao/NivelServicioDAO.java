package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.NivelServicio;

@Transactional
public interface NivelServicioDAO extends CrudRepository<NivelServicio, Long> {
	static final Logger log = Logger.getLogger(NivelServicioDAO.class);

	public List<NivelServicio> findByClienteid(int i );
	
}
