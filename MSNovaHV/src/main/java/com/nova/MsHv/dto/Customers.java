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
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;

@Entity
@Table(name = "gnr_customers")
public class Customers {
	static final Logger log = Logger.getLogger(Customers.class);

	
	@NotNull
	private long codsap;

	@NotNull
	private Date contractstart;

	@Null
	private Date contractend;

	@NotNull
	private long objetiveyear;

	@NotNull
	private long objetivemonth;

	@NotNull
	private long idkbsn;

	@NotNull
	private long idrgn;

	@NotNull
	private long idkacnt;

	@NotNull
	private long idhqrt;

	@NotNull
	private long idinfbsn;
	
	@NotNull
	private long numberheadquarters;

	public Customers() {

	}

	public Customers(long codsap, Date contractstart, Date contractend, long objetiveyear,
			long objetivemonth, long idkbsn, long idrgn, long idkacnt, 
			long idhqrt, long idinfbsn, long numberheadquarters) {
		super();
		this.codsap = codsap;
		this.contractstart = contractstart;
		this.contractend = contractend;
		this.objetiveyear = objetiveyear;
		this.objetivemonth = objetivemonth;
		this.idkbsn = idkbsn;
		this.idrgn = idrgn;
		this.idkacnt = idkacnt;
		this.idhqrt = idhqrt;
		this.idinfbsn = idinfbsn;
		this.numberheadquarters = numberheadquarters;

	}

	
	public long getCodsap() {
		return codsap;
	}

	public void setCodsap(long codsap) {
		this.codsap = codsap;
	}

	public Date getContractstart() {
		return contractstart;
	}

	public void setContractstart(Date contractstart) {
		this.contractstart = contractstart;
	}

	public Date getContractend() {
		return contractend;
	}

	public void setContractend(Date contractend) {
		this.contractend = contractend;
	}

	public long getObjetiveyear() {
		return objetiveyear;
	}

	public void setObjetiveyear(long objetiveyear) {
		this.objetiveyear = objetiveyear;
	}

	public long getObjetivemonth() {
		return objetivemonth;
	}

	public void setObjetivemonth(long objetivemonth) {
		this.objetivemonth = objetivemonth;
	}

	public long getIdkbsn() {
		return idkbsn;
	}

	public void setIdkbsn(long idkbsn) {
		this.idkbsn = idkbsn;
	}

	public long getIdrgn() {
		return idrgn;
	}

	public void setIdrgn(long idrgn) {
		this.idrgn = idrgn;
	}

	public long getIdkacnt() {
		return idkacnt;
	}

	public void setIdkacnt(long idkacnt) {
		this.idkacnt = idkacnt;
	}

	public long getIdhqrt() {
		return idhqrt;
	}

	public void setIdhqrt(long idhqrt) {
		this.idhqrt = idhqrt;
	}

	public long getIdinfbsn() {
		return idinfbsn;
	}

	public void setIdinfbsn(long idinfbsn) {
		this.idinfbsn = idinfbsn;
	}

	public static Logger getLog() {
		return log;
	}
	


	public long getNumberheadquarters() {
		return numberheadquarters;
	}

	public void setNumberheadquarters(long numberheadquarters) {
		this.numberheadquarters = numberheadquarters;
	}

	@Override
	
	public String toString() {
		return "Customers [codsap=" + codsap + ", contractstart=" + contractstart + ", " + "contractend="
				+ contractend + ", objetiveyear=" + objetiveyear + ", objetivemonth=" + objetivemonth + ", idksbn="
				+ idkbsn + ", idrgn=" + idrgn + ", idkacnt=" + idkacnt
				+ ", idhqrt=" + idhqrt + ", idinfbsn=" + idinfbsn + ", numberheadquarters=" + numberheadquarters + "]";
	}

}
