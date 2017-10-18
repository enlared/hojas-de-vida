package com.nova.MsHv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.UsuarioDAO;
import com.nova.MsHv.entidad.Usuario;


@Service
public class UsuarioImpl  {

	@Autowired private UsuarioDAO dao ;
	
	public Iterable<Usuario> consultarAll(){
		return dao.findAll();
	}
	
	public boolean remove(Usuario  data){
		dao.delete(data);
		return true;
	}
	
	public Usuario save(Usuario data){
		return dao.save(data);
	}
	
	public Usuario consultaXUsuario(Usuario data){
		return dao.findByNombreUsuario(data.getNombreUsuario());
	}
}
