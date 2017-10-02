package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Regional;


@Transactional
public interface RegionalesDAO extends CrudRepository<Regional, Long> {
	static final Logger log = Logger.getLogger(RegionalesDAO.class);

	@Override
	public List<Regional> findAll();

	
}
