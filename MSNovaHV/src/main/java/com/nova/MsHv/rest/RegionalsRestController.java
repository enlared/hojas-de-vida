package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.RegionalsDAO;
import com.nova.MsHv.dto.Regionals;
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
public class RegionalsRestController {
	static final Logger log = Logger.getLogger(RegionalsRestController.class);
	@Autowired
	RegionalsDAO regionalsDAO;

	/**
	 * Method for get one regionals with your ID
	 * 
	 * @param idrgn
	 *            Id the regionals
	 * @return Object the regionals wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("regionals/find/{id}")
	@ResponseBody

	public Regionals getRegionals(@PathVariable("id") long idrgn) throws NovaHVDaoException {
		Regionals regionals = new Regionals();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in regionals");
		try {

			regionals = regionalsDAO.findByIdrgn(idrgn);
			if (!regionals.equals(null)) {

				log.info("Log4j get the regionals with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for regionals " + e);
			throw new NovaHVDaoException(e);

		}

		return regionals;
	}

	
	
	/**
	 * Method for get all regionalss in the BD
	 * 
	 * @return arrayList whit all regionalss
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("regionals/findall")
	@ResponseBody
	public List<Regionals> getRegionalsAll() throws NovaHVDaoException {
		List<Regionals> regionals = new ArrayList<Regionals>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for regionals");
		try {

			regionals = regionalsDAO.findAll();
			if (regionals.equals(null)) {

				log.info("Log4j get the list regionalss ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for regionalss" + e);
			throw new NovaHVDaoException(e);

		}

		return regionals;
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
	public void setRegionals(@RequestBody Regionals regionals) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for regionals");
		try {
			regionalsDAO.save(regionals);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for regionals " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one regionals
	 * 
	 * @param idrgn
	 *            Id for regionals
	 * @param regionals
	 *            Data for update the regionals
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "regionals/edit/{id}")
	@ResponseBody

	public void editRegionals(@PathVariable("id") long idrgn, @RequestBody Regionals regionals) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for regionals");
		try {
			regionalsDAO.save(regionals);

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
			regionalsDAO.delete(idrgn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for regionals " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
