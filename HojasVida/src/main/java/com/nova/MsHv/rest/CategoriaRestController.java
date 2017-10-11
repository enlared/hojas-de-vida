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

import com.nova.MsHv.entidad.Categoria;
import com.nova.MsHv.impl.CategoriaImpl;
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
	CategoriaImpl categoriaImpl;

	@RequestMapping("categoria/findall")
	@ResponseBody
	public List<Categoria> getType() throws NovaHVDaoException {
		List<Categoria> type = new ArrayList<Categoria>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for type categoriaImpl");
		try {

			type = categoriaImpl.consultarTodos();
			if (type.equals(null)) {

				log.info("Log4j get the list type categoriaImpl ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type categoriaImpl" + e);
			throw new NovaHVDaoException(e);

		}

		return type;
	}


}
