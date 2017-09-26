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
@Table(name = "acompt_comptxtpmach")
public class ComptxTpMach {
	static final Logger log = Logger.getLogger(ComptxTpMach.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idcompxtpmac_seq")
	@SequenceGenerator(name = "idcompxtpmac_seq", sequenceName = "idcompxtpmac_sequence", allocationSize = 1)

	@Column(name = "idcompxtpmac")
	private long idcompxtpmac;

	@NotNull
	private long idanlcmp;

	@NotNull
	private long idtpmac;
	
	public ComptxTpMach() {

	}

	public ComptxTpMach(long idcompxtpmac, long idanlcmp, long idtpmac) {
		super();
		this.idcompxtpmac = idcompxtpmac;
		this.idanlcmp = idanlcmp;
		this.idtpmac = idtpmac;

	}

	
	public long getIdcompxtpmac() {
		return idcompxtpmac;
	}

	public void setIdcompxtpmac(long idcompxtpmac) {
		this.idcompxtpmac = idcompxtpmac;
	}

	public long getIdanlcmp() {
		return idanlcmp;
	}

	public void setIdanlcmp(long idanlcmp) {
		this.idanlcmp = idanlcmp;
	}

	public long getIdtpmac() {
		return idtpmac;
	}

	public void setIdtpmac(long idtpmac) {
		this.idtpmac = idtpmac;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Competencex tp Machine [idcompxtpmac=" + idcompxtpmac + ", idanlcmp=" + idanlcmp +
				", idtpmac=" + idtpmac + "]";
	}

}