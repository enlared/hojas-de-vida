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
@Table(name = "sla_corrective")
public class Corrective {
	static final Logger log = Logger.getLogger(Corrective.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idcorrective_seq")
	@SequenceGenerator(name = "idcorrective_seq", sequenceName = "idcorrective_sequence", allocationSize = 1)

	@Column(name = "idcorrective")
	private long idcorrective;

	@NotNull
	private String name;

	@NotNull
	private long idsla;
	
	public Corrective() {

	}

	public Corrective(long idcorrective, String name, long idsla) {
		super();
		this.idcorrective = idcorrective;
		this.name = name;
		this.idsla = idsla;

	}

	
	public long getIdcorrective() {
		return idcorrective;
	}

	public void setIdcorrective(long idcorrective) {
		this.idcorrective = idcorrective;
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
		return "Corrective [idcorrective=" + idcorrective + ", name=" + name + ", idsla" + idsla + "]";
	}

}