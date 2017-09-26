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
@Table(name = "sla_preventive")
public class Preventive {
	static final Logger log = Logger.getLogger(Preventive.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idprv_seq")
	@SequenceGenerator(name = "idprv_seq", sequenceName = "idprv_sequence", allocationSize = 1)

	@Column(name = "idprv")
	private long idprv;

	@NotNull
	private String name;

	@NotNull
	private long idsla;
	
	public Preventive() {

	}

	public Preventive(long idprv, String name, long idsla) {
		super();
		this.idprv = idprv;
		this.name = name;
		this.idsla = idsla;

	}

	
	public long getIdprv() {
		return idprv;
	}

	public void setIdprv(long idprv) {
		this.idprv = idprv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIdsla() {
		return idsla;
	}

	public void setIdsla(long idsla) {
		this.idsla = idsla;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Preventive [idprv=" + idprv + ", name=" + name + ", idsla=" + idsla +"]";
	}

}