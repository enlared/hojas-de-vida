package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contacto_cartera database table.
 * 
 */
@Entity
@Table(name="contacto_cartera")
@NamedQuery(name="ContactoCartera.findAll", query="SELECT c FROM ContactoCartera c")
public class ContactoCartera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String celular;

	private String email;

	private String nombre;

	private String telefono;

	private Long clienteid;

	public ContactoCartera() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getClienteid() {
		return clienteid;
	}

	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}
}