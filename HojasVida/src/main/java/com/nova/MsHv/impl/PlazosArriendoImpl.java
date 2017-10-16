package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.PlazosArriendoDAO;
import com.nova.MsHv.entidad.PlazosArriendo;


@Service
public class PlazosArriendoImpl  {

	@Autowired private PlazosArriendoDAO dao ;
	
	public List<PlazosArriendo> consultarTodo(){
		return dao.findAll();
	}
	
}
