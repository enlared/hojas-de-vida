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

import com.nova.MsHv.entidad.RequiereCompra;
import com.nova.MsHv.impl.RequiereCompraImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller


public class RequiereCompraRestController {
	static final Logger log = Logger.getLogger(RequiereCompraRestController.class);
	@Autowired
	RequiereCompraImpl  impl;

	@RequestMapping("requiereCompra/findall")
	@ResponseBody
	public List<RequiereCompra> getType() throws NovaHVDaoException {
		List<RequiereCompra> type = new ArrayList<>();
		PropertyConfigurator.configure("log4j.properties");
		try {

			type = impl.consultarTodo();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type RequiereCompra" + e);
			throw new NovaHVDaoException(e);
		}

		return type;
	}


}
