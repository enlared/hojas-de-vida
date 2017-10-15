package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categoria_competencia database table.
 * 
 */
@Entity
@Table(name="categoria_competencia")
@NamedQuery(name="CategoriaCompetencia.findAll", query="SELECT c FROM CategoriaCompetencia c")
public class CategoriaCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	public CategoriaCompetencia() {
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