package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ContactoDAO;
import com.nova.MsHv.entidad.Contacto;


@Service
public class ContactoImpl  {

	@Autowired private ContactoDAO dao ;
	
	public List<Contacto> consultarAll(Contacto contacto){
		return dao.findByClienteid(contacto.getClienteid());
	}
	
	public boolean remove(Contacto contacto){
		dao.delete(contacto);
		return true;
	}
	
	public Contacto save(Contacto contacto){
		return dao.save(contacto);
	}
}
