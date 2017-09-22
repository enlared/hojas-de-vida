package com.nova.MsHv.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

@Entity
@Table(name = "gnr_profiles")
public class Profiles {
	static final Logger log = Logger.getLogger(Profiles.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idprf_seq")
	@SequenceGenerator(name = "idprf_seq", sequenceName = "idprf_sequence", allocationSize = 1)
	@Column(name = "idprf")
	private long idprf;

	@NotNull
	private String name;

	

	public Profiles() {

	}

	public Profiles(long idprf, String name) {
		super();
		this.idprf = idprf;
		this.name = name;
		
	}

	
	public long getIdprf() {
		return idprf;
	}

	public void setIdprf(long idprf) {
		this.idprf = idprf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Profiles [idprf=" + idprf + ", name=" + name  + "]";
	}

}
