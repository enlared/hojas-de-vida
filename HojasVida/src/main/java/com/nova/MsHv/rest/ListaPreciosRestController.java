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

import com.nova.MsHv.entidad.ListaPrecio;
import com.nova.MsHv.impl.ListaDePreciosImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class ListaPreciosRestController {
	static final Logger log = Logger.getLogger(ListaPreciosRestController.class);
	@Autowired
	ListaDePreciosImpl listaDePreciosImpl;

	@RequestMapping("listPrices/findall")
	@ResponseBody
	public List<ListaPrecio> getCategoria() throws NovaHVDaoException {
		List<ListaPrecio> categoria = new ArrayList<>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for type Categoria");
		try {

			categoria = listaDePreciosImpl.consultarTodos();
			if (categoria.equals(null)) {

				log.info("Log4j get the list type Categoria ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type Categoria" + e);
			throw new NovaHVDaoException(e);

		}

		return categoria;
	}


}
