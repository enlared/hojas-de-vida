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
//@Table(name = "cnt_contacthseq")
//public class ContactHseq {
//	static final Logger log = Logger.getLogger(ContactHseq.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idcnthseq_seq")
//	@SequenceGenerator(name = "idcnthseq_seq", sequenceName = "idcnthseq_sequence", allocationSize = 1)
//
//	@Column(name = "idcnthseq")
//	private long idcnthseq;
//
//	@NotNull
//	private String name;
//
//	@NotNull
//	private String telephone;
//	
//	@NotNull
//	private long idinfcnt;
//	
//	public ContactHseq() {
//
//	}
//
//	public ContactHseq(long idcnthseq, String name, long idinfcnt) {
//		super();
//		this.idcnthseq = idcnthseq;
//		this.name = name;
//		this.idinfcnt = idinfcnt;
//
//	}
//
//	
//	public long getIdcnthseq() {
//		return idcnthseq;
//	}
//
//	public void setIdcnthseq(long idcnthseq) {
//		this.idcnthseq = idcnthseq;
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
//	public String getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
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
//		return "ContactHseq [idcnthseq=" + idcnthseq+ ", name=" + name + ", idinfcnt=" + idinfcnt + "]";
//	}
//
//}