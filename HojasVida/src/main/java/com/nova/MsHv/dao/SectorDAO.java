package com.nova.MsHv.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.nova.MsHv.entidad.Sector;


@Transactional
public interface SectorDAO extends CrudRepository<Sector, Long> {
	static final Logger log = Logger.getLogger(SectorDAO.class);

	public Sector findById(Integer id);

	public List<Sector> findAll();

	
}
