package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ModoDao;
import com.nova.MsHv.entidad.Modo;


@Service
public class ModoImpl  {

	@Autowired private ModoDao dao ;
	
	public List<Modo> consultarAll(){
		return dao.findAll();
	}
}
