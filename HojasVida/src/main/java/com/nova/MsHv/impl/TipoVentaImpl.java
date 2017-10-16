package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.TipoVentaDAO;
import com.nova.MsHv.entidad.TipoVenta;


@Service
public class TipoVentaImpl {

	@Autowired private TipoVentaDAO dao ;
	
	public List<TipoVenta> consultarTodos(){
		return dao.findAll();
	}
}
