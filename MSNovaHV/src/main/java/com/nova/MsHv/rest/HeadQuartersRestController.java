package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.HeadQuartersDAO;
import com.nova.MsHv.dto.HeadQuarters;
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
public class HeadQuartersRestController {
	static final Logger log = Logger.getLogger(HeadQuartersRestController.class);
	@Autowired
	HeadQuartersDAO headQuartersDAO;

	/**
	 * Method for get one head quarters with your ID
	 * 
	 * @param idrgn
	 *            Id the head quarters
	 * @return Object the head quarters wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("headQuarters/find/{id}")
	@ResponseBody

	public HeadQuarters getHeadQuarters(@PathVariable("id") long idhqrt) throws NovaHVDaoException {
		HeadQuarters headQuarters = new HeadQuarters();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in head quarters");
		try {

			headQuarters = headQuartersDAO.findByIdhqrt(idhqrt);
			if (!headQuarters.equals(null)) {

				log.info("Log4j get the head quarters with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for head quarters " + e);
			throw new NovaHVDaoException(e);

		}

		return headQuarters;
	}

	
	
	/**
	 * Method for get all headquarters in the BD
	 * 
	 * @return arrayList whit all headquarters
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("headQuarters/findall")
	@ResponseBody
	public List<HeadQuarters> getHeadQuartersAll() throws NovaHVDaoException {
		List<HeadQuarters> headQuarters = new ArrayList<HeadQuarters>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for head quarters");
		try {

			headQuarters = headQuartersDAO.findAll();
			if (headQuarters.equals(null)) {

				log.info("Log4j get the list head quarters ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for head quarters" + e);
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

	@RequestMapping(value = "headQuarters/save", method = RequestMethod.POST)
	@ResponseBody
	public void setHeadQuarters(@RequestBody HeadQuarters headQuarters) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for head quarters");
		try {
			headQuartersDAO.save(headQuarters);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for head quarters " + e);
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

	@RequestMapping(method = RequestMethod.PUT, path = "headQuarters/edit/{id}")
	@ResponseBody

	public void editHeadQuarters(@PathVariable("id") long idhqrt, @RequestBody HeadQuarters headQuarters) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for headQuarters");
		try {
			headQuartersDAO.save(headQuarters);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for headqueartes " + e);
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

	@RequestMapping(method = RequestMethod.DELETE, path = "headQuarters/delete/{id}")
	@ResponseBody
	public void getDeleteHeadQuarters(@PathVariable("id") long idhqrt) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for head quartes");
		try {
			headQuartersDAO.delete(idhqrt);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for headquarters " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
