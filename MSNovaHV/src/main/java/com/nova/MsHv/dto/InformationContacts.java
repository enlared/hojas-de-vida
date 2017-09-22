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
@Table(name = "cnt_informationcontacts")
public class InformationContacts {
	static final Logger log = Logger.getLogger(InformationContacts.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idinfcnt_seq")
	@SequenceGenerator(name = "idinfcnt_seq", sequenceName = "idinfcnt_sequence", allocationSize = 1)

	@Column(name = "idinfcnt")
	private long idinfcnt;

	@NotNull
	private String name;

	@NotNull
	private String telephone;
	
	@NotNull
	private String celphone;
	
	@NotNull
	private String email;
	
	@NotNull
	private Date birthdaydate;
	
	@NotNull
	private long idinfshp;
	
	@Null
	private long idpurse;
	
	public InformationContacts() {

	}

	public InformationContacts(long idinfcnt, String name, String telephone, String celphone, String email,
			Date birthdaydate, long idinfshp, long idpurse) {
		super();
		this.idinfcnt = idinfcnt;
		this.name = name;	
		this.telephone = telephone;
		this.celphone = celphone;
		this.email = email;
		this.birthdaydate = birthdaydate;
		this.idinfshp = idinfshp;
		this.idpurse = idpurse;

	}

	
	public long getIdinfcnt() {
		return idinfcnt;
	}

	public void setIdinfcnt(long idinfcnt) {
		this.idinfcnt = idinfcnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdaydate() {
		return birthdaydate;
	}

	public void setBirthdaydate(Date birthdaydate) {
		this.birthdaydate = birthdaydate;
	}

	public long getIdinfshp() {
		return idinfshp;
	}

	public void setIdinfshp(long idinfshp) {
		this.idinfshp = idinfshp;
	}

	public long getIdpurse() {
		return idpurse;
	}

	public void setIdpurse(long idpurse) {
		this.idpurse = idpurse;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Information Contacts [idinfcnt=" + idinfcnt + ", name=" + name + 
				", telephone=" + telephone + ", celphone=" + celphone + ", email=" + email +
				", birthdaydate=" + birthdaydate + ", idinfshp=" + idinfshp +
				", idpurse=" + idpurse + "]";
	}

}