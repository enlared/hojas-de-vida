package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ListaPreciosDAO;
import com.nova.MsHv.entidad.ListaPrecio;


@Service
public class ListaDePreciosImpl {

	@Autowired private ListaPreciosDAO listaPreciosDAO ;
	
	public List<ListaPrecio> consultarTodos(){
		return listaPreciosDAO.findAll();
	}

	public ListaPrecio save(ListaPrecio dato) {
		return listaPreciosDAO.save(dato);
	}
}
