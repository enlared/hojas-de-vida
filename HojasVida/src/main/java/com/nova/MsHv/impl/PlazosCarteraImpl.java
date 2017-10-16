package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.PlazosCarteraDAO;
import com.nova.MsHv.entidad.PlazosCartera;


@Service
public class PlazosCarteraImpl  {

	@Autowired private PlazosCarteraDAO dao ;
	
	public List<PlazosCartera> consultarTodo(){
		return dao.findAll();
	}
	
}
