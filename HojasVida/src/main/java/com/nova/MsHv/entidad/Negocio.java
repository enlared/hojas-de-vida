package com.nova.MsHv.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the negocio database table.
 * 
 */
@Entity
@NamedQuery(name="Negocio.findAll", query="SELECT n FROM Negocio n")
public class Negocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer clienteid;

	private Integer numeromaquina;

	private Integer totalsale;
	
	private Integer valorTipoNegociacion;


	//bi-directional many-to-one association to Anclaje
	@ManyToOne
	@JoinColumn(name="anchoragedataid")
	private Anclaje anclaje;


	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categorydataid")
	private Categoria categoria;


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


	//bi-directional many-to-one association to TipoVaso
	@ManyToOne
	@JoinColumn(name="tipovasoid")
	private TipoVaso tipoVaso;


	public Negocio() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getClienteid() {
		return clienteid;
	}


	public void setClienteid(Integer clienteid) {
		this.clienteid = clienteid;
	}


	public Integer getNumeromaquina() {
		return numeromaquina;
	}


	public void setNumeromaquina(Integer numeromaquina) {
		this.numeromaquina = numeromaquina;
	}


	public Integer getTotalsale() {
		return totalsale;
	}


	public void setTotalsale(Integer totalsale) {
		this.totalsale = totalsale;
	}


	public Anclaje getAnclaje() {
		return anclaje;
	}


	public void setAnclaje(Anclaje anclaje) {
		this.anclaje = anclaje;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}


	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}


	public TipoMaquina getTipoMaquina() {
		return tipoMaquina;
	}


	public void setTipoMaquina(TipoMaquina tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}


	public TipoNegociacion getTipoNegociacion() {
		return tipoNegociacion;
	}


	public void setTipoNegociacion(TipoNegociacion tipoNegociacion) {
		this.tipoNegociacion = tipoNegociacion;
	}


	public TipoVaso getTipoVaso() {
		return tipoVaso;
	}


	public void setTipoVaso(TipoVaso tipoVaso) {
		this.tipoVaso = tipoVaso;
	}


	public Integer getValorTipoNegociacion() {
		return valorTipoNegociacion;
	}


	public void setValorTipoNegociacion(Integer valorTipoNegociacion) {
		this.valorTipoNegociacion = valorTipoNegociacion;
	}

	

}