package com.nova.MsHv.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

@Entity
@Table(name = "cnt_purse")
public class Purse {
	static final Logger log = Logger.getLogger(Purse.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idpurse_seq")
	@SequenceGenerator(name = "idpurse_seq", sequenceName = "idpurse_sequence", allocationSize = 1)

	@Column(name = "idpurse")
	private long idpurse;

	@NotNull
	private String name;

	@NotNull
	private String telephone;
	
	@NotNull
	private String celphone;
	
	@NotNull
	private String email;
	
	public Purse() {

	}

	public Purse(long idpurse, String name, String telephone,String celphone, String email) {
		super();
		this.idpurse = idpurse;
		this.name = name;
		this.telephone = telephone;
		this.celphone = celphone;
		this.email = email;

	}

	
	public long getIdpurse() {
		return idpurse;
	}

	public void setIdpurse(long idpurse) {
		this.idpurse = idpurse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Purse [idpurse=" + idpurse + ", name=" + name + ", celphone=" + celphone + 
				", telephone=" + telephone + ", email=" + email +"]";
	}

}