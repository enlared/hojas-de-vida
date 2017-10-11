package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.TipoClienteDao;
import com.nova.MsHv.entidad.TipoCliente;


@Service
public class TipoClienteImpl {

	@Autowired private TipoClienteDao tipoClienteDao ;
	
	public List<TipoCliente> consultarTodos(){
		return tipoClienteDao.findAll();
	}
}
