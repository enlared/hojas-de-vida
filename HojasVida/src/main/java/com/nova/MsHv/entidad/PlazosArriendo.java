package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plazos_arriendo database table.
 * 
 */
@Entity
@Table(name="plazos_arriendo")
@NamedQuery(name="PlazosArriendo.findAll", query="SELECT p FROM PlazosArriendo p")
public class PlazosArriendo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	public PlazosArriendo() {
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