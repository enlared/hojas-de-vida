package com.nova.MsHv.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.TipoEmpleadoDAO;
import com.nova.MsHv.entidad.TipoEmpleado;
import com.nova.MsHvExcepciones.NovaHVDaoException;
import com.nova.MsHvExcepciones.NovaHVRestException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @typeEmployees enlaRed.co
 * @version 1.0
 */
public class TipoEmpleadoRestController {
	static final Logger log = Logger.getLogger(TipoEmpleadoRestController.class);
	@Autowired
	TipoEmpleadoDAO tipoEmpleadoDao;



	@RequestMapping("typeEmployees/find/{id}")
	@ResponseBody

	public TipoEmpleado getTypeEmployees(@PathVariable("id") int id) throws NovaHVDaoException {
		TipoEmpleado typeEmployees = new TipoEmpleado();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in TipoEmpleado");
		try {

			typeEmployees = tipoEmpleadoDao.findById(id);
			if (!typeEmployees.equals(null)) {

				log.info("Log4j get the TipoEmpleado with id ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in Method Find for TipoEmpleado " + e);
			throw new NovaHVDaoException(e);

		}

		return typeEmployees;
	}

	

	@RequestMapping("tipoEmpleado/findall")
	@ResponseBody
	public List<TipoEmpleado> getTypeEmployeesAll() throws NovaHVDaoException {
		List<TipoEmpleado> typeEmployees = new ArrayList<>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for typeEmployees");
		try {

			typeEmployees = tipoEmpleadoDao.findAll();
			if (typeEmployees.equals(null)) {

				log.info("Log4j get the list typeEmployeess ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for typeEmployeess" + e);
			throw new NovaHVDaoException(e);

		}

		return typeEmployees;
	}

	/**
	 * Method for Save one new typeEmployees
	 * 
	 * @param data
	 *            for the new typeEmployees
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "typeEmployees/save", method = RequestMethod.POST)
	@ResponseBody
	public void setTypeEmployees(@RequestBody TipoEmpleado typeEmployees) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for typeEmployees");
		try {
			tipoEmpleadoDao.save(typeEmployees);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for TipoEmpleado " + e);
			throw new NovaHVRestException(e);

		}

	}


	@RequestMapping(method = RequestMethod.PUT, path = "typeEmployees/edit/{id}")
	@ResponseBody

	public void editTypeEmployees(@PathVariable("id") long idtpemp, @RequestBody TipoEmpleado tipoEmpleado) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for typeEmployees");
		try {
			tipoEmpleadoDao.save(tipoEmpleado);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for typeEmployees " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one typeEmployees
	 * 
	 * @param idtpemp
	 *            ID the typeEmployees
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "typeEmployees/delete/{id}")
	@ResponseBody
	public void getDeleteTypeEmployees(@PathVariable("id") long id) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for tipoEmpleado");
		try {
			tipoEmpleadoDao.delete(id);
		} catch (Exception e) {
			log.error("Log4j Error in method Delete for typeEmployees " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
