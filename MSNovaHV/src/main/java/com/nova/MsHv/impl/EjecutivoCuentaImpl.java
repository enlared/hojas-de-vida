package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ParamestrosEjecutivoCuentaDao;
import com.nova.MsHv.entidad.ParamEjecutivoCuenta;

@Service
public class EjecutivoCuentaImpl  {

	@Autowired ParamestrosEjecutivoCuentaDao paramestrosEjecutivoCuentaDao ;
	
	public List<ParamEjecutivoCuenta> consultarTodosEjecutivoCuenta(){
		return paramestrosEjecutivoCuentaDao.findAll();
	}
}
