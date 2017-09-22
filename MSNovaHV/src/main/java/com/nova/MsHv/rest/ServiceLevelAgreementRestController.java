package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.ServiceLevelAgreementDAO;
import com.nova.MsHv.dto.ServiceLevelAgreement;
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
public class ServiceLevelAgreementRestController {
	static final Logger log = Logger.getLogger(ServiceLevelAgreementRestController.class);
	@Autowired
	ServiceLevelAgreementDAO serviceLevelAgreementDAO;

	/**
	 * Method for get one sla with your ID
	 * 
	 * @param idrgn
	 *            Id the sla
	 * @return Object the sla wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("serviceLevelAgreement/find/{id}")
	@ResponseBody

	public ServiceLevelAgreement getServiceLevelAgreement(@PathVariable("id") long idsla) throws NovaHVDaoException {
		ServiceLevelAgreement serviceLevelAgreement = new ServiceLevelAgreement();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in sla");
		try {

			serviceLevelAgreement = serviceLevelAgreementDAO.findByIdsla(idsla);
			if (!serviceLevelAgreement.equals(null)) {

				log.info("Log4j get the sla with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for sla " + e);
			throw new NovaHVDaoException(e);

		}

		return serviceLevelAgreement;
	}

	
	
	/**
	 * Method for get all sla in the BD
	 * 
	 * @return arrayList whit all sla
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("serviceLevelAgreement/findall")
	@ResponseBody
	public List<ServiceLevelAgreement> getServiceLevelAgreementAll() throws NovaHVDaoException {
		List<ServiceLevelAgreement> serviceLevelAgreement = new ArrayList<ServiceLevelAgreement>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for sla");
		try {

			serviceLevelAgreement = serviceLevelAgreementDAO.findAll();
			if (serviceLevelAgreement.equals(null)) {

				log.info("Log4j get the list sla ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for sla" + e);
			throw new NovaHVDaoException(e);

		}

		return serviceLevelAgreement;
	}

	/**
	 * Method for Save one new sla
	 * 
	 * @param data
	 *            for the new sla
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "serviceLevelAgreement/save", method = RequestMethod.POST)
	@ResponseBody
	public void setServiceLevelAgreement(@RequestBody ServiceLevelAgreement serviceLevelAgreement) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for sla");
		try {
			serviceLevelAgreementDAO.save(serviceLevelAgreement);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for sla " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one sla
	 * 
	 * @param idsla
	 *            Id for sla
	 * @param sla
	 *            Data for update the sla
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "serviceLevelAgreement/edit/{id}")
	@ResponseBody

	public void editserviceLevelAgreement(@PathVariable("id") long idsla, @RequestBody ServiceLevelAgreement serviceLevelAgreement) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for sla");
		try {
			serviceLevelAgreementDAO.save(serviceLevelAgreement);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for sla " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one sla
	 * 
	 * @param idsla
	 *            ID the sla
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "serviceLevelAgreement/delete/{id}")
	@ResponseBody
	public void getDeleteServiceLevelAgreement(@PathVariable("id") long idsla) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for sla");
		try {
			serviceLevelAgreementDAO.delete(idsla);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for sla " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
