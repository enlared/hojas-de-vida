package com.udea.entidad_generica.servicios;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.udea.entidad_generica.modelo.Generico;
import com.udea.entidad_generica.dao.GenericoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GenericoRestController {
	
	private final static Logger logger = LoggerFactory.getLogger(GenericoRestController.class);
	
	@Autowired
	GenericoDAO GenericoDAO;
	/**
	@RequestMapping("/find")
	@ResponseBody
	public Generico getGenerico( String code) {
		//logger.info("Ingresó al metodo find con code " + code);
		Generico generico = new Generico();
		generico = GenericoDAO.findByCode(code);
		return generico;
	
	}
	
	@RequestMapping (method = RequestMethod.POST, value ="/save")
	@ResponseBody
	public String setGenerico( @RequestBody Generico generico) {
		GenericoDAO.save(generico);
		//logger.info("entidad generica guardada");
		return "Done!";
	
	}
	**/
}
