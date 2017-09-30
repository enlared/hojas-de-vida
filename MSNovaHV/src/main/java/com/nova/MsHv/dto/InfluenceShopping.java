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
//@Table(name = "cnt_influenceshopping")
//public class InfluenceShopping {
//	static final Logger log = Logger.getLogger(InfluenceShopping.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idinfshp_seq")
//	@SequenceGenerator(name = "idinfshp_seq", sequenceName = "idinfshp_sequence", allocationSize = 1)
//
//	@Column(name = "idinfshp")
//	private long idinfshp;
//
//	@NotNull
//	private String name;
//
//	@Null
//	private long idgrdinfl;
//	
//	public InfluenceShopping() {
//
//	}
//
//	public InfluenceShopping(long idinfshp, String name, long idgrdinfl) {
//		super();
//		this.idinfshp = idinfshp;
//		this.name = name;
//		this.idgrdinfl = idgrdinfl;
//
//	}
//
//	
//	public long getIdinfshp() {
//		return idinfshp;
//	}
//
//	public void setIdinfshp(long idinfshp) {
//		this.idinfshp = idinfshp;
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
//	public long getIdgrdinfl() {
//		return idgrdinfl;
//	}
//
//	public void setIdgrdinfl(long idgrdinfl) {
//		this.idgrdinfl = idgrdinfl;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Influence Shopping [idinfshp=" + idinfshp + ", name=" + name + ", idgrdinfl=" + idgrdinfl + "]";
//	}
//
//}