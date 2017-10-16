package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.CompetenciaDAO;
import com.nova.MsHv.entidad.Competencia;


@Service
public class CompetenciaImpl  {

	@Autowired private CompetenciaDAO dao ;
	
	public List<Competencia> consultarCliente(Competencia dato){
		return dao.findByClienteid(dato.getClienteid());
	}
	
	public boolean remove(Competencia dato){
		dao.delete(dato);
		return true;
	}
	
	public Competencia save(Competencia dato){
		return dao.save(dato);
	}
}
