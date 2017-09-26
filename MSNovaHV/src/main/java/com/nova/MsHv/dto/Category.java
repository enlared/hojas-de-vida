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
@Table(name = "inf_category")
public class Category {
	static final Logger log = Logger.getLogger(Category.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idctg_seq")
	@SequenceGenerator(name = "idctg_seq", sequenceName = "idctg_sequence", allocationSize = 1)

	@Column(name = "idctg")
	private long idctg;

	@NotNull
	private String name;

	public Category() {

	}

	public Category(long idctg, String name) {
		super();
		this.idctg = idctg;
		this.name = name;	

	}

	
	public long getIdctg() {
		return idctg;
	}

	public void setIdctg(long idctg) {
		this.idctg = idctg;
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
		return "Category [idctg=" + idctg + ", name=" + name + "]";
	}

}