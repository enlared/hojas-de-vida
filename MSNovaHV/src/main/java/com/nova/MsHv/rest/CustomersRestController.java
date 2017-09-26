package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.CustomersDAO;
import com.nova.MsHv.dto.Customers;
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
 * @customers enlaRed.co
 * @version 1.0
 */
public class CustomersRestController {
	static final Logger log = Logger.getLogger(CustomersRestController.class);
	@Autowired
	CustomersDAO customersDAO;

	/**
	 * Method for get one customers with your ID
	 * 
	 * @param idadtcst
	 *            Id the customers
	 * @return Object the customers wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("customers/find/{id}")
	@ResponseBody

	public Customers getCustomers(@PathVariable("id") long codsap) throws NovaHVDaoException {
		Customers customers = new Customers();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in customers");
		try {

			customers = customersDAO.findByCodsap(codsap);
			if (!customers.equals(null)) {

				log.info("Log4j get the customers with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for customers " + e);
			throw new NovaHVDaoException(e);

		}

		return customers;
	}

	
	
	/**
	 * Method for get all customerss in the BD
	 * 
	 * @return arrayList whit all customerss
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("customers/findall")
	@ResponseBody
	public List<Customers> getCustomersAll() throws NovaHVDaoException {
		List<Customers> customers = new ArrayList<Customers>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for customers");
		try {

			customers = customersDAO.findAll();
			if (customers.equals(null)) {

				log.info("Log4j get the list customerss ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for customerss" + e);
			throw new NovaHVDaoException(e);

		}

		return customers;
	}

	/**
	 * Method for Save one new customers
	 * 
	 * @param data
	 *            for the new customers
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "customers/save", method = RequestMethod.POST)
	@ResponseBody
	public void setCustomers(@RequestBody Customers customers) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for customers");
		try {
			customersDAO.save(customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for customers " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one customers
	 * 
	 * @param idadtcst
	 *            Id for customers
	 * @param customers
	 *            Data for update the customers
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "customers/edit/{id}")
	@ResponseBody

	public void editCustomers(@PathVariable("id") long idadtcst, @RequestBody Customers customers) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for customers");
		try {
			customersDAO.save(customers);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for customers " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one customers
	 * 
	 * @param idadtcst
	 *            ID the customers
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "customers/delete/{id}")
	@ResponseBody
	public void getDeleteCustomers(@PathVariable("id") long codsap) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for customers");
		try {
			customersDAO.delete(codsap);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for customers " + e);
			throw new NovaHVDaoException(e);
		}

	}


}

