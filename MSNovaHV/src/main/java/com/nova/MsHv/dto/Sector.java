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
@Table(name = "gnr_sector")
public class Sector {
	static final Logger log = Logger.getLogger(Sector.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idsct_seq")
	@SequenceGenerator(name = "idsct_seq", sequenceName = "idsct_sequence", allocationSize = 1)

	@Column(name = "idsct")
	private long idsct;

	@NotNull
	private String name;

	public Sector() {

	}

	public Sector(long idsct, String name) {
		super();
		this.idsct = idsct;
		this.name = name;	

	}

	
	public long getIdsct() {
		return idsct;
	}

	public void setIdsct(long idsct) {
		this.idsct = idsct;
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
		return "Sector [idsct=" + idsct + ", name=" + name + "]";
	}

}
