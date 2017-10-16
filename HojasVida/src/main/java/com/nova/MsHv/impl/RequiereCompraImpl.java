package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.RequiereCompraDAO;
import com.nova.MsHv.entidad.RequiereCompra;


@Service
public class RequiereCompraImpl  {

	@Autowired private RequiereCompraDAO dao ;
	
	public List<RequiereCompra> consultarTodo(){
		return dao.findAll();
	}
	
}
