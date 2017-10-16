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

import com.nova.MsHv.entidad.Fumigacione;
import com.nova.MsHv.impl.FumigacionesImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller


public class FumigacionesRestController {
	static final Logger log = Logger.getLogger(FumigacionesRestController.class);
	@Autowired
	FumigacionesImpl impl;

	@RequestMapping("fumigaciones/findall")
	@ResponseBody
	public List<Fumigacione> getType() throws NovaHVDaoException {
		List<Fumigacione> type = new ArrayList<>();
		PropertyConfigurator.configure("log4j.properties");
		try {

			type = impl.consultarTodo();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type Fumigacione" + e);
			throw new NovaHVDaoException(e);
		}

		return type;
	}


}
