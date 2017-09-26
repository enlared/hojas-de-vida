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
@Table(name = "inf_anchorage")
public class Anchorage {
	static final Logger log = Logger.getLogger(Anchorage.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idanchg_seq")
	@SequenceGenerator(name = "idanchg_seq", sequenceName = "idanchg_sequence", allocationSize = 1)

	@Column(name = "idanchg")
	private long idanchg;

	@NotNull
	private String name;

	public Anchorage() {

	}

	public Anchorage(long idanchg, String name) {
		super();
		this.idanchg = idanchg;
		this.name = name;	

	}

	
	public long getIdanchg() {
		return idanchg;
	}

	public void setIdanchg(long idanchg) {
		this.idanchg = idanchg;
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
		return "Anchorage [idanchg=" + idanchg + ", name=" + name + "]";
	}

}