package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.PreventivoDAO;
import com.nova.MsHv.entidad.Preventivo;


@Service
public class PreventivoImpl  {

	@Autowired private PreventivoDAO dao ;
	
	public List<Preventivo> consultarTodo(){
		return dao.findAll();
	}
	
}
