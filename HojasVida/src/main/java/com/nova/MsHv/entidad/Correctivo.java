package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the correctivos database table.
 * 
 */
@Entity
@Table(name="correctivos")
@NamedQuery(name="Correctivo.findAll", query="SELECT c FROM Correctivo c")
public class Correctivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;


	public Correctivo() {
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