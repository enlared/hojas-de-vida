package com.nova.MsHv.dto;

import com.nova.MsHv.entidad.Usuario;

public class UsuarioResponse {
	private Respuesta respuesta;
	private Usuario usuario;


	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
