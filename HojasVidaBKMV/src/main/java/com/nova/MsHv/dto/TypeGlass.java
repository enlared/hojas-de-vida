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
//@Table(name = "inf_typeglass")
//public class TypeGlass {
//	static final Logger log = Logger.getLogger(TypeGlass.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtpglass_seq")
//	@SequenceGenerator(name = "idtpglass_seq", sequenceName = "idtpglass_sequence", allocationSize = 1)
//	@Column(name = "idtpglass")
//	private long idtpglass;
//
//	@NotNull
//	private String typeglass;
//	
//	
//	public TypeGlass() {
//
//	}
//
//	public TypeGlass(long idtpglass, String typeglass) {
//		super();
//		this.idtpglass = idtpglass;
//		this.typeglass = typeglass;
//	}
//
//
//
//	public long getIdtpglass() {
//		return idtpglass;
//	}
//
//	public void setIdtpglass(long idtpglass) {
//		this.idtpglass = idtpglass;
//	}
//
//	public String getTypeglass() {
//		return typeglass;
//	}
//
//	public void setTypeglass(String typeglass) {
//		this.typeglass = typeglass;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Type Glass [idtpglass=" + idtpglass + ", typeglass=" + typeglass +
//				"]";
//	}
//
//}
