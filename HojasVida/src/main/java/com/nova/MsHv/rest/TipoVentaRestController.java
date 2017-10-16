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

import com.nova.MsHv.entidad.TipoVenta;
import com.nova.MsHv.impl.TipoVentaImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class TipoVentaRestController {
	static final Logger log = Logger.getLogger(TipoVentaRestController.class);
	@Autowired
	TipoVentaImpl impl;

	@RequestMapping("tipoVenta/findall")
	@ResponseBody
	public List<TipoVenta> getType() throws NovaHVDaoException {
		List<TipoVenta> type = new ArrayList<>();
		PropertyConfigurator.configure("log4j.properties");
		try {

			type = impl.consultarTodos();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for type Correctivo" + e);
			throw new NovaHVDaoException(e);
		}

		return type;
	}


}
