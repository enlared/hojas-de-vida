package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.ContactoCartera;



@Transactional
public interface ContactoCarteraDAO extends CrudRepository<ContactoCartera, Long> {
	static final Logger log = Logger.getLogger(ContactoCarteraDAO.class);

	public List<ContactoCartera> findByClienteid(Long long1 );

}
