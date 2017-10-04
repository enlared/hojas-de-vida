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

import com.nova.MsHv.entidad.TipoVaso;
import com.nova.MsHv.impl.TipoVasoImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class CategoriaRestController {
	static final Logger log = Logger.getLogger(CategoriaRestController.class);
	@Autowired
	TipoVasoImpl tipoVasoImpl;

	@RequestMapping("categoria/findall")
	@ResponseBody
	public List<TipoVaso> getTypeGlassAll() throws NovaHVDaoException {
		List<TipoVaso> typeGlass = new ArrayList<TipoVaso>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for type glass");
		try {

			typeGlass = tipoVasoImpl.consultarTodos();
			if (typeGlass.equals(null)) {

				log.info("Log4j get the list type glass ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type glass" + e);
			throw new NovaHVDaoException(e);

		}

		return typeGlass;
	}


}
