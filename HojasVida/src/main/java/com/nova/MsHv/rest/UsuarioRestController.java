package com.nova.MsHv.rest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dto.Respuesta;
import com.nova.MsHv.dto.UsuarioResponse;
import com.nova.MsHv.entidad.Usuario;
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
public class UsuarioRestController {
	static final Logger log = Logger.getLogger(UsuarioRestController.class);
	@Autowired
	UsuarioImpl impl;



	@RequestMapping(value = "usuario/save", method = RequestMethod.POST)
	@ResponseBody
	public Usuario guardarUser (@RequestBody Usuario contactHseq) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for contactHseq");
		try {
			return impl.save(contactHseq);
		} catch (Exception e) {
			log.error("Log4j Error in method Save for contactHseq " + e);
			throw new NovaHVRestException(e);

		}

	}
	
	@RequestMapping(value = "usuario/consulta", method = RequestMethod.POST)
	@ResponseBody
	public UsuarioResponse consultar (@RequestBody Usuario contactHseq) throws NovaHVRestException {
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		Respuesta respuesta= new Respuesta();
		usuarioResponse.setRespuesta(respuesta);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for consultaXUsuario");
		try {

			respuesta.setEstado("OK");
			usuarioResponse.setUsuario(impl.consultaXUsuario(contactHseq));
			return usuarioResponse;
		} catch (Exception e) {
			respuesta.setEstado("0");

			log.error("Log4j Error in method Save for consultaXUsuario " + e);
			throw new NovaHVRestException(e);

		}

	}

	@RequestMapping(value = "usuario/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean remove(@RequestBody Usuario data) throws NovaHVRestException {

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

}
