package com.nova.MsHv.rest;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.entidad.InfluenciaCompra;
import com.nova.MsHv.impl.GradoInfluenciaImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @author enlaRed.co
 * @version 1.0
 */
public class GradoInfluenciaController {
	static final Logger log = Logger.getLogger(GradoInfluenciaController.class);
	@Autowired 	GradoInfluenciaImpl modoImpl;

	@RequestMapping("influenciaCompra/findAll")
	@ResponseBody

	public List<InfluenciaCompra> getConsulta() throws NovaHVDaoException {

		return modoImpl.consultarAll();
	}

	
	
}
