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
@Table(name = "sla_termpursesub")
public class TermPurseSub {
	static final Logger log = Logger.getLogger(TermPurseSub.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtrmprs_seq")
	@SequenceGenerator(name = "idtrmprs_seq", sequenceName = "idtrmprs_sequence", allocationSize = 1)

	@Column(name = "idtrmprs")
	private long idtrmprs;

	@NotNull
	private String name;

	public TermPurseSub() {

	}

	public TermPurseSub(long idtrmprs, String name) {
		super();
		this.idtrmprs = idtrmprs;
		this.name = name;	

	}

	
	public long getIdtrmprs() {
		return idtrmprs;
	}

	public void setIdtrmprs(long idtrmprs) {
		this.idtrmprs = idtrmprs;
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
		return "Term Purse Sub [idtrmprs=" + idtrmprs + ", name=" + name + "]";
	}

}