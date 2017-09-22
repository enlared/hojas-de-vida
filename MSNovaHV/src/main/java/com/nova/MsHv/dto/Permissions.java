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
@Table(name = "gnr_permissions")
public class Permissions {
	static final Logger log = Logger.getLogger(Permissions.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idprm_seq")
	@SequenceGenerator(name = "idprm_seq", sequenceName = "idprm_sequence", allocationSize = 1)
	@Column(name = "idprm")
	private long idprm;

	@NotNull
	private String name;

	
	public Permissions() {

	}

	public Permissions(long idprm, String name) {
		super();
		this.idprm = idprm;
		this.name = name;


	}
	

	public long getIdprm() {
		return idprm;
	}

	public void setIdprm(long idprm) {
		this.idprm = idprm;
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
		return "Permissions [idprm=" + idprm + ", name=" + name
				+ "]";
	}

}
