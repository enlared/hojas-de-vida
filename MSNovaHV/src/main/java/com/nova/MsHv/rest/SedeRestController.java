package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.SedeDAO;
import com.nova.MsHv.entidad.Sede;
import com.nova.MsHvExcepciones.NovaHVDaoException;
import com.nova.MsHvExcepciones.NovaHVRestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @regionals enlaRed.co
 * @version 1.0
 */
public class SedeRestController {
	static final Logger log = Logger.getLogger(SedeRestController.class);
	@Autowired
	SedeDAO sedeDAO;

	@RequestMapping("headQuarters/find/{id}")
	@ResponseBody

	public Sede getSede(@PathVariable("id") int id) throws NovaHVDaoException {
		Sede sede = new Sede();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in head quarters");
		try {

			sede = sedeDAO.findById(id);
			if (!sede.equals(null)) {

				log.info("Log4j get the head quarters with id ");
			}
		} catch (Exception e) {
			log.error("Log4j Error in Method Find for head quarters " + e);
			throw new NovaHVDaoException(e);

		}

		return sede;
	}

	
	


	@RequestMapping("sede/findall")
	@ResponseBody
	public List<Sede> getSedeAll() throws NovaHVDaoException {
		List<Sede> headQuarters = new ArrayList<Sede>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for head Sede");
		try {

			headQuarters = sedeDAO.findAll();
			if (headQuarters.equals(null)) {

				log.info("Log4j get the list Sede Sede ");
			}
		} catch (Exception e) {
			throw new NovaHVDaoException(e);

		}

		return headQuarters;
	}

	/**
	 * Method for Save one new head quarters
	 * 
	 * @param data
	 *            for the new head quarters
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "sede/save", method = RequestMethod.POST)
	@ResponseBody
	public void setHeadQuarters(@RequestBody Sede sede) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for head Sede");
		try {
			sedeDAO.save(sede);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for head Sede " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one head quarters
	 * 
	 * @param idhqrt
	 *            Id for headquarters
	 * @param head quarters
	 *            Data for update headquarters
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "sede/edit/{id}")
	@ResponseBody

	public void editSede(@PathVariable("id") long idhqrt, @RequestBody Sede headQuarters) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		try {
			sedeDAO.save(headQuarters);

		} catch (Exception e) {
			log.error("Log4j Error in method Update for Sede " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one headquartes
	 * 
	 * @param idhqrt
	 *            ID the headquartes
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "sede/delete/{id}")
	@ResponseBody
	public void getDeleteSede(@PathVariable("id") long id) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for head quartes");
		try {
			sedeDAO.delete(id);
		} catch (Exception e) {
			throw new NovaHVDaoException(e);
		}

	}


}
