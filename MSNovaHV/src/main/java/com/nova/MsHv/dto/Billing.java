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
@Table(name = "sla_billing")
public class Billing {
	static final Logger log = Logger.getLogger(Billing.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idbilling_seq")
	@SequenceGenerator(name = "idbilling_seq", sequenceName = "idbilling_sequence", allocationSize = 1)
	@Column(name = "idbilling")
	private long idbilling;

	@NotNull
	private String typesale;

	@NotNull
	private String oc;

	@NotNull
	private String place;

	@NotNull
	private String datemax;

	@NotNull
	private String crosspurse;

	@NotNull
	private long idtrmprs;

	@NotNull
	private long idtrmprsrnt;
	
	public Billing() {

	}

	public Billing(long idbilling, String typesale,String oc,String place,
			String datemax, String crosspurse, long idtrmprs, long idtrmprsrnt) {
		super();
		this.idbilling = idbilling;
		this.typesale = typesale;
		this.oc = oc;
		this.place = place;
		this.datemax = datemax;
		this.crosspurse = crosspurse;
		this.idtrmprs = idtrmprs;
		this.idtrmprsrnt = idtrmprsrnt;
	
	}

	

	public long getIdbilling() {
		return idbilling;
	}

	public void setIdbilling(long idbilling) {
		this.idbilling = idbilling;
	}

	public String getTypesale() {
		return typesale;
	}

	public void setTypesale(String typesale) {
		this.typesale = typesale;
	}

	public String getOc() {
		return oc;
	}

	public void setOc(String oc) {
		this.oc = oc;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDatemax() {
		return datemax;
	}

	public void setDatemax(String datemax) {
		this.datemax = datemax;
	}

	public String getCrosspurse() {
		return crosspurse;
	}

	public void setCrosspurse(String crosspurse) {
		this.crosspurse = crosspurse;
	}

	public long getIdtrmprs() {
		return idtrmprs;
	}

	public void setIdtrmprs(long idtrmprs) {
		this.idtrmprs = idtrmprs;
	}

	public long getIdtrmprsrnt() {
		return idtrmprsrnt;
	}

	public void setIdtrmprsrnt(long idtrmprsrnt) {
		this.idtrmprsrnt = idtrmprsrnt;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Billing [idbilling :" + idbilling + ", typesale: " + typesale 
				+ ", oc: " + oc + ", place: " + place
				+ ", datemax="+ datemax + ", crosspurse: " + crosspurse + ", idtrmprs" + idtrmprs 
				+ ", idtrmprsrnt" + idtrmprsrnt + "]";
	}

}
