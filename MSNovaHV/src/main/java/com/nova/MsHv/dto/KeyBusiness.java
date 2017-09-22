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
@Table(name = "gnr_keybusiness")
public class KeyBusiness {
	static final Logger log = Logger.getLogger(KeyBusiness.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idkbsn_seq")
	@SequenceGenerator(name = "idkbsn_seq", sequenceName = "idkbsn_sequence", allocationSize = 1)
	@Column(name = "idkbsn")
	private long idkbsn;

	@NotNull
	private String name;

	@NotNull
	private String userad;

	@NotNull
	private String email;

	@NotNull
	private long idrgn;

	@NotNull
	private long idprf;

	
	public KeyBusiness() {

	}

	public KeyBusiness(long idkbsn, String name,String userad,String email,long idrgn, long idprf) {
		super();
		this.idkbsn = idkbsn;
		this.name = name;
		this.userad = userad;
		this.email = email;
		this.idrgn = idrgn;
		this.idprf = idprf;
	
	}

	public long getIdkbsn() {
		return idkbsn;
	}

	public void setIdkbsn(long idkbsn) {
		this.idkbsn = idkbsn;
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

	public long getIdrgn() {
		return idrgn;
	}

	public void setIdrgn(long idrgn) {
		this.idrgn = idrgn;
	}

	public long getIdprf() {
		return idprf;
	}

	public void setIdprf(long idprf) {
		this.idprf = idprf;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "KeyBusiness [idkbsn :" + idkbsn + ", name: " + name + ", userad: " + userad + ", email: " + email
				+ ", idrgn: " + idrgn + ", idprf" + idrgn +"]";
	}

}
