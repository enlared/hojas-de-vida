package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contacto_hseq database table.
 * 
 */
@Entity
@Table(name="contacto_hseq")
@NamedQuery(name="ContactoHseq.findAll", query="SELECT c FROM ContactoHseq c")
public class ContactoHseq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String telefono;

	private int clienteid;

	public ContactoHseq() {
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

}