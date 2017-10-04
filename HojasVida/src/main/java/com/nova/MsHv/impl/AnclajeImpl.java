package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.AnclajeDAO;
import com.nova.MsHv.entidad.Anclaje;


@Service
public class AnclajeImpl {

	@Autowired private AnclajeDAO anclajeDAO ;
	
	public List<Anclaje> consultarTodos(){
		return anclajeDAO.findAll();
	}
}
