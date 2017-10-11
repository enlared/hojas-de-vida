package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ContactoCarteraDAO;
import com.nova.MsHv.entidad.ContactoCartera;


@Service
public class ContactoCarteraImpl  {

	@Autowired private ContactoCarteraDAO dao ;
	
	public List<ContactoCartera> consultarAll(ContactoCartera contacto){
		return dao.findByClienteid(contacto.getClienteid());
	}
	
	public boolean remove(ContactoCartera contacto){
		dao.delete(contacto);
		return true;
	}
	
	public ContactoCartera save(ContactoCartera contacto){
		return dao.save(contacto);
	}
}
