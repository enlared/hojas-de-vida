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
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;

@Entity
@Table(name = "gnr_typeemployees")
public class TypeEmployees {
	static final Logger log = Logger.getLogger(TypeEmployees.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idtpemp_seq")
	@SequenceGenerator(name = "idtpemp_seq", sequenceName = "idtpemp_sequence", allocationSize = 1)
	@Column(name = "idtpemp")
	private long idtpemp;

	@NotNull
	private String name;

	
	public TypeEmployees() {

	}

	public TypeEmployees(long idtpemp, String name) {
		super();
		this.idtpemp = idtpemp;
		this.name = name;
		

	}


	public long getIdtpemp() {
		return idtpemp;
	}

	public void setIdtpemp(long idtpemp) {
		this.idtpemp = idtpemp;
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
		return "type Employees [idtpemp=" + idtpemp + ", name=" + name 
				 + "]";
	}

}
