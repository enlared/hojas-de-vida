package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.EjecutivoCuentaDao;
import com.nova.MsHv.entidad.EjecutivoCuenta;


@Service
public class EjecutivoCuentaImpl  {

	@Autowired private EjecutivoCuentaDao ejecutivoCuentaDao ;
	
	public List<EjecutivoCuenta> consultarTodosEjecutivoCuenta(){
		return ejecutivoCuentaDao.findAll();
	}
}
