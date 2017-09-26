package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.InfBsnxTpMacDAO;
import com.nova.MsHv.dto.InfBsnxTpMac;
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
 * @infBsnxTpMac enlaRed.co
 * @version 1.0
 */
public class InfBsnxTpMacRestController {
	static final Logger log = Logger.getLogger(InfBsnxTpMacRestController.class);
	@Autowired
	InfBsnxTpMacDAO infBsnxTpMacDAO;

	/**
	 * Method for get one infBsnxTpMac with your ID
	 * 
	 * @param idinfbsnxtpmac
	 *            Id the infBsnxTpMac
	 * @return Object the infBsnxTpMac wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("infBsnxTpMac/find/{id}")
	@ResponseBody

	public InfBsnxTpMac getInfBsnxTpMac(@PathVariable("id") long idinfbsnxtpmac) throws NovaHVDaoException {
		InfBsnxTpMac infBsnxTpMac = new InfBsnxTpMac();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in infBsnxTpMac");
		try {

			infBsnxTpMac = infBsnxTpMacDAO.findByIdinfbsnxtpmac(idinfbsnxtpmac);
			if (!infBsnxTpMac.equals(null)) {

				log.info("Log4j get the infBsnxTpMac with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for infBsnxTpMac " + e);
			throw new NovaHVDaoException(e);

		}

		return infBsnxTpMac;
	}

	
	
	/**
	 * Method for get all infBsnxTpMacs in the BD
	 * 
	 * @return arrayList whit all infBsnxTpMacs
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("infBsnxTpMac/findall")
	@ResponseBody
	public List<InfBsnxTpMac> getInfBsnxTpMacAll() throws NovaHVDaoException {
		List<InfBsnxTpMac> infBsnxTpMac = new ArrayList<InfBsnxTpMac>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for infBsnxTpMac");
		try {

			infBsnxTpMac = infBsnxTpMacDAO.findAll();
			if (infBsnxTpMac.equals(null)) {

				log.info("Log4j get the list infBsnxTpMacs ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for infBsnxTpMacs" + e);
			throw new NovaHVDaoException(e);

		}

		return infBsnxTpMac;
	}

	/**
	 * Method for Save one new infBsnxTpMac
	 * 
	 * @param data
	 *            for the new infBsnxTpMac
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "infBsnxTpMac/save", method = RequestMethod.POST)
	@ResponseBody
	public void setInfBsnxTpMac(@RequestBody InfBsnxTpMac infBsnxTpMac) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for infBsnxTpMac");
		try {
			infBsnxTpMacDAO.save(infBsnxTpMac);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for infBsnxTpMac " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one infBsnxTpMac
	 * 
	 * @param idinfbsnxtpmac
	 *            Id for infBsnxTpMac
	 * @param infBsnxTpMac
	 *            Data for update the infBsnxTpMac
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "infBsnxTpMac/edit/{id}")
	@ResponseBody

	public void editInfBsnxTpMac(@PathVariable("id") long idinfbsnxtpmac, @RequestBody InfBsnxTpMac infBsnxTpMac) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for infBsnxTpMac");
		try {
			infBsnxTpMacDAO.save(infBsnxTpMac);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for infBsnxTpMac " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one infBsnxTpMac
	 * 
	 * @param idinfbsnxtpmac
	 *            ID the infBsnxTpMac
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "infBsnxTpMac/delete/{id}")
	@ResponseBody
	public void getDeleteInfBsnxTpMac(@PathVariable("id") long idinfbsnxtpmac) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for infBsnxTpMac");
		try {
			infBsnxTpMacDAO.delete(idinfbsnxtpmac);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for infBsnxTpMac " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
