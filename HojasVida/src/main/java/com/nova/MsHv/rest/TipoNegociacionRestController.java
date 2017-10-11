package com.nova.MsHv.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.entidad.TipoNegociacion;
import com.nova.MsHv.impl.TipoNegociacionImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class TipoNegociacionRestController {
	static final Logger log = Logger.getLogger(TipoNegociacionRestController.class);
	@Autowired
	TipoNegociacionImpl CategoriaImpl;

	@RequestMapping("typeNegociation/findall")
	@ResponseBody
	public List<TipoNegociacion> getCategoria() throws NovaHVDaoException {
		List<TipoNegociacion> categoria = new ArrayList<>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for type TipoNegociacion");
		try {

			categoria = CategoriaImpl.consultarTodos();
			if (categoria.equals(null)) {

				log.info("Log4j get the list type TipoNegociacion ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type TipoNegociacion" + e);
			throw new NovaHVDaoException(e);

		}

		return categoria;
	}


}
