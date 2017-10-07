package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="influenciaCompra")
	private List<Contacto> contactos;

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

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setInfluenciaCompra(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setInfluenciaCompra(null);

		return contacto;
	}

}