//package com.nova.MsHv.dto;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//
//import javax.persistence.Column;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Null;
//
//import org.apache.log4j.Logger;
//
//@Entity
//@Table(name = "gnr_keyaccount")
//public class ServiceLevelAgreement {
//	static final Logger log = Logger.getLogger(ServiceLevelAgreement.class);
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idsla_seq")
//	@SequenceGenerator(name = "idsla_seq", sequenceName = "idsla_sequence", allocationSize = 1)
//	@Column(name = "idsla")
//	private long idsla;
//
//	@NotNull
//	private String tecniquecurses;
//
//	@NotNull
//	private String brigadeclear;
//
//	@NotNull
//	private String others;
//
//	@NotNull
//	private String timeszones;
//
//	@NotNull
//	private String operationcurses;
//
//	@NotNull
//	private String especificclient;
//
//	@NotNull
//	private long idbilling;
//	
//	public ServiceLevelAgreement() {
//
//	}
//
//	public ServiceLevelAgreement(long idsla, String tecniquecurses,String brigadeclear,
//			String others, String timeszones, String operationcurses, 
//			String especificclient, long idbilling) {
//		super();
//		this.idsla = idsla;
//		this.tecniquecurses = tecniquecurses;
//		this.brigadeclear = brigadeclear;
//		this.others = others;
//		this.timeszones = timeszones;
//		this.operationcurses = operationcurses;
//		this.especificclient = especificclient;
//		this.idbilling = idbilling;
//	
//	}
//
//	
//	public long getIdsla() {
//		return idsla;
//	}
//
//	public void setIdsla(long idsla) {
//		this.idsla = idsla;
//	}
//
//	public String getTecniquecurses() {
//		return tecniquecurses;
//	}
//
//	public void setTecniquecurses(String tecniquecurses) {
//		this.tecniquecurses = tecniquecurses;
//	}
//
//	public String getBrigadeclear() {
//		return brigadeclear;
//	}
//
//	public void setBrigadeclear(String brigadeclear) {
//		this.brigadeclear = brigadeclear;
//	}
//
//	public String getOthers() {
//		return others;
//	}
//
//	public void setOthers(String others) {
//		this.others = others;
//	}
//
//	public String getTimeszones() {
//		return timeszones;
//	}
//
//	public void setTimeszones(String timeszones) {
//		this.timeszones = timeszones;
//	}
//
//	public String getOperationcurses() {
//		return operationcurses;
//	}
//
//	public void setOperationcurses(String operationcurses) {
//		this.operationcurses = operationcurses;
//	}
//
//	public String getEspecificclient() {
//		return especificclient;
//	}
//
//	public void setEspecificclient(String especificclient) {
//		this.especificclient = especificclient;
//	}
//
//	public long getIdbilling() {
//		return idbilling;
//	}
//
//	public void setIdbilling(long idbilling) {
//		this.idbilling = idbilling;
//	}
//
//	public static Logger getLog() {
//		return log;
//	}
//
//	@Override
//	public String toString() {
//		return "Service Level Agreement [idsla :" + idsla + ", tecniquecurses: " + tecniquecurses + 
//				", brigadeclear: " + brigadeclear + ", others: " + others
//				+ ", timeszones="+ timeszones + ", operationcurses: " + operationcurses + 
//				", especificclient" + especificclient+ ", idbilling:" + idbilling +"]";
//	}
//
//}
