package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.PurseDAO;
import com.nova.MsHv.dto.Purse;
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
 * @purse enlaRed.co
 * @version 1.0
 */
public class PurseRestController {
	static final Logger log = Logger.getLogger(PurseRestController.class);
	@Autowired
	PurseDAO purseDAO;

	/**
	 * Method for get one purse with your ID
	 * 
	 * @param idPurse
	 *            Id the purse
	 * @return Object the purse wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("purse/find/{id}")
	@ResponseBody

	public Purse getPurse(@PathVariable("id") long idPurse) throws NovaHVDaoException {
		Purse purse = new Purse();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in purse");
		try {

			purse = purseDAO.findByIdpurse(idPurse);
			if (!purse.equals(null)) {

				log.info("Log4j get the purse with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for purse " + e);
			throw new NovaHVDaoException(e);

		}

		return purse;
	}

	
	
	/**
	 * Method for get all purses in the BD
	 * 
	 * @return arrayList whit all purses
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("purse/findall")
	@ResponseBody
	public List<Purse> getPurseAll() throws NovaHVDaoException {
		List<Purse> purse = new ArrayList<Purse>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for purse");
		try {

			purse = purseDAO.findAll();
			if (purse.equals(null)) {

				log.info("Log4j get the list purses ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for purses" + e);
			throw new NovaHVDaoException(e);

		}

		return purse;
	}

	/**
	 * Method for Save one new purse
	 * 
	 * @param data
	 *            for the new purse
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "purse/save", method = RequestMethod.POST)
	@ResponseBody
	public void setPurse(@RequestBody Purse purse) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for purse");
		try {
			purseDAO.save(purse);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for purse " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one purse
	 * 
	 * @param idPurse
	 *            Id for purse
	 * @param purse
	 *            Data for update the purse
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "purse/edit/{id}")
	@ResponseBody

	public void editPurse(@PathVariable("id") long idPurse, @RequestBody Purse purse) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for purse");
		try {
			purseDAO.save(purse);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for purse " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one purse
	 * 
	 * @param idPurse
	 *            ID the purse
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "purse/delete/{id}")
	@ResponseBody
	public void getDeletePurse(@PathVariable("id") long idPurse) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for purse");
		try {
			purseDAO.delete(idPurse);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for purse " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
