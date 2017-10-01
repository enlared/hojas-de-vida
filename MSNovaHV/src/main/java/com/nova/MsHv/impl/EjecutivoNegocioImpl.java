package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.EjecutivoNegocioDao;
import com.nova.MsHv.entidad.EjecutivoNegocio;

@Service
public class EjecutivoNegocioImpl {

	@Autowired
	private EjecutivoNegocioDao ejecutivoNegocioDao;

	public List<EjecutivoNegocio> consultarTodosEjecutivo(){
		List<EjecutivoNegocio> lista = null;
		
		try {
			lista= ejecutivoNegocioDao.findAll();

		} catch (Exception e) {
	System.out.println(e);		
	}
		return lista;
	}
}
