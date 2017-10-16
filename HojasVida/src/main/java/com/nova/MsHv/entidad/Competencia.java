package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the competencia database table.
 * 
 */
@Entity
@NamedQuery(name="Competencia.findAll", query="SELECT c FROM Competencia c")
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to CategoriaCompetencia
	@ManyToOne
	@JoinColumn(name="categoriacompetenciaid")
	private CategoriaCompetencia categoriaCompetencia;

	//bi-directional many-to-one association to TipoMaquina
	@ManyToOne
	@JoinColumn(name="tipomaquinaid")
	private TipoMaquina tipoMaquina;

	@Column(name="clienteid")
	private int clienteid;
	

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public Competencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaCompetencia getCategoriaCompetencia() {
		return this.categoriaCompetencia;
	}

	public void setCategoriaCompetencia(CategoriaCompetencia categoriaCompetencia) {
		this.categoriaCompetencia = categoriaCompetencia;
	}

	public TipoMaquina getTipoMaquina() {
		return this.tipoMaquina;
	}

	public void setTipoMaquina(TipoMaquina tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}


}