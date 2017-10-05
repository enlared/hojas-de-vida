package com.nova.MsHv.rest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.entidad.Negocio;
import com.nova.MsHv.impl.NegocioImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class NegocioRestController {
	static final Logger log = Logger.getLogger(NegocioRestController.class);
	@Autowired
	NegocioImpl negocioImpl ;

	@RequestMapping(value = "negocio/save", method = RequestMethod.POST)
	@ResponseBody
	public Negocio getCategoria(@RequestBody Negocio data) throws NovaHVDaoException {
		Negocio negocio = new Negocio();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for type Negocio");
		try {

			negocio = negocioImpl.save(data);
			if (negocio.equals(null)) {

				log.info("Log4j pos the list type Negocio ");
			}
		} catch (Exception e) {
			throw new NovaHVDaoException(e);

		}

		return negocio;
	}


}
