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
//@Table(name = "inf_listprices")
//public class ListPrices {
//	static final Logger log = Logger.getLogger(ListPrices.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idlstprc_seq")
//	@SequenceGenerator(name = "idlstprc_seq", sequenceName = "idlstprc_sequence", allocationSize = 1)
//
//	@Column(name = "idlstprc")
//	private long idlstprc;
//
//	@NotNull
//	private String name;
//
//	public ListPrices() {
//
//	}
//
//	public ListPrices(long idlstprc, String name) {
//		super();
//		this.idlstprc = idlstprc;
//		this.name = name;	
//
//	}
//
//	
//	public long getIdlstprc() {
//		return idlstprc;
//	}
//
//	public void setIdlstprc(long idlstprc) {
//		this.idlstprc = idlstprc;
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
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "List Prices [idlstprc=" + idlstprc + ", name=" + name + "]";
//	}
//
//}