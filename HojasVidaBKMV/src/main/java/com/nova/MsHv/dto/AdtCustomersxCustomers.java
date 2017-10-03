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
//@Table(name = "gnr_adtcustomersxcustomers")
//public class AdtCustomersxCustomers {
//	static final Logger log = Logger.getLogger(AdtCustomersxCustomers.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idadtcstxcst_seq")
//	@SequenceGenerator(name = "idadtcstxcst_seq", sequenceName = "idadtcstxcst_sequence", allocationSize = 1)
//	@Column(name = "idadtcstxcst")
//	private long idadtcstxcst;
//
//	@NotNull
//	private long codsap;
//
//	@NotNull
//	private long idadtcst;
//
//	public AdtCustomersxCustomers() {
//
//	}
//
//	public AdtCustomersxCustomers(long idadtcstxcst, long codsap, long idadtcst) {
//		super();
//		this.idadtcstxcst = idadtcstxcst;
//		this.codsap = codsap;
//		this.idadtcst = idadtcst;		
//	}
//	
//	public long getIdadtcstxcst() {
//		return idadtcstxcst;
//	}
//
//	public void setIdadtcstxcst(long idadtcstxcst) {
//		this.idadtcstxcst = idadtcstxcst;
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
//	public long getIdadtcst() {
//		return idadtcst;
//	}
//
//	public void setIdadtcst(long idadtcst) {
//		this.idadtcst = idadtcst;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Customer x Customer [idadtcstxcst=" + idadtcstxcst + ", codsap=" + codsap + ", "
//				+ "idadtcst=" + idadtcst +  "]";
//	}
//
//}
