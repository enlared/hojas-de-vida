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

import com.nova.MsHv.entidad.PlazosCartera;
import com.nova.MsHv.impl.PlazosCarteraImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller


public class PlazosCarteraRestController {
	static final Logger log = Logger.getLogger(PlazosCarteraRestController.class);
	@Autowired
	PlazosCarteraImpl impl;

	@RequestMapping("plazosCartera/findall")
	@ResponseBody
	public List<PlazosCartera> getType() throws NovaHVDaoException {
		List<PlazosCartera> type = new ArrayList<>();
		PropertyConfigurator.configure("log4j.properties");
		try {

			type = impl.consultarTodo();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type PlazosCartera" + e);
			throw new NovaHVDaoException(e);
		}

		return type;
	}


}
