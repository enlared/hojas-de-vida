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
@Table(name = "gnr_regionals")
public class Regionals {
	static final Logger log = Logger.getLogger(Regionals.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idrgn_seq")
	@SequenceGenerator(name = "idrgn_seq", sequenceName = "idrgn_sequence", allocationSize = 1)
	@Column(name = "idrgn")
	private long idrgn;

	@NotNull
	private String name;


	public Regionals() {

	}

	public Regionals(long idrgn, String name) {
		super();
		this.idrgn = idrgn;
		this.name = name;
		

	}

	
	public long getIdrgn() {
		return idrgn;
	}

	public void setIdrgn(long idrgn) {
		this.idrgn = idrgn;
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
		return "Regionals [idrgn=" + idrgn + ", name=" + name  + "]";
	}

}
