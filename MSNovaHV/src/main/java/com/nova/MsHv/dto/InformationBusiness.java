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
@Table(name = "inf_informationbusiness")
public class InformationBusiness {
	static final Logger log = Logger.getLogger(InformationBusiness.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idinfbsn_seq")
	@SequenceGenerator(name = "idinfbsn_seq", sequenceName = "idinfbsn_sequence", allocationSize = 1)
	@Column(name = "idinfbsn")
	private long idinfbsn;

	@NotNull
	private long numbermachine;

	@NotNull
	private String typeglass;

	@NotNull
	private Double totalsale;

	@NotNull
	private long idanchg;

	@NotNull
	private long idtpngc;

	@NotNull
	private long idlstprc;
	
	@NotNull
	private long idctg;

	@Null
	private long idsla;

	@Null
	private long idanlcmp;
	
	@NotNull
	private long idtpglass;

	public InformationBusiness() {

	}

	public InformationBusiness(long idinfbsn, long numbermachine,String typeglass, Double totalsale,
			long idanchg, long idtpngc, long idlstprc, long idctg, long idsla,long idanlcmp, long idtpglass) {
		super();
		this.idinfbsn = idinfbsn;
		this.numbermachine = numbermachine;
		this.typeglass = typeglass;
		this.totalsale = totalsale;
		this.idanchg = idanchg;
		this.idlstprc = idlstprc;
		this.idctg = idctg;
		this.idsla = idsla;
		this.idanlcmp = idanlcmp;
		this.idtpglass= idtpglass;
	
	}

	
	
	public long getIdinfbsn() {
		return idinfbsn;
	}

	public void setIdinfbsn(long idinfbsn) {
		this.idinfbsn = idinfbsn;
	}

	public long getNumbermachine() {
		return numbermachine;
	}

	public void setNumbermachine(long numbermachine) {
		this.numbermachine = numbermachine;
	}

	public String getTypeglass() {
		return typeglass;
	}

	public void setTypeglass(String typeglass) {
		this.typeglass = typeglass;
	}

	public Double getTotalsale() {
		return totalsale;
	}

	public void setTotalsale(Double totalsale) {
		this.totalsale = totalsale;
	}

	public long getIdanchg() {
		return idanchg;
	}

	public void setIdanchg(long idanchg) {
		this.idanchg = idanchg;
	}

	public long getIdtpngc() {
		return idtpngc;
	}

	public void setIdtpngc(long idtpngc) {
		this.idtpngc = idtpngc;
	}

	public long getIdlstprc() {
		return idlstprc;
	}

	public void setIdlstprc(long idlstprc) {
		this.idlstprc = idlstprc;
	}

	public long getIdctg() {
		return idctg;
	}

	public void setIdctg(long idctg) {
		this.idctg = idctg;
	}

	public long getIdsla() {
		return idsla;
	}

	public void setIdsla(long idsla) {
		this.idsla = idsla;
	}

	public long getIdanlcmp() {
		return idanlcmp;
	}

	public void setIdanlcmp(long idanlcmp) {
		this.idanlcmp = idanlcmp;
	}

	public static Logger getLog() {
		return log;
	}

	
	public long getIdtpglass() {
		return idtpglass;
	}

	public void setIdtpglass(long idtpglass) {
		this.idtpglass = idtpglass;
	}

	@Override
	public String toString() {
		return "Information Business [idinfbsn :" + idinfbsn + ", numbermachine: " + numbermachine + 
				", typeglass: " + typeglass + ", totalsale: " + totalsale
				+ ", idanchg: " + idanchg + ", idtpngc" + idtpngc + ", idlstprc" + idlstprc +
				", idctg= " + idctg + ", idsla=" + idsla + ", idanlcmp=" + idanlcmp + ", idtpglass=" + 
				idtpglass + "]";
	}

}