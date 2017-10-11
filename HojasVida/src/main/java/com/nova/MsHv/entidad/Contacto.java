package com.nova.MsHv.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String celular;

	private String email;

	private String fechacumpleanos;

	private String nombre;

	private String telefono;

	private Long clienteid;

	//bi-directional many-to-one association to GradoInfluencia
	@ManyToOne
	@JoinColumn(name="gradoinfluenciaid")
	private GradoInfluencia gradoInfluencia;

	//bi-directional many-to-one association to InfluenciaCompra
	@ManyToOne
	@JoinColumn(name="influenciacompraid")
	private InfluenciaCompra influenciaCompra;

	//bi-directional many-to-one association to Modo
	@ManyToOne
	@JoinColumn(name="modoid")
	private Modo modo;

	public Contacto() {
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

	public String getFechacumpleanos() {
		return this.fechacumpleanos;
	}

	public void setFechacumpleanos(String fechacumpleanos) {
		this.fechacumpleanos = fechacumpleanos;
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

	public GradoInfluencia getGradoInfluencia() {
		return this.gradoInfluencia;
	}

	public void setGradoInfluencia(GradoInfluencia gradoInfluencia) {
		this.gradoInfluencia = gradoInfluencia;
	}

	public InfluenciaCompra getInfluenciaCompra() {
		return this.influenciaCompra;
	}

	public void setInfluenciaCompra(InfluenciaCompra influenciaCompra) {
		this.influenciaCompra = influenciaCompra;
	}

	public Modo getModo() {
		return this.modo;
	}

	public void setModo(Modo modo) {
		this.modo = modo;
	}

	public Long getClienteid() {
		return clienteid;
	}

	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}

}