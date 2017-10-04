package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_negociacion database table.
 * 
 */
@Entity
@Table(name="tipo_negociacion")
@NamedQuery(name="TipoNegociacion.findAll", query="SELECT t FROM TipoNegociacion t")
public class TipoNegociacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	public TipoNegociacion() {
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