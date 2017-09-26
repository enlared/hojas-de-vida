package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.InfluenceShoppingDAO;
import com.nova.MsHv.dto.InfluenceShopping;
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
 * @influenceShopping enlaRed.co
 * @version 1.0
 */
public class InfluenceShoppingRestController {
	static final Logger log = Logger.getLogger(InfluenceShoppingRestController.class);
	@Autowired
	InfluenceShoppingDAO influenceShoppingDAO;

	/**
	 * Method for get one influenceShopping with your ID
	 * 
	 * @param idinfshp
	 *            Id the influenceShopping
	 * @return Object the influenceShopping wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("influenceShopping/find/{id}")
	@ResponseBody

	public InfluenceShopping getInfluenceShopping(@PathVariable("id") long idinfshp) throws NovaHVDaoException {
		InfluenceShopping influenceShopping = new InfluenceShopping();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in influenceShopping");
		try {

			influenceShopping = influenceShoppingDAO.findByIdinfshp(idinfshp);
			if (!influenceShopping.equals(null)) {

				log.info("Log4j get the influenceShopping with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for influenceShopping " + e);
			throw new NovaHVDaoException(e);

		}

		return influenceShopping;
	}

	
	
	/**
	 * Method for get all influenceShoppings in the BD
	 * 
	 * @return arrayList whit all influenceShoppings
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("influenceShopping/findall")
	@ResponseBody
	public List<InfluenceShopping> getInfluenceShoppingAll() throws NovaHVDaoException {
		List<InfluenceShopping> influenceShopping = new ArrayList<InfluenceShopping>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for influenceShopping");
		try {

			influenceShopping = influenceShoppingDAO.findAll();
			if (influenceShopping.equals(null)) {

				log.info("Log4j get the list influenceShoppings ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for influenceShoppings" + e);
			throw new NovaHVDaoException(e);

		}

		return influenceShopping;
	}

	/**
	 * Method for Save one new influenceShopping
	 * 
	 * @param data
	 *            for the new influenceShopping
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "influenceShopping/save", method = RequestMethod.POST)
	@ResponseBody
	public void setInfluenceShopping(@RequestBody InfluenceShopping influenceShopping) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for influenceShopping");
		try {
			influenceShoppingDAO.save(influenceShopping);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for influenceShopping " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one influenceShopping
	 * 
	 * @param idinfshp
	 *            Id for influenceShopping
	 * @param influenceShopping
	 *            Data for update the influenceShopping
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "influenceShopping/edit/{id}")
	@ResponseBody

	public void editInfluenceShopping(@PathVariable("id") long idinfshp, @RequestBody InfluenceShopping influenceShopping) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for influenceShopping");
		try {
			influenceShoppingDAO.save(influenceShopping);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for influenceShopping " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one influenceShopping
	 * 
	 * @param idinfshp
	 *            ID the influenceShopping
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "influenceShopping/delete/{id}")
	@ResponseBody
	public void getDeleteInfluenceShopping(@PathVariable("id") long idinfshp) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for influenceShopping");
		try {
			influenceShoppingDAO.delete(idinfshp);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for influenceShopping " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
