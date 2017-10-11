package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.ContactHseqDAO;
import com.nova.MsHv.entidad.ContactoHseq;


@Service
public class ContactoHseqImpl  {

	@Autowired private ContactHseqDAO dao ;
	
	public List<ContactoHseq> consultarAll(ContactoHseq contacto){
		return dao.findByClienteid(contacto.getClienteid());
	}
	
	public boolean remove(ContactoHseq contacto){
		dao.delete(contacto);
		return true;
	}
	
	public ContactoHseq save(ContactoHseq contacto){
		return dao.save(contacto);
	}
}
