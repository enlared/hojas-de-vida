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
@Table(name = "gnr_adt_customers")
public class AdtCustomer {
	static final Logger log = Logger.getLogger(AdtCustomer.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idadtcst_seq")
	@SequenceGenerator(name = "idadtcst_seq", sequenceName = "idadtcst_sequence", allocationSize = 1)
	@Column(name = "idadtcst")
	private long idadtcst;

	@NotNull
	private long sapadt;
	
	@NotNull
	private Date contractstartadt;
	
	@NotNull
	private Date constractendadt;
	
	@NotNull
	private long objetiveyearadt;
	
	@NotNull
	private long objetivemonthadt;	
	

	public AdtCustomer() {

	}

	public AdtCustomer(long idadtcst, long sapadt, Date contractstartadt, Date constractendadt,
			long objetiveyearadt, long objetivemonthadt) {
		super();
		this.idadtcst = idadtcst;
		this.sapadt = sapadt;
		this.contractstartadt = contractstartadt;
		this.constractendadt = constractendadt;
		this.objetiveyearadt = objetiveyearadt;
		this.objetivemonthadt = objetivemonthadt;

	}

	public long getIdadtcst() {
		return idadtcst;
	}

	public void setIdadtcst(long idadtcst) {
		this.idadtcst = idadtcst;
	}

	public long getSapadt() {
		return sapadt;
	}

	public void setSapadt(long sapadt) {
		this.sapadt = sapadt;
	}

	public Date getContractstartadt() {
		return contractstartadt;
	}

	public void setContractstartadt(Date contractstartadt) {
		this.contractstartadt = contractstartadt;
	}

	public Date getConstractendadt() {
		return constractendadt;
	}

	public void setConstractendadt(Date constractendadt) {
		this.constractendadt = constractendadt;
	}

	public long getObjetiveyearadt() {
		return objetiveyearadt;
	}

	public void setObjetiveyearadt(long objetiveyearadt) {
		this.objetiveyearadt = objetiveyearadt;
	}

	public long getObjetivemonthadt() {
		return objetivemonthadt;
	}

	public void setObjetivemonthadt(long objetivemonthadt) {
		this.objetivemonthadt = objetivemonthadt;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "ADT Customer [idadtcst=" + idadtcst + ", sapadt=" + sapadt +
				", contractstartadt=" + contractstartadt + ", constractendadt=" 
				+ constractendadt + ", objetiveyearadt=" + objetiveyearadt + 
				", objetivemonthadt=" + objetivemonthadt +"]";
	}

}
