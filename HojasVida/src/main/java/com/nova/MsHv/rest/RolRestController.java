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

import com.nova.MsHv.entidad.Rol;
import com.nova.MsHv.impl.RolImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class RolRestController {
	static final Logger log = Logger.getLogger(RolRestController.class);
	@Autowired
	RolImpl impl;

	@RequestMapping("rol/findall")
	@ResponseBody
	public List<Rol> getType() throws NovaHVDaoException {
		List<Rol> type = new ArrayList<>();
		PropertyConfigurator.configure("log4j.properties");
		try {

			type = impl.consultarTodos();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type RolImpl" + e);
			throw new NovaHVDaoException(e);

		}

		return type;
	}


}
