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

import com.nova.MsHv.entidad.Anclaje;
import com.nova.MsHv.impl.AnclajeImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @author enlaRed.co
 * @version 1.0
 */
public class AnclajeRestController {
	static final Logger log = Logger.getLogger(AnclajeRestController.class);
	@Autowired
	AnclajeImpl anchorageDAO;


	@RequestMapping("anchorage/findall")
	@ResponseBody
	public List<Anclaje> getAnchorageAll() throws NovaHVDaoException {
		List<Anclaje> anchorage = new ArrayList<Anclaje>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for anchorage");
		try {
			
			anchorage = anchorageDAO.consultarTodos();
			if (anchorage.equals(null)) {

				log.info("Log4j get the list anchorage ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for anchorage" + e);
			throw new NovaHVDaoException(e);

		}

		return anchorage;
	}

}
