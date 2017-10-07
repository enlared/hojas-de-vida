package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String celular;

	@Column(name="celular_cartera")
	private String celularCartera;

	private String email;

	@Column(name="email_cartera")
	private String emailCartera;

	@Temporal(TemporalType.DATE)
	private Date fechacumpleaños;

	private String nombre;

	@Column(name="nombre_cartera")
	private String nombreCartera;

	private String telefono;

	@Column(name="telefono_cartera")
	private String telefonoCartera;

	private int clienteid;

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

	public String getCelularCartera() {
		return this.celularCartera;
	}

	public void setCelularCartera(String celularCartera) {
		this.celularCartera = celularCartera;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailCartera() {
		return this.emailCartera;
	}

	public void setEmailCartera(String emailCartera) {
		this.emailCartera = emailCartera;
	}

	public Date getFechacumpleaños() {
		return this.fechacumpleaños;
	}

	public void setFechacumpleaños(Date fechacumpleaños) {
		this.fechacumpleaños = fechacumpleaños;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCartera() {
		return this.nombreCartera;
	}

	public void setNombreCartera(String nombreCartera) {
		this.nombreCartera = nombreCartera;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoCartera() {
		return this.telefonoCartera;
	}

	public void setTelefonoCartera(String telefonoCartera) {
		this.telefonoCartera = telefonoCartera;
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

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

}