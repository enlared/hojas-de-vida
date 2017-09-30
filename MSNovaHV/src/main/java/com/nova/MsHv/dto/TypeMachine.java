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
//@Table(name = "inf_typemachine")
//public class TypeMachine {
//	static final Logger log = Logger.getLogger(TypeMachine.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtpmac_seq")
//	@SequenceGenerator(name = "idtpmac_seq", sequenceName = "idtpmac_sequence", allocationSize = 1)
//
//	@Column(name = "idtpmac")
//	private long idtpmac;
//
//	@NotNull
//	private String name;
//
//	public TypeMachine() {
//
//	}
//
//	public TypeMachine(long idtpmac, String name) {
//		super();
//		this.idtpmac = idtpmac;
//		this.name = name;	
//
//	}
//
//
//	
//	public long getIdtpmac() {
//		return idtpmac;
//	}
//
//	public void setIdtpmac(long idtpmac) {
//		this.idtpmac = idtpmac;
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
//		return "Type Machine [idtpmac=" + idtpmac + ", name=" + name + "]";
//	}
//
//}