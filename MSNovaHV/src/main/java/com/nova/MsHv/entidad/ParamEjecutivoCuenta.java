package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the param_ejecutivo_cuenta database table.
 * 
 */
@Entity
@Table(name="param_ejecutivo_cuenta")
@NamedQuery(name="ParamEjecutivoCuenta.findAll", query="SELECT p FROM ParamEjecutivoCuenta p")
public class ParamEjecutivoCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private String nombre;

	public ParamEjecutivoCuenta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}