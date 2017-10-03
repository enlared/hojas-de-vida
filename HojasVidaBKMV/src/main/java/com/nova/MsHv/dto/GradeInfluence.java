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
//@Table(name = "cnt_gradeinfluence")
//public class GradeInfluence {
//	static final Logger log = Logger.getLogger(GradeInfluence.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgrdinfl_seq")
//	@SequenceGenerator(name = "idgrdinfl_seq", sequenceName = "idgrdinfl_sequence", allocationSize = 1)
//
//	@Column(name = "idgrdinfl")
//	private long idgrdinfl;
//
//	@NotNull
//	private String name;
//
//	public GradeInfluence() {
//
//	}
//
//	public GradeInfluence(long idgrdinfl, String name) {
//		super();
//		this.idgrdinfl = idgrdinfl;
//		this.name = name;	
//
//	}
//
//	
//	
//	public long getIdgrdinfl() {
//		return idgrdinfl;
//	}
//
//	public void setIdgrdinfl(long idgrdinfl) {
//		this.idgrdinfl = idgrdinfl;
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
//		return "GradeInfluence [idgrdinfl=" + idgrdinfl + ", name=" + name + "]";
//	}
//
//}