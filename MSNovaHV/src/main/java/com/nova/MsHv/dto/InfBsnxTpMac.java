package com.nova.MsHv.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;

@Entity
@Table(name = "inf_infbsnxtpmac")
public class InfBsnxTpMac {
	static final Logger log = Logger.getLogger(InfBsnxTpMac.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idinfbsnxtpmac_seq")
	@SequenceGenerator(name = "idinfbsnxtpmac_seq", sequenceName = "idinfbsnxtpmac_sequence", allocationSize = 1)
	@Column(name = "idinfbsnxtpmac")
	private long idinfbsnxtpmac;

	@NotNull
	private long idinfbsn;
	
	@NotNull
	private long idtpmac;

	public InfBsnxTpMac() {

	}

	public InfBsnxTpMac(long idinfbsnxtpmac, long idinfbsn, long idtpmac) {
		super();
		this.idinfbsnxtpmac = idinfbsnxtpmac;
		this.idinfbsn = idinfbsn;
		this.idtpmac = idtpmac;
	
	}

	
	public long getIdinfbsnxtpmac() {
		return idinfbsnxtpmac;
	}

	public void setIdinfbsnxtpmac(long idinfbsnxtpmac) {
		this.idinfbsnxtpmac = idinfbsnxtpmac;
	}

	public long getIdinfbsn() {
		return idinfbsn;
	}

	public void setIdinfbsn(long idinfbsn) {
		this.idinfbsn = idinfbsn;
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
		return "Inf Business x Type Machine [idinfbsnxtpmac :" + idinfbsnxtpmac + ", idinfbsn: " + idinfbsn + 
				", idtpmac: " + idtpmac  + "]";
	}

}