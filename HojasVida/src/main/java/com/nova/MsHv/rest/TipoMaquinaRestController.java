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

import com.nova.MsHv.entidad.TipoMaquina;
import com.nova.MsHv.impl.TipoMaquinaImpl;
import com.nova.MsHvExcepciones.NovaHVDaoException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @typeMachine enlaRed.co
 * @version 1.0
 */
public class TipoMaquinaRestController {
	static final Logger log = Logger.getLogger(TipoMaquinaRestController.class);
	@Autowired
	TipoMaquinaImpl tipoMaquinaImpl;


/**
	 * Method for get all typeMachines in the BD
	 * 
	 * @return arrayList whit all typeMachines
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("typeMachine/findall")
	@ResponseBody
	public List<TipoMaquina> getTypeMachineAll() throws NovaHVDaoException {
		List<TipoMaquina> typeMachine = new ArrayList<TipoMaquina>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for typeMachine");
		try {

			typeMachine=tipoMaquinaImpl.consultarTodos();
			if (typeMachine.equals(null)) {

				log.info("Log4j get the list typeMachines ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for typeMachines" + e);
			throw new NovaHVDaoException(e);

		}

		return typeMachine;
	}

}
