package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.RolDAO;
import com.nova.MsHv.entidad.Rol;


@Service
public class RolImpl {

	@Autowired private RolDAO dao ;
	
	public List<Rol> consultarTodos(){
		return dao.findAll();
	}
}
