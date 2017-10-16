package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.CorrectivoDAO;
import com.nova.MsHv.entidad.Correctivo;


@Service
public class CorrectivoImpl  {

	@Autowired private CorrectivoDAO dao ;
	
	public List<Correctivo> consultarTodo(){
		return dao.findAll();
	}
	
}
