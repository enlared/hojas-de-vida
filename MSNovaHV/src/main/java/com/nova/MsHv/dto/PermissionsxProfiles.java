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
@Table(name = "gnr_permissionsxprofiles")
public class PermissionsxProfiles {
	static final Logger log = Logger.getLogger(PermissionsxProfiles.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgnrprmxprf_seq")
	@SequenceGenerator(name = "idgnrprmxprf_seq", sequenceName = "idgnrprmxprf_sequence", allocationSize = 1)

	@Column(name = "idgnrprmxprf")
	private long idgnrprmxprf;

	@NotNull
	private long idprf;

	@NotNull
	private long idprm;


	public PermissionsxProfiles() {

	}

	public PermissionsxProfiles(long idgnrprmxprf, long idprf, long idprm) {
		super();
		this.idgnrprmxprf = idgnrprmxprf;
		this.idprf = idprf;
		this.idprm = idprm;
	

	}
	
	public long getIdgnrprmxprf() {
		return idgnrprmxprf;
	}

	public void setIdgnrprmxprf(long idgnrprmxprf) {
		this.idgnrprmxprf = idgnrprmxprf;
	}

	public long getIdprf() {
		return idprf;
	}

	public void setIdprf(long idprf) {
		this.idprf = idprf;
	}

	public long getIdprm() {
		return idprm;
	}

	public void setIdprm(long idprm) {
		this.idprm = idprm;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Permission x Profiles [idgnrprmxprf=" + idgnrprmxprf + ", idprf=" + idprf + ", " + "idprm=" + idprm
				 + "]";
	}

}
