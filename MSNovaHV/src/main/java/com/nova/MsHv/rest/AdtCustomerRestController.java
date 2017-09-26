package com.nova.MsHv.rest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.AdtCustomerDAO;
import com.nova.MsHv.dto.AdtCustomer;
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
 * @author enlaRed.co
 * @version 1.0
 */
public class AdtCustomerRestController {
	static final Logger log = Logger.getLogger(AdtCustomerRestController.class);
	@Autowired
	AdtCustomerDAO adtCustomerDAO;

	@RequestMapping("adtCustomer/find/{id}")
	@ResponseBody

	public AdtCustomer getAuthor(@PathVariable("id") long idadtcst) throws NovaHVDaoException {
		AdtCustomer adtCustomer = new AdtCustomer();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in adtCustomer");
		try {

			adtCustomer = adtCustomerDAO.findByIdadtcst(idadtcst);
			if (!adtCustomer.equals(null)) {

				log.info("Log4j get the adtCustomer with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for adtCustomer " + e);
			throw new NovaHVDaoException(e);

		}

		return adtCustomer;
	}

	
	
	/**
	 * Method for get all authors in the BD
	 * 
	 * @return arrayList whit all authors
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("adtCustomer/findall")
	@ResponseBody
	public List<AdtCustomer> getAuthorAll() throws NovaHVDaoException {
		List<AdtCustomer> adtCustomer = new ArrayList<AdtCustomer>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for adtCustomer");
		try {

			adtCustomer = adtCustomerDAO.findAll();
			if (adtCustomer.equals(null)) {

				log.info("Log4j get the list adtCustomer ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for adtCustomer" + e);
			throw new NovaHVDaoException(e);

		}

		return adtCustomer;
	}


	@RequestMapping(value = "adtCustomer/save", method = RequestMethod.POST)
	@ResponseBody
	public void setAdtCustomer(@RequestBody AdtCustomer adtCustomer) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for adtCustomer");
		try {
			adtCustomerDAO.save(adtCustomer);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for adtCustomer " + e);
			throw new NovaHVRestException(e);

		}

	}


	@RequestMapping(method = RequestMethod.PUT, path = "adtCustomer/edit/{id}")
	@ResponseBody

	public void editAuthor(@PathVariable("id") long idadtcst, @RequestBody AdtCustomer adtCustomer) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for adtCustomer");
		try {
			adtCustomerDAO.save(adtCustomer);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for adtCustomer " + e);
			throw new NovaHVRestException(e);
		}

	}



	@RequestMapping(method = RequestMethod.DELETE, path = "author/delete/{id}")
	@ResponseBody
	public void getDeleteAdtCustomer(@PathVariable("id") long idadtcst) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for adtCustomer");
		try {
			adtCustomerDAO.delete(idadtcst);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for adtCustomer " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
