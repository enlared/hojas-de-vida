package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.RegionalesDAO;
import com.nova.MsHv.entidad.Regional;
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
public class RegionalesRestController {
	static final Logger log = Logger.getLogger(RegionalesRestController.class);
	@Autowired
	RegionalesDAO regionalesDAO;

	@RequestMapping("regionales/findAll")
	@ResponseBody
	public List<Regional> getRegionalsAll() throws NovaHVDaoException {
		List<Regional> regional = new ArrayList<Regional>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for regionals");
		try {

			regional = regionalesDAO.findAll();
			if (regional.equals(null)) {

				log.info("Log4j get the list regionalss ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for regionalss" + e);
			throw new NovaHVDaoException(e);

		}

		return regional;
	}

	/**
	 * Method for Save one new regionals
	 * 
	 * @param data
	 *            for the new regionals
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "regionals/save", method = RequestMethod.POST)
	@ResponseBody
	public void setRegionals(@RequestBody Regional regionals) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for regionals");
		try {
			regionalesDAO.save(regionals);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for regionals " + e);
			throw new NovaHVRestException(e);

		}

	}

	@RequestMapping(method = RequestMethod.PUT, path = "regionals/edit/{id}")
	@ResponseBody

	public void editRegionals(@PathVariable("id") long id, @RequestBody Regional regionals) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for regionals");
		try {
			regionalesDAO.save(regionals);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for regionals " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one regionals
	 * 
	 * @param idrgn
	 *            ID the regionals
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "regionals/delete/{id}")
	@ResponseBody
	public void getDeleteRegionals(@PathVariable("id") long idrgn) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for regionals");
		try {
			regionalesDAO.delete(idrgn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for regionals " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
