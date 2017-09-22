package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.ContactHseqDAO;
import com.nova.MsHv.dto.ContactHseq;
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
 * @contactHseq enlaRed.co
 * @version 1.0
 */
public class ContactHseqRestController {
	static final Logger log = Logger.getLogger(ContactHseqRestController.class);
	@Autowired
	ContactHseqDAO contactHseqDAO;



	@RequestMapping("contactHseq/find/{id}")
	@ResponseBody

	public ContactHseq getContactHseq(@PathVariable("id") long idcnthseq) throws NovaHVDaoException {
		ContactHseq contactHseq = new ContactHseq();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in ContactHseq");
		try {

			contactHseq = contactHseqDAO.findByIdcnthseq(idcnthseq);
			if (!contactHseq.equals(null)) {

				log.info("Log4j get the ContactHseq with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for contactHseq " + e);
			throw new NovaHVDaoException(e);

		}

		return contactHseq;
	}

	
	
	/**
	 * Method for get all contactHseqs in the BD
	 * 
	 * @return arrayList whit all contactHseqs
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("contactHseq/findall")
	@ResponseBody
	public List<ContactHseq> getContactHseqAll() throws NovaHVDaoException {
		List<ContactHseq> contactHseq = new ArrayList<ContactHseq>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for contactHseq");
		try {

			contactHseq = contactHseqDAO.findAll();
			if (contactHseq.equals(null)) {

				log.info("Log4j get the list contactHseqs ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for contactHseqs" + e);
			throw new NovaHVDaoException(e);

		}

		return contactHseq;
	}

	/**
	 * Method for Save one new contactHseq
	 * 
	 * @param data
	 *            for the new contactHseq
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "contactHseq/save", method = RequestMethod.POST)
	@ResponseBody
	public void setContactHseq(@RequestBody ContactHseq contactHseq) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for contactHseq");
		try {
			contactHseqDAO.save(contactHseq);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for contactHseq " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one contactHseq
	 * 
	 * @param idcnthseq
	 *            Id for contactHseq
	 * @param contactHseq
	 *            Data for update the contactHseq
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "contactHseq/edit/{id}")
	@ResponseBody

	public void editContactHseq(@PathVariable("id") long idcnthseq, @RequestBody ContactHseq contactHseq) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for contactHseq");
		try {
			contactHseqDAO.save(contactHseq);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for contactHseq " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one contactHseq
	 * 
	 * @param idcnthseq
	 *            ID the contactHseq
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "contactHseq/delete/{id}")
	@ResponseBody
	public void getDeleteContactHseq(@PathVariable("id") long idcnthseq) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for contactHseq");
		try {
			contactHseqDAO.delete(idcnthseq);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for contactHseq " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
