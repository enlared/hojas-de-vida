package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.BillingDAO;
import com.nova.MsHv.dto.Billing;
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
public class BillingRestController {
	static final Logger log = Logger.getLogger(BillingRestController.class);
	@Autowired
	BillingDAO billingDAO;


	@RequestMapping("billing/find/{id}")
	@ResponseBody

	public Billing getAuthor(@PathVariable("id") long idbilling) throws NovaHVDaoException {
		Billing billing = new Billing();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in billing");
		try {

			billing = billingDAO.findByIdbilling(idbilling);
			if (!billing.equals(null)) {

				log.info("Log4j get the billing with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for billing " + e);
			throw new NovaHVDaoException(e);

		}

		return billing;
	}


	@RequestMapping("billing/findall")
	@ResponseBody
	public List<Billing> getBillingAll() throws NovaHVDaoException {
		List<Billing> billing = new ArrayList<Billing>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for billing");
		try {

			billing = billingDAO.findAll();
			if (billing.equals(null)) {

				log.info("Log4j get the list billing ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for billing" + e);
			throw new NovaHVDaoException(e);

		}

		return billing;
	}

	@RequestMapping(value = "billing/save", method = RequestMethod.POST)
	@ResponseBody
	public void setBilling(@RequestBody Billing billing) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for billing");
		try {
			billingDAO.save(billing);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for billing " + e);
			throw new NovaHVRestException(e);

		}

	}

	@RequestMapping(method = RequestMethod.PUT, path = "billing/edit/{id}")
	@ResponseBody

	public void editBilling(@PathVariable("id") long idbilling, @RequestBody Billing billing) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for billing");
		try {
			billingDAO.save(billing);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for billing " + e);
			throw new NovaHVRestException(e);
		}

	}



	@RequestMapping(method = RequestMethod.DELETE, path = "billing/delete/{id}")
	@ResponseBody
	public void getDeleteAuthor(@PathVariable("id") long idbilling) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for billing");
		try {
			billingDAO.delete(idbilling);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for billing " + e);
			throw new NovaHVDaoException(e);
		}

	}


}

