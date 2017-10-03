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
//@Table(name = "inf_typenegociation")
//public class TypeNegociation {
//	static final Logger log = Logger.getLogger(TypeNegociation.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtpngc_seq")
//	@SequenceGenerator(name = "idtpngc_seq", sequenceName = "idtpngc_sequence", allocationSize = 1)
//
//	@Column(name = "idtpngc")
//	private long idtpngc;
//
//	@NotNull
//	private String name;
//
//	@NotNull
//	private Double value;
//	
//	public TypeNegociation() {
//
//	}
//
//	public TypeNegociation(long idtpngc, String name, Double value) {
//		super();
//		this.idtpngc = idtpngc;
//		this.name = name;
//		this.value = value;
//
//	}
//
//	
//	public long getIdtpngc() {
//		return idtpngc;
//	}
//
//	public void setIdtpngc(long idtpngc) {
//		this.idtpngc = idtpngc;
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
//	public Double getValue() {
//		return value;
//	}
//
//	public void setValue(Double value) {
//		this.value = value;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Type Negociation [idtpngc=" + idtpngc + ", name=" + name + ", value=" + value + "]";
//	}
//
//}