package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Contacto;


@Transactional
public interface ContactoDAO extends CrudRepository<Contacto, Long> {
	static final Logger log = Logger.getLogger(ContactoDAO.class);

	public List<Contacto> findByClienteid(Long long1 );

}
