package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.TipoVasoDAO;
import com.nova.MsHv.entidad.TipoVaso;


@Service
public class TipoVasoImpl {

	@Autowired private TipoVasoDAO tipoVasoDAO ;
	
	public List<TipoVaso> consultarTodos(){
		return tipoVasoDAO.findAll();
	}
}
