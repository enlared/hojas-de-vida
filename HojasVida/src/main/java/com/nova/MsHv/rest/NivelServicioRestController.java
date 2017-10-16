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

import com.nova.MsHv.entidad.NivelServicio;
import com.nova.MsHv.impl.NivelServicioImpl;
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
public class NivelServicioRestController {
	static final Logger log = Logger.getLogger(NivelServicioRestController.class);
	@Autowired
	NivelServicioImpl impl;

	
	@RequestMapping(value = "nivelServicio/find", method = RequestMethod.POST)
	@ResponseBody
	public List<NivelServicio> consultarSap(@RequestBody NivelServicio dato) throws NovaHVRestException {
		PropertyConfigurator.configure("log4j.properties");
		 List<NivelServicio> var= new ArrayList<>();
		try {
			var = impl.consultarCliente(dato);
		} catch (Exception e) {
			log.error("Log4j Error in method Save for NivelServicio " + e);
			throw new NovaHVRestException(e);

		}
		return var;
	}

	

	@RequestMapping(value = "nivelServicio/save", method = RequestMethod.POST)
	@ResponseBody
	public NivelServicio saveClientes(@RequestBody NivelServicio dato) throws NovaHVRestException {
		PropertyConfigurator.configure("log4j.properties");
		try {
			return impl.save(dato);
		} catch (Exception e) {
			log.error("Log4j Error in method Save for NivelServicio " + e);
			throw new NovaHVRestException(e);

		}

	}
	
	@RequestMapping(method = RequestMethod.POST, path = "nivelServicio/delete")
	@ResponseBody
	public boolean getDelete(@RequestBody NivelServicio dato) throws NovaHVDaoException {
		PropertyConfigurator.configure("log4j.properties");
		try {
			return impl.remove(dato);
		} catch (Exception e) {
			log.error("Log4j Error in method Delete for Competencia " + e);
			throw new NovaHVDaoException(e);
		}

	}


}

