package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.CategoriaDAO;
import com.nova.MsHv.entidad.Categoria;


@Service
public class CategoriaImpl {

	@Autowired private CategoriaDAO categoriaDAO ;
	
	public List<Categoria> consultarTodos(){
		return categoriaDAO.findAll();
	}
}
