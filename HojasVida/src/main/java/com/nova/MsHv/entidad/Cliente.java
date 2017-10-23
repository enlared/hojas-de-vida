package com.nova.MsHv.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String barrio;

	private String codigosap;

	private String direccion;

	private String email;

	private String fechafin;

	private String fechainicio;

	private String nit;

	private Integer numbersedes;

	private String numerocelular;

	private Integer objetivoanual;

	private Integer objetivomensual;

	private String razonsocial;

	private String telfonofijo;

	//bi-directional many-to-one association to EjecutivoCuenta
	@ManyToOne
	@JoinColumn(name="ejecutivocuentaid")
	private EjecutivoCuenta ejecutivoCuenta;

	//bi-directional many-to-one association to EjecutivoNegocio
	@ManyToOne
	@JoinColumn(name="ejecutivonegocioid")
	private EjecutivoNegocio ejecutivoNegocio;

	//bi-directional many-to-one association to Regionale
	@ManyToOne
	@JoinColumn(name="regionalid")
	private Regional regional;

	//bi-directional many-to-one association to TipoCliente
	@ManyToOne
	@JoinColumn(name="idtipocliente")
	private TipoCliente tipoCliente;

	public Cliente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Integer getNumbersedes() {
		return this.numbersedes;
	}

	public void setNumbersedes(Integer numbersedes) {
		this.numbersedes = numbersedes;
	}

	public String getNumerocelular() {
		return this.numerocelular;
	}

	public void setNumerocelular(String numerocelular) {
		this.numerocelular = numerocelular;
	}

	public Integer getObjetivoanual() {
		return this.objetivoanual;
	}

	public void setObjetivoanual(Integer objetivoanual) {
		this.objetivoanual = objetivoanual;
	}

	public Integer getObjetivomensual() {
		return this.objetivomensual;
	}

	public void setObjetivomensual(Integer objetivomensual) {
		this.objetivomensual = objetivomensual;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getTelfonofijo() {
		return this.telfonofijo;
	}

	public void setTelfonofijo(String telfonofijo) {
		this.telfonofijo = telfonofijo;
	}

	public EjecutivoCuenta getEjecutivoCuenta() {
		return this.ejecutivoCuenta;
	}

	public void setEjecutivoCuenta(EjecutivoCuenta ejecutivoCuenta) {
		this.ejecutivoCuenta = ejecutivoCuenta;
	}

	public EjecutivoNegocio getEjecutivoNegocio() {
		return this.ejecutivoNegocio;
	}

	public void setEjecutivoNegocio(EjecutivoNegocio ejecutivoNegocio) {
		this.ejecutivoNegocio = ejecutivoNegocio;
	}

	public Regional getRegional() {
		return this.regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public TipoCliente getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	
	

}