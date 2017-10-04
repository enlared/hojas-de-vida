package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.TipoMaquinaDAO;
import com.nova.MsHv.entidad.TipoMaquina;


@Service
public class TipoMaquinaImpl {

	@Autowired private TipoMaquinaDAO tipoMaquinaDAO ;
	
	public List<TipoMaquina> consultarTodos(){
		return tipoMaquinaDAO.findAll();
	}
}
