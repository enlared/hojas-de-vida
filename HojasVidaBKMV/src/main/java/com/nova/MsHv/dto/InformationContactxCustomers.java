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
//@Table(name = "cnt_informationcontactxcustmers")
//public class InformationContactxCustomers {
//	static final Logger log = Logger.getLogger(InformationContactxCustomers.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgnrinfcontc_seq")
//	@SequenceGenerator(name = "idgnrinfcontc_seq", sequenceName = "idgnrinfcontc_sequence", allocationSize = 1)
//
//	@Column(name = "idgnrinfcontc")
//	private long idgnrinfcontc;
//
//	@NotNull
//	private long codsap;
//	
//	@NotNull
//	private long idinfcnt;
//
//	public InformationContactxCustomers() {
//
//	}
//
//	public InformationContactxCustomers(long idgnrinfcontc, long codsap, long idinfcnt) {
//		super();
//		this.idgnrinfcontc = idgnrinfcontc;
//		this.codsap = codsap;
//		this.idinfcnt = idinfcnt;
//
//	}
//
//	
//	public long getIdgnrinfcontc() {
//		return idgnrinfcontc;
//	}
//
//	public void setIdgnrinfcontc(long idgnrinfcontc) {
//		this.idgnrinfcontc = idgnrinfcontc;
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
//	public long getIdinfcnt() {
//		return idinfcnt;
//	}
//
//	public void setIdinfcnt(long idinfcnt) {
//		this.idinfcnt = idinfcnt;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Information Contact x Customers [idgnrinfcontc=" + idgnrinfcontc + ", codsap=" + codsap +
//				", idinfcnt=" + idinfcnt +"]";
//	}
//
//}