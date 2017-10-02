package com.nova.MsHv.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer cantidadempleados;

	@ManyToOne
	@JoinColumn(name="tipoempleadoid")
	private TipoEmpleado tipoempleado;

	public TipoEmpleado getTipoempleado() {
		return tipoempleado;
	}

	public void setTipoempleado(TipoEmpleado tipoempleado) {
		this.tipoempleado = tipoempleado;
	}

	@ManyToOne
	@JoinColumn(name="clienteid")
	private Cliente cliente;

	//bi-directional many-to-one association to Sector
	@ManyToOne
	@JoinColumn(name="tipoclienteid")
	private Sector sector;

	public Sede() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidadempleados() {
		return this.cantidadempleados;
	}

	public void setCantidadempleados(Integer cantidadempleados) {
		this.cantidadempleados = cantidadempleados;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}