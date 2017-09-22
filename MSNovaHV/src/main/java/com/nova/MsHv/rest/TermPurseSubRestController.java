package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.TermPurseSubDAO;
import com.nova.MsHv.dto.TermPurseSub;
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
 * @termPurseSub enlaRed.co
 * @version 1.0
 */
public class TermPurseSubRestController {
	static final Logger log = Logger.getLogger(TermPurseSubRestController.class);
	@Autowired
	TermPurseSubDAO termPurseSubDAO;

	/**
	 * Method for get one termPurseSub with your ID
	 * 
	 * @param idtrmprs
	 *            Id the termPurseSub
	 * @return Object the termPurseSub wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("termPurseSub/find/{id}")
	@ResponseBody

	public TermPurseSub getTermPurseSub(@PathVariable("id") long idtrmprs) throws NovaHVDaoException {
		TermPurseSub termPurseSub = new TermPurseSub();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in termPurseSub");
		try {

			termPurseSub = termPurseSubDAO.findByIdtrmprs(idtrmprs);
			if (!termPurseSub.equals(null)) {

				log.info("Log4j get the termPurseSub with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for termPurseSub " + e);
			throw new NovaHVDaoException(e);

		}

		return termPurseSub;
	}

	
	
	/**
	 * Method for get all termPurseSubs in the BD
	 * 
	 * @return arrayList whit all termPurseSubs
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("termPurseSub/findall")
	@ResponseBody
	public List<TermPurseSub> getTermPurseSubAll() throws NovaHVDaoException {
		List<TermPurseSub> termPurseSub = new ArrayList<TermPurseSub>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for termPurseSub");
		try {

			termPurseSub = termPurseSubDAO.findAll();
			if (termPurseSub.equals(null)) {

				log.info("Log4j get the list termPurseSubs ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for termPurseSubs" + e);
			throw new NovaHVDaoException(e);

		}

		return termPurseSub;
	}

	/**
	 * Method for Save one new termPurseSub
	 * 
	 * @param data
	 *            for the new termPurseSub
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "termPurseSub/save", method = RequestMethod.POST)
	@ResponseBody
	public void setTermPurseSub(@RequestBody TermPurseSub termPurseSub) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for termPurseSub");
		try {
			termPurseSubDAO.save(termPurseSub);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for termPurseSub " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one termPurseSub
	 * 
	 * @param idtrmprs
	 *            Id for termPurseSub
	 * @param termPurseSub
	 *            Data for update the termPurseSub
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "termPurseSub/edit/{id}")
	@ResponseBody

	public void editTermPurseSub(@PathVariable("id") long idtrmprs, @RequestBody TermPurseSub termPurseSub) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for termPurseSub");
		try {
			termPurseSubDAO.save(termPurseSub);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for termPurseSub " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one termPurseSub
	 * 
	 * @param idtrmprs
	 *            ID the termPurseSub
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "termPurseSub/delete/{id}")
	@ResponseBody
	public void getDeleteTermPurseSub(@PathVariable("id") long idtrmprs) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for termPurseSub");
		try {
			termPurseSubDAO.delete(idtrmprs);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for termPurseSub " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
