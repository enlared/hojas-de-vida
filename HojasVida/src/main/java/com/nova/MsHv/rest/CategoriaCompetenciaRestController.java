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

import com.nova.MsHv.entidad.CategoriaCompetencia;
import com.nova.MsHv.impl.CategoriaCompetenciaImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

public class CategoriaCompetenciaRestController {
	static final Logger log = Logger.getLogger(CategoriaCompetenciaRestController.class);
	@Autowired
	CategoriaCompetenciaImpl categoriaImpl;

	@RequestMapping("categoriaCompetencia/findall")
	@ResponseBody
	public List<CategoriaCompetencia> getType() throws NovaHVDaoException {
		List<CategoriaCompetencia> type = new ArrayList<>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for type CategoriaCompetencia");
		try {

			type = categoriaImpl.consultarTodos();
			if (type.equals(null)) {

				log.info("Log4j get the list type CategoriaCompetencia ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type CategoriaCompetencia" + e);
			throw new NovaHVDaoException(e);

		}

		return type;
	}


}
