package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.TipoNegociacionDAO;
import com.nova.MsHv.entidad.TipoNegociacion;


@Service
public class TipoNegociacionImpl {

	@Autowired private TipoNegociacionDAO tipoNegociacionDAO ;
	
	public List<TipoNegociacion> consultarTodos(){
		return tipoNegociacionDAO.findAll();
	}
}
