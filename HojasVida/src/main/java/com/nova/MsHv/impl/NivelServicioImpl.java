package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.NivelServicioDAO;
import com.nova.MsHv.entidad.NivelServicio;


@Service
public class NivelServicioImpl  {

	@Autowired private NivelServicioDAO dao ;
	
	public List<NivelServicio> consultarCliente(NivelServicio dato){
		return dao.findByClienteid(dato.getClienteid());
	}
	
	public boolean remove(NivelServicio dato){
		dao.delete(dato);
		return true;
	}
	
	public NivelServicio save(NivelServicio dato){
		return dao.save(dato);
	}
}
