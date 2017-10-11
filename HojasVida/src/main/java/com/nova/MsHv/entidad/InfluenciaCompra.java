package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the influencia_compra database table.
 * 
 */
@Entity
@Table(name="influencia_compra")
@NamedQuery(name="InfluenciaCompra.findAll", query="SELECT i FROM InfluenciaCompra i")
public class InfluenciaCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	public InfluenciaCompra() {
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