//package com.nova.MsHv.dto;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.validation.constraints.NotNull;
//
//import org.apache.log4j.Logger;
//
//@Entity
//@Table(name = "acompt_competition")
//public class Competition {
//	static final Logger log = Logger.getLogger(Competition.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idanlcmp_seq")
//	@SequenceGenerator(name = "idanlcmp_seq", sequenceName = "idanlcmp_sequence", allocationSize = 1)
//
//	@Column(name = "idanlcmp")
//	private long idanlcmp;
//
//	@NotNull
//	private String name;
//
//	@NotNull
//	private long idctg;
//	
//	public Competition() {
//
//	}
//
//	public Competition(long idanlcmp, String name, long idctg) {
//		super();
//		this.idanlcmp = idanlcmp;
//		this.name = name;
//		this.idctg =  idctg;
//
//	}
//
//	
//	public long getIdanlcmp() {
//		return idanlcmp;
//	}
//
//	public void setIdanlcmp(long idanlcmp) {
//		this.idanlcmp = idanlcmp;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public long getIdctg() {
//		return idctg;
//	}
//
//	public void setIdctg(long idctg) {
//		this.idctg = idctg;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Competition [idanlcmp=" + idanlcmp + ", name=" + name + "idctg" + idctg + "]";
//	}
//
//}