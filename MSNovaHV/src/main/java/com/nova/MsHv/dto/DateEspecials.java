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
@Table(name = "sla_dateespecials")
public class DateEspecials {
	static final Logger log = Logger.getLogger(DateEspecials.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iddtspc_seq")
	@SequenceGenerator(name = "iddtspc_seq", sequenceName = "iddtspc_sequence", allocationSize = 1)
	@Column(name = "iddtspc")
	private long iddtspc;

	@NotNull
	private Date dateespecial;

	@NotNull
	private String motive;

	@NotNull
	private long idsla;
	
	public DateEspecials() {

	}

	public DateEspecials(long iddtspc, Date dateespecial, String motive, long idsla) {
		super();
		this.iddtspc = iddtspc;
		this.dateespecial = dateespecial;
		this.motive = motive;
		this.idsla = idsla;
	
	
	}
	
	public long getIddtspc() {
		return iddtspc;
	}

	public void setIddtspc(long iddtspc) {
		this.iddtspc = iddtspc;
	}

	public Date getDateespecial() {
		return dateespecial;
	}

	public void setDateespecial(Date dateespecial) {
		this.dateespecial = dateespecial;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public long getIdsla() {
		return idsla;
	}

	public void setIdsla(long idsla) {
		this.idsla = idsla;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Date Especials [iddtspc :" + iddtspc + ", dateespecial: " + dateespecial + ", motive: " 
				+ motive + ", idsla: " + idsla +"]";
	}

}
