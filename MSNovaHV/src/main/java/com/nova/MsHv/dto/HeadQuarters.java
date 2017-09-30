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
//import javax.validation.constraints.Null;
//
//import org.apache.log4j.Logger;
//
//@Entity
//@Table(name = "gnr_headquarters")
//public class HeadQuarters{
//	static final Logger log = Logger.getLogger(HeadQuarters.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idhqrt_seq")
//	@SequenceGenerator(name = "idhqrt_seq", sequenceName = "idhqrt_sequence", allocationSize = 1)
//	@Column(name = "idhqrt")
//	private long idhqrt;
//
//	@NotNull
//	private String name;
//
//	@Null
//	private long idtpemp;
//
//	@NotNull
//	private long idsct;
//
//	@NotNull
//	private long codsap;
//
//	@NotNull
//	private long numberemployees;
//
//
//	public HeadQuarters() {
//
//	}
//
//	public HeadQuarters(long idhqrt, String name, long idtpemp, long idsct,
//			long codsap, long numberemployees) {
//		super();
//		this.idhqrt = idhqrt;
//		this.name = name;
//		this.idtpemp = idtpemp;
//		this.idsct =idsct;
//		this.codsap = codsap;
//		this.numberemployees = numberemployees;
//	
//	}
//
//	
//	public long getIdhqrt() {
//		return idhqrt;
//	}
//
//	public void setIdhqrt(long idhqrt) {
//		this.idhqrt = idhqrt;
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
//	public long getIdtpemp() {
//		return idtpemp;
//	}
//
//	public void setIdtpemp(long idtpemp) {
//		this.idtpemp = idtpemp;
//	}
//
//	public long getIdsct() {
//		return idsct;
//	}
//
//	public void setIdsct(long idsct) {
//		this.idsct = idsct;
//	}
//
//	public long getCodsap() {
//		return codsap;
//	}
//
//	public void setCodsap(long codsap) {
//		this.codsap = codsap;
//	}
//
//	public long getNumberemployees() {
//		return numberemployees;
//	}
//
//	public void setNumberemployees(long numberemployees) {
//		this.numberemployees = numberemployees;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	
//	public String toString() {
//		return "HeadQuarters [idhqrt=" + idhqrt + ", name=" + name + ", " + "idtpemp="
//				+ idtpemp + ", idsct=" + idsct + ", codsap=" + codsap + ", numberemployees="
//				+ numberemployees + "]";
//	}
//
//}