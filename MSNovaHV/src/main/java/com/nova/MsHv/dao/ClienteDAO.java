package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Cliente;

@Transactional
public interface ClienteDAO extends CrudRepository<Cliente, Long> {
	static final Logger log = Logger.getLogger(ClienteDAO.class);


	public Cliente findByCodigosap(String codsap);

	public List<Cliente> findAll();

	
}
