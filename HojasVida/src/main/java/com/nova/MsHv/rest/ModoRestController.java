package com.nova.MsHv.rest;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.entidad.Modo;
import com.nova.MsHv.impl.ModoImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @author enlaRed.co
 * @version 1.0
 */
public class ModoRestController {
	static final Logger log = Logger.getLogger(ModoRestController.class);
	@Autowired 	ModoImpl modoImpl;

	@RequestMapping("modo/findAll")
	@ResponseBody

	public List<Modo> getConsulta() throws NovaHVDaoException {

		return modoImpl.consultarAll();
	}

	
	
}
