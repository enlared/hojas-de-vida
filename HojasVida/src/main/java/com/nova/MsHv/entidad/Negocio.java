package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the negocio database table.
 * 
 */
@Entity
@NamedQuery(name="Negocio.findAll", query="SELECT n FROM Negocio n")
public class Negocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer numeromaquina;

	private Integer totalsale;

	//bi-directional many-to-one association to Anclaje
	@ManyToOne
	@JoinColumn(name="anchoragedataid")
	private Anclaje anclaje;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categorydataid")
	private Categoria categoria;

	private Integer clienteid;

	//bi-directional many-to-one association to ListaPrecio
	@ManyToOne
	@JoinColumn(name="listpricesdataid")
	private ListaPrecio listaPrecio;

	//bi-directional many-to-one association to TipoMaquina
	@ManyToOne
	@JoinColumn(name="typemachinedataid")
	private TipoMaquina tipoMaquina;

	//bi-directional many-to-one association to TipoNegociacion
	@ManyToOne
	@JoinColumn(name="typenegociationdataid")
	private TipoNegociacion tipoNegociacion;

	
	private int tipoVasoId;

	public Negocio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeromaquina() {
		return this.numeromaquina;
	}

	public void setNumeromaquina(Integer numeromaquina) {
		this.numeromaquina = numeromaquina;
	}

	public Integer getTotalsale() {
		return this.totalsale;
	}

	public void setTotalsale(Integer totalsale) {
		this.totalsale = totalsale;
	}

	public Anclaje getAnclaje() {
		return this.anclaje;
	}

	public void setAnclaje(Anclaje anclaje) {
		this.anclaje = anclaje;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ListaPrecio getListaPrecio() {
		return this.listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public TipoMaquina getTipoMaquina() {
		return this.tipoMaquina;
	}

	public void setTipoMaquina(TipoMaquina tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public TipoNegociacion getTipoNegociacion() {
		return this.tipoNegociacion;
	}

	public void setTipoNegociacion(TipoNegociacion tipoNegociacion) {
		this.tipoNegociacion = tipoNegociacion;
	}


	public Integer getClienteid() {
		return clienteid;
	}

	public void setClienteid(Integer clienteid) {
		this.clienteid = clienteid;
	}

	public Integer getTipoVasoId() {
		return tipoVasoId;
	}

	public void setTipoVasoId(Integer tipoVasoId) {
		this.tipoVasoId = tipoVasoId;
	}

}