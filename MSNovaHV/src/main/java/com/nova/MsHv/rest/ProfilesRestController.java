package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.ProfilesDAO;
import com.nova.MsHv.dto.Profiles;
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
 * @profiles enlaRed.co
 * @version 1.0
 */
public class ProfilesRestController {
	static final Logger log = Logger.getLogger(ProfilesRestController.class);
	@Autowired
	ProfilesDAO profilesDAO;

	/**
	 * Method for get one profiles with your ID
	 * 
	 * @param idprf
	 *            Id the profiles
	 * @return Object the profiles wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("profiles/find/{id}")
	@ResponseBody

	public Profiles getProfiles(@PathVariable("id") long idprf) throws NovaHVDaoException {
		Profiles profiles = new Profiles();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in profiles");
		try {

			profiles = profilesDAO.findByIdprf(idprf);
			if (!profiles.equals(null)) {

				log.info("Log4j get the profiles with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for profiles " + e);
			throw new NovaHVDaoException(e);

		}

		return profiles;
	}

	
	
	/**
	 * Method for get all profiless in the BD
	 * 
	 * @return arrayList whit all profiless
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("profiles/findall")
	@ResponseBody
	public List<Profiles> getProfilesAll() throws NovaHVDaoException {
		List<Profiles> profiles = new ArrayList<Profiles>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for profiles");
		try {

			profiles = profilesDAO.findAll();
			if (profiles.equals(null)) {

				log.info("Log4j get the list profiless ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for profiless" + e);
			throw new NovaHVDaoException(e);

		}

		return profiles;
	}

	/**
	 * Method for Save one new profiles
	 * 
	 * @param data
	 *            for the new profiles
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "profiles/save", method = RequestMethod.POST)
	@ResponseBody
	public void setProfiles(@RequestBody Profiles profiles) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for profiles");
		try {
			profilesDAO.save(profiles);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for profiles " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one profiles
	 * 
	 * @param idprf
	 *            Id for profiles
	 * @param profiles
	 *            Data for update the profiles
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "profiles/edit/{id}")
	@ResponseBody

	public void editProfiles(@PathVariable("id") long idprf, @RequestBody Profiles profiles) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for profiles");
		try {
			profilesDAO.save(profiles);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for profiles " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one profiles
	 * 
	 * @param idprf
	 *            ID the profiles
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "profiles/delete/{id}")
	@ResponseBody
	public void getDeleteProfiles(@PathVariable("id") long idprf) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for profiles");
		try {
			profilesDAO.delete(idprf);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for profiles " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
