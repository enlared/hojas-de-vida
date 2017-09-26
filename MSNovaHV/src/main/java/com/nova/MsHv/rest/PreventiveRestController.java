package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.PreventiveDAO;
import com.nova.MsHv.dto.Preventive;
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
 * @preventive enlaRed.co
 * @version 1.0
 */
public class PreventiveRestController {
	static final Logger log = Logger.getLogger(PreventiveRestController.class);
	@Autowired
	PreventiveDAO preventiveDAO;

	/**
	 * Method for get one preventive with your ID
	 * 
	 * @param idprv
	 *            Id the preventive
	 * @return Object the preventive wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("preventive/find/{id}")
	@ResponseBody

	public Preventive getPreventive(@PathVariable("id") long idprv) throws NovaHVDaoException {
		Preventive preventive = new Preventive();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in preventive");
		try {

			preventive = preventiveDAO.findByIdprv(idprv);
			if (!preventive.equals(null)) {

				log.info("Log4j get the preventive with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for preventive " + e);
			throw new NovaHVDaoException(e);

		}

		return preventive;
	}

	
	
	/**
	 * Method for get all preventives in the BD
	 * 
	 * @return arrayList whit all preventives
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("preventive/findall")
	@ResponseBody
	public List<Preventive> getPreventiveAll() throws NovaHVDaoException {
		List<Preventive> preventive = new ArrayList<Preventive>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for preventive");
		try {

			preventive = preventiveDAO.findAll();
			if (preventive.equals(null)) {

				log.info("Log4j get the list preventives ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for preventives" + e);
			throw new NovaHVDaoException(e);

		}

		return preventive;
	}

	/**
	 * Method for Save one new preventive
	 * 
	 * @param data
	 *            for the new preventive
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "preventive/save", method = RequestMethod.POST)
	@ResponseBody
	public void setPreventive(@RequestBody Preventive preventive) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for preventive");
		try {
			preventiveDAO.save(preventive);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for preventive " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one preventive
	 * 
	 * @param idprv
	 *            Id for preventive
	 * @param preventive
	 *            Data for update the preventive
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "preventive/edit/{id}")
	@ResponseBody

	public void editPreventive(@PathVariable("id") long idprv, @RequestBody Preventive preventive) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for preventive");
		try {
			preventiveDAO.save(preventive);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for preventive " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one preventive
	 * 
	 * @param idprv
	 *            ID the preventive
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "preventive/delete/{id}")
	@ResponseBody
	public void getDeletePreventive(@PathVariable("id") long idprv) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for preventive");
		try {
			preventiveDAO.delete(idprv);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for preventive " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
