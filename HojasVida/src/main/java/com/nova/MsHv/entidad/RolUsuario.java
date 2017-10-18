package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rol_usuario database table.
 * 
 */
@Entity
@Table(name="rol_usuario")
@NamedQuery(name="RolUsuario.findAll", query="SELECT r FROM RolUsuario r")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date fechaRegistro;
	private Rol rol;
	private Usuario usuario;

	public RolUsuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	//bi-directional many-to-one association to Rol
    @OneToOne
	 @JoinColumn(name="rolid")
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


	@OneToOne(cascade = {CascadeType.ALL})

	@JoinColumn(name="usuarioid")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}