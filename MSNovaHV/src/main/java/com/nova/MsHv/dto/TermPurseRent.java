package com.nova.MsHv.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

@Entity
@Table(name = "sla_termpurserent")
public class TermPurseRent {
	static final Logger log = Logger.getLogger(TermPurseRent.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtrmprsrnt_seq")
	@SequenceGenerator(name = "idtrmprsrnt_seq", sequenceName = "idtrmprsrnt_sequence", allocationSize = 1)

	@Column(name = "idtrmprsrnt")
	private long idtrmprsrnt;

	@NotNull
	private String name;

	public TermPurseRent() {

	}

	public TermPurseRent(long idtrmprsrnt, String name) {
		super();
		this.idtrmprsrnt = idtrmprsrnt;
		this.name = name;	

	}

	
	public long getIdtrmprsrnt() {
		return idtrmprsrnt;
	}

	public void setIdtrmprsrnt(long idtrmprsrnt) {
		this.idtrmprsrnt = idtrmprsrnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Term Purse Rent [idtrmprsrnt=" + idtrmprsrnt + ", name=" + name + "]";
	}

}