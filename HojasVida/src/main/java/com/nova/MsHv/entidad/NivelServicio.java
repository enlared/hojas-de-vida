package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the nivel_servicio database table.
 * 
 */
@Entity
@Table(name="nivel_servicio")
@NamedQuery(name="NivelServicio.findAll", query="SELECT n FROM NivelServicio n")
public class NivelServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String especificos;

	@Temporal(TemporalType.DATE)
	private Date facturacionfechamaximaradicacion;

	@Temporal(TemporalType.DATE)
	private Date facturacionfechasespeciales;

	private String facturacionlugarradicacion;

	private String facturacionmotivo;

	private String operacionescursos;

	private String operacionesfranjashorarias;

	private String tecnicosbrigadalimpieza;

	private String tecnicoscursos;

	private String tecnicosotros;

	//bi-directional many-to-one association to Correctivo
	@ManyToOne
	@JoinColumn(name="correctivosid")
	private Correctivo correctivo;

	//bi-directional many-to-one association to CruceCartera
	@ManyToOne
	@JoinColumn(name="crucecarteraid")
	private CruceCartera cruceCartera;

	//bi-directional many-to-one association to Fumigacione
	@ManyToOne
	@JoinColumn(name="fumigacionesid")
	private Fumigacione fumigacione;

	//bi-directional many-to-one association to PlazosCartera
	@ManyToOne
	@JoinColumn(name="plazoscarteraid")
	private PlazosCartera plazosCartera;
	
	//bi-directional many-to-one association to PlazosCartera
	@ManyToOne
	@JoinColumn(name="plazosarriendoid")
	private PlazosArriendo plazosArriendo;

	public PlazosArriendo getPlazosArriendo() {
		return plazosArriendo;
	}

	public void setPlazosArriendo(PlazosArriendo plazosArriendo) {
		this.plazosArriendo = plazosArriendo;
	}

	//bi-directional many-to-one association to Preventivo
	@ManyToOne
	@JoinColumn(name="preventivosid")
	private Preventivo preventivo;

	//bi-directional many-to-one association to RequiereCompra
	@ManyToOne
	@JoinColumn(name="requierecompraid")
	private RequiereCompra requiereCompra;

	//bi-directional many-to-one association to TipoVenta
	@ManyToOne
	@JoinColumn(name="tipoventaid")
	private TipoVenta tipoVenta;
	
	@Column(name="clienteid")
	private int clienteid;

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public NivelServicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecificos() {
		return this.especificos;
	}

	public void setEspecificos(String especificos) {
		this.especificos = especificos;
	}

	public Date getFacturacionfechamaximaradicacion() {
		return this.facturacionfechamaximaradicacion;
	}

	public void setFacturacionfechamaximaradicacion(Date facturacionfechamaximaradicacion) {
		this.facturacionfechamaximaradicacion = facturacionfechamaximaradicacion;
	}

	public Date getFacturacionfechasespeciales() {
		return this.facturacionfechasespeciales;
	}

	public void setFacturacionfechasespeciales(Date facturacionfechasespeciales) {
		this.facturacionfechasespeciales = facturacionfechasespeciales;
	}

	public String getFacturacionlugarradicacion() {
		return this.facturacionlugarradicacion;
	}

	public void setFacturacionlugarradicacion(String facturacionlugarradicacion) {
		this.facturacionlugarradicacion = facturacionlugarradicacion;
	}

	public String getFacturacionmotivo() {
		return this.facturacionmotivo;
	}

	public void setFacturacionmotivo(String facturacionmotivo) {
		this.facturacionmotivo = facturacionmotivo;
	}

	public String getOperacionescursos() {
		return this.operacionescursos;
	}

	public void setOperacionescursos(String operacionescursos) {
		this.operacionescursos = operacionescursos;
	}

	public String getOperacionesfranjashorarias() {
		return this.operacionesfranjashorarias;
	}

	public void setOperacionesfranjashorarias(String operacionesfranjashorarias) {
		this.operacionesfranjashorarias = operacionesfranjashorarias;
	}

	public String getTecnicosbrigadalimpieza() {
		return this.tecnicosbrigadalimpieza;
	}

	public void setTecnicosbrigadalimpieza(String tecnicosbrigadalimpieza) {
		this.tecnicosbrigadalimpieza = tecnicosbrigadalimpieza;
	}

	public String getTecnicoscursos() {
		return this.tecnicoscursos;
	}

	public void setTecnicoscursos(String tecnicoscursos) {
		this.tecnicoscursos = tecnicoscursos;
	}

	public String getTecnicosotros() {
		return this.tecnicosotros;
	}

	public void setTecnicosotros(String tecnicosotros) {
		this.tecnicosotros = tecnicosotros;
	}

	public Correctivo getCorrectivo() {
		return this.correctivo;
	}

	public void setCorrectivo(Correctivo correctivo) {
		this.correctivo = correctivo;
	}

	public CruceCartera getCruceCartera() {
		return this.cruceCartera;
	}

	public void setCruceCartera(CruceCartera cruceCartera) {
		this.cruceCartera = cruceCartera;
	}

	public Fumigacione getFumigacione() {
		return this.fumigacione;
	}

	public void setFumigacione(Fumigacione fumigacione) {
		this.fumigacione = fumigacione;
	}

	public PlazosCartera getPlazosCartera() {
		return this.plazosCartera;
	}

	public void setPlazosCartera(PlazosCartera plazosCartera) {
		this.plazosCartera = plazosCartera;
	}

	public Preventivo getPreventivo() {
		return this.preventivo;
	}

	public void setPreventivo(Preventivo preventivo) {
		this.preventivo = preventivo;
	}

	public RequiereCompra getRequiereCompra() {
		return this.requiereCompra;
	}

	public void setRequiereCompra(RequiereCompra requiereCompra) {
		this.requiereCompra = requiereCompra;
	}

	public TipoVenta getTipoVenta() {
		return this.tipoVenta;
	}

	public void setTipoVenta(TipoVenta tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

}