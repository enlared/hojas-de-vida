package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.CategoriaCompetenciaDAO;
import com.nova.MsHv.entidad.CategoriaCompetencia;


@Service
public class CategoriaCompetenciaImpl {

	@Autowired private CategoriaCompetenciaDAO categoriaDAO ;
	
	public List<CategoriaCompetencia> consultarTodos(){
		return categoriaDAO.findAll();
	}
}
