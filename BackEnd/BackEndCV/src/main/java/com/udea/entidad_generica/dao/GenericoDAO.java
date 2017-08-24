package com.udea.entidad_generica.dao;


import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.udea.entidad_generica.modelo.Generico;

//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
// obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Transactional
public interface GenericoDAO extends CrudRepository<Generico, Long> {
	
	// No es necesario implementar el metodo, spring jpa lo hace  siempre y cuando
	// el nombre del parametro coincida con un atributo de product
	// para mas detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	//public Generico findByCode(String code);

}

