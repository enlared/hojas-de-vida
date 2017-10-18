package com.nova.MsHv.rest;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dto.RolUsuarioResponse;
import com.nova.MsHv.entidad.RolUsuario;
import com.nova.MsHv.impl.RolUsuarioImpl;
import com.nova.MsHv.impl.UsuarioImpl;
import com.nova.MsHvExcepciones.NovaHVRestException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @contactHseq enlaRed.co
 * @version 1.0
 */
public class RolUsuarioRestController {
	static final Logger log = Logger.getLogger(RolUsuarioRestController.class);
	@Autowired
	RolUsuarioImpl impl;
	UsuarioImpl impluser;



	@RequestMapping(value = "rolUsuario/save", method = RequestMethod.POST)
	@ResponseBody
	public RolUsuario guarda (@RequestBody RolUsuario c) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for rolUsuario");
		try {
			c.setFechaRegistro(new Date());
			c.getUsuario().setFechaRegistro(new Date());
			
			RolUsuario datas = impl.save(c);
			 return datas;
		} catch (Exception e) {
			log.error("Log4j Error in method Save for rolUsuario " + e);
			throw new NovaHVRestException(e);

		}

	}

	@RequestMapping(value = "rolUsuario/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean remove(@RequestBody RolUsuario data) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method remove for contactHseq");
		try {
			impl.remove(data);
			return true;
		} catch (Exception e) {
			log.error("Log4j Error in method remove for contactHseq " + e);
			throw new NovaHVRestException(e);

		}

	}
	
	@RequestMapping(value = "rolUsuario/consulta", method = RequestMethod.POST)
	@ResponseBody
	public RolUsuarioResponse consultaUser(@RequestBody RolUsuario data) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method remove for RolUsuarioResponse");
		try {
			return impl.consultaUser(data);
		} catch (Exception e) {
			log.error("Log4j Error in method remove for RolUsuarioResponse " + e);
			throw new NovaHVRestException(e);

		}

	}

}
