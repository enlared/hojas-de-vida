package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.KeyAccountDAO;
import com.nova.MsHv.dto.KeyAccount;
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
 * @keyAccount enlaRed.co
 * @version 1.0
 */
public class KeyAccountRestController {
	static final Logger log = Logger.getLogger(KeyAccountRestController.class);
	@Autowired
	KeyAccountDAO keyAccountDAO;

	/**
	 * Method for get one keyAccount with your ID
	 * 
	 * @param idkacnt
	 *            Id the keyAccount
	 * @return Object the keyAccount wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("keyAccount/find/{id}")
	@ResponseBody

	public KeyAccount getKeyAccount(@PathVariable("id") long idkacnt) throws NovaHVDaoException {
		KeyAccount keyAccount = new KeyAccount();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in keyAccount");
		try {

			keyAccount = keyAccountDAO.findByIdkacnt(idkacnt);
			if (!keyAccount.equals(null)) {

				log.info("Log4j get the keyAccount with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for keyAccount " + e);
			throw new NovaHVDaoException(e);

		}

		return keyAccount;
	}

	
	
	/**
	 * Method for get all keyAccounts in the BD
	 * 
	 * @return arrayList whit all keyAccounts
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("keyAccount/findall")
	@ResponseBody
	public List<KeyAccount> getKeyAccountAll() throws NovaHVDaoException {
		List<KeyAccount> keyAccount = new ArrayList<KeyAccount>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for keyAccount");
		try {

			keyAccount = keyAccountDAO.findAll();
			if (keyAccount.equals(null)) {

				log.info("Log4j get the list keyAccounts ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for keyAccounts" + e);
			throw new NovaHVDaoException(e);

		}

		return keyAccount;
	}

	/**
	 * Method for Save one new keyAccount
	 * 
	 * @param data
	 *            for the new keyAccount
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "keyAccount/save", method = RequestMethod.POST)
	@ResponseBody
	public void setKeyAccount(@RequestBody KeyAccount keyAccount) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for keyAccount");
		try {
			keyAccountDAO.save(keyAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for keyAccount " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one keyAccount
	 * 
	 * @param idkacnt
	 *            Id for keyAccount
	 * @param keyAccount
	 *            Data for update the keyAccount
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "keyAccount/edit/{id}")
	@ResponseBody

	public void editKeyAccount(@PathVariable("id") long idkacnt, @RequestBody KeyAccount keyAccount) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for keyAccount");
		try {
			keyAccountDAO.save(keyAccount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for keyAccount " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one keyAccount
	 * 
	 * @param idkacnt
	 *            ID the keyAccount
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "keyAccount/delete/{id}")
	@ResponseBody
	public void getDeleteKeyAccount(@PathVariable("id") long idkacnt) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for keyAccount");
		try {
			keyAccountDAO.delete(idkacnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for keyAccount " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
