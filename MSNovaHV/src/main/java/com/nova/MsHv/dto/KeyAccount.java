package com.nova.MsHv.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;

@Entity
@Table(name = "gnr_keyaccount")
public class KeyAccount {
	static final Logger log = Logger.getLogger(KeyAccount.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idkacnt_seq")
	@SequenceGenerator(name = "idkacnt_seq", sequenceName = "idkacnt_sequence", allocationSize = 1)
	@Column(name = "idkacnt")
	private long idkacnt;

	@NotNull
	private String name;

	@NotNull
	private String userad;

	@NotNull
	private String email;

	@NotNull
	private long idkbsn;

	@NotNull
	private long idprf;

	@NotNull
	private long idrgn;

	
	public KeyAccount() {

	}

	public KeyAccount(long idkacnt, String name,String userad,String email,long idkbsn, long idprf, long idrgn) {
		super();
		this.idkacnt = idkacnt;
		this.name = name;
		this.userad = userad;
		this.email = email;
		this.idkbsn = idkbsn;
		this.idrgn = idrgn;
		this.idprf = idprf;
	
	}

	
	public long getIdkacnt() {
		return idkacnt;
	}

	public void setIdkacnt(long idkacnt) {
		this.idkacnt = idkacnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserad() {
		return userad;
	}

	public void setUserad(String userad) {
		this.userad = userad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdkbsn() {
		return idkbsn;
	}

	public void setIdkbsn(long idkbsn) {
		this.idkbsn = idkbsn;
	}

	public long getIdprf() {
		return idprf;
	}

	public void setIdprf(long idprf) {
		this.idprf = idprf;
	}

	public long getIdrgn() {
		return idrgn;
	}

	public void setIdrgn(long idrgn) {
		this.idrgn = idrgn;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "KeyAccount [idkacnt :" + idkacnt + ", name: " + name + ", userad: " + userad + ", email: " + email
				+ ", idkbsn="+ idkbsn + ", idrgn: " + idrgn + ", idprf" + idrgn +"]";
	}

}
