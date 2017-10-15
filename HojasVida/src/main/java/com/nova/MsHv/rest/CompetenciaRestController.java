package com.nova.MsHv.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.entidad.Competencia;
import com.nova.MsHv.impl.CompetenciaImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;
import com.nova.MsHvExcepciones.NovaHVRestException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @customers enlaRed.co
 * @version 1.0
 */
public class CompetenciaRestController {
	static final Logger log = Logger.getLogger(CompetenciaRestController.class);
	@Autowired
	CompetenciaImpl impl;

	
	@RequestMapping(value = "competencia/find", method = RequestMethod.POST)
	@ResponseBody
	public List<Competencia> consultarSap(@RequestBody Competencia dato) throws NovaHVRestException {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for Competencia");
		 List<Competencia> var= new ArrayList<>();
		try {
			var = impl.consultarCliente(dato);
		} catch (Exception e) {
			log.error("Log4j Error in method Save for Competencia " + e);
			throw new NovaHVRestException(e);

		}
		return var;
	}

	

	@RequestMapping(value = "competencia/save", method = RequestMethod.POST)
	@ResponseBody
	public Competencia saveClientes(@RequestBody Competencia dato) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for Competencia");
		try {
			return impl.save(dato);
		} catch (Exception e) {
			log.error("Log4j Error in method Save for Competencia " + e);
			throw new NovaHVRestException(e);

		}

	}
	
	@RequestMapping(method = RequestMethod.POST, path = "competencia/delete")
	@ResponseBody
	public boolean getDelete(@RequestBody Competencia dato) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for Competencia");
		try {
			return impl.remove(dato);
		} catch (Exception e) {
			log.error("Log4j Error in method Delete for Competencia " + e);
			throw new NovaHVDaoException(e);
		}

	}


}

