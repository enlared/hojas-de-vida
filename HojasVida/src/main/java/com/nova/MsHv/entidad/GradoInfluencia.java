package com.nova.MsHv.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the grado_influencia database table.
 * 
 */
@Entity
@Table(name="grado_influencia")
@NamedQuery(name="GradoInfluencia.findAll", query="SELECT g FROM GradoInfluencia g")
public class GradoInfluencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;


	public GradoInfluencia() {
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