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

import com.nova.MsHv.entidad.Preventivo;
import com.nova.MsHv.impl.PreventivoImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller


public class PreventivoRestController {
	static final Logger log = Logger.getLogger(PreventivoRestController.class);
	@Autowired
	PreventivoImpl impl;

	@RequestMapping("preventivo/findall")
	@ResponseBody
	public List<Preventivo> getType() throws NovaHVDaoException {
		List<Preventivo> type = new ArrayList<>();
		PropertyConfigurator.configure("log4j.properties");
		try {

			type = impl.consultarTodo();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type Preventivo" + e);
			throw new NovaHVDaoException(e);
		}

		return type;
	}


}
