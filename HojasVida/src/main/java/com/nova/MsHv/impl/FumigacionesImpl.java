package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.FumigacionesDAO;
import com.nova.MsHv.entidad.Fumigacione;


@Service
public class FumigacionesImpl  {

	@Autowired private FumigacionesDAO dao ;
	
	public List<Fumigacione> consultarTodo(){
		return dao.findAll();
	}
	
}
