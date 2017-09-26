package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.TermPurseRentDAO;
import com.nova.MsHv.dto.TermPurseRent;
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
 * @termPurseRent enlaRed.co
 * @version 1.0
 */
public class TermPurseRentRestController {
	static final Logger log = Logger.getLogger(TermPurseRentRestController.class);
	@Autowired
	TermPurseRentDAO termPurseRentDAO;

	/**
	 * Method for get one termPurseRent with your ID
	 * 
	 * @param idtrmprsrnt
	 *            Id the termPurseRent
	 * @return Object the termPurseRent wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("termPurseRent/find/{id}")
	@ResponseBody

	public TermPurseRent getTermPurseRent(@PathVariable("id") long idtrmprsrnt) throws NovaHVDaoException {
		TermPurseRent termPurseRent = new TermPurseRent();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in termPurseRent");
		try {

			termPurseRent = termPurseRentDAO.findByIdtrmprsrnt(idtrmprsrnt);
			if (!termPurseRent.equals(null)) {

				log.info("Log4j get the termPurseRent with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for termPurseRent " + e);
			throw new NovaHVDaoException(e);

		}

		return termPurseRent;
	}

	
	
	/**
	 * Method for get all termPurseRents in the BD
	 * 
	 * @return arrayList whit all termPurseRents
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("termPurseRent/findall")
	@ResponseBody
	public List<TermPurseRent> getTermPurseRentAll() throws NovaHVDaoException {
		List<TermPurseRent> termPurseRent = new ArrayList<TermPurseRent>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for termPurseRent");
		try {

			termPurseRent = termPurseRentDAO.findAll();
			if (termPurseRent.equals(null)) {

				log.info("Log4j get the list termPurseRents ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for termPurseRents" + e);
			throw new NovaHVDaoException(e);

		}

		return termPurseRent;
	}

	/**
	 * Method for Save one new termPurseRent
	 * 
	 * @param data
	 *            for the new termPurseRent
	 * @throws NovaHvRestException
	 */

	@RequestMapping(value = "termPurseRent/save", method = RequestMethod.POST)
	@ResponseBody
	public void setTermPurseRent(@RequestBody TermPurseRent termPurseRent) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for termPurseRent");
		try {
			termPurseRentDAO.save(termPurseRent);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for termPurseRent " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one termPurseRent
	 * 
	 * @param idtrmprsrnt
	 *            Id for termPurseRent
	 * @param termPurseRent
	 *            Data for update the termPurseRent
	 * @throws NovaHvRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "termPurseRent/edit/{id}")
	@ResponseBody

	public void editTermPurseRent(@PathVariable("id") long idtrmprsrnt, @RequestBody TermPurseRent termPurseRent) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for termPurseRent");
		try {
			termPurseRentDAO.save(termPurseRent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for termPurseRent " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one termPurseRent
	 * 
	 * @param idtrmprsrnt
	 *            ID the termPurseRent
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "termPurseRent/delete/{id}")
	@ResponseBody
	public void getDeleteTermPurseRent(@PathVariable("id") long idtrmprsrnt) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for termPurseRent");
		try {
			termPurseRentDAO.delete(idtrmprsrnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for termPurseRent " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
