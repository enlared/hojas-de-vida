package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.CruceCarteraDAO;
import com.nova.MsHv.entidad.CruceCartera;


@Service
public class CruceCarteraImpl  {

	@Autowired private CruceCarteraDAO dao ;
	
	public List<CruceCartera> consultarTodo(){
		return dao.findAll();
	}
	
}
