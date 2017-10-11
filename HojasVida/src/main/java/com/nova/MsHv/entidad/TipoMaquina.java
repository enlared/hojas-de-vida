package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_maquina database table.
 * 
 */
@Entity
@Table(name="tipo_maquina")
@NamedQuery(name="TipoMaquina.findAll", query="SELECT t FROM TipoMaquina t")
public class TipoMaquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	public TipoMaquina() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}