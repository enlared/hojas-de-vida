package com.nova.MsHv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.NegocioDAO;
import com.nova.MsHv.entidad.Negocio;


@Service
public class NegocioImpl {

	@Autowired private NegocioDAO negocioDAO ;
	
	public Negocio save(Negocio data){
		return negocioDAO.save(data);
	}
}
