package com.udea.entidad_generica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "generico")
public class Generico {
	
	//atributo id con secuencia incremental
	/**@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_gen")
	@SequenceGenerator(name = "auto_gen", sequenceName = "auto_gen")
	@Column(name = "id")
	private long id;
	
	@NotNull
	private String code;
	
	@NotNull
	private String description;
	
	public Generico(){
		
	}
	
	
	public Generico(long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + "]";
	}	

	**/
}
