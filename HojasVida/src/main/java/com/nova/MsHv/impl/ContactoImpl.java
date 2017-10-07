package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ContactHseqDAO;
import com.nova.MsHv.entidad.Contacto;


@Service
public class ContactoImpl  {

	@Autowired private ContactHseqDAO dao ;
	
	public List<Contacto> consultarAll(Contacto contacto){
		return dao.findByClienteid(contacto.getClienteid());
	}
	
	public boolean remove(Contacto contacto){
		dao.delete(contacto);
		return true;
	}
	
	public boolean save(Contacto contacto){
		dao.save(contacto);
		return true;
	}
}
