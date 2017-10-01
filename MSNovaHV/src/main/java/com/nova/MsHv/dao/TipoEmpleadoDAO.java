package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.TipoEmpleado;


@Transactional
public interface TipoEmpleadoDAO extends CrudRepository<TipoEmpleado, Long> {
	static final Logger log = Logger.getLogger(TipoEmpleadoDAO.class);

	public TipoEmpleado findById(Integer id);

	public List<TipoEmpleado> findAll();

	
}
