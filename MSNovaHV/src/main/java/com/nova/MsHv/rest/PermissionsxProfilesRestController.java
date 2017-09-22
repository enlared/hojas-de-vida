package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.PermissionsxProfilesDAO;
import com.nova.MsHv.dto.PermissionsxProfiles;
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
 * @permissionsxProfiles enlaRed.co
 * @version 1.0
 */
public class PermissionsxProfilesRestController {
	static final Logger log = Logger.getLogger(PermissionsxProfilesRestController.class);
	@Autowired
	PermissionsxProfilesDAO permissionsxProfilesDAO;

	/**
	 * Method for get one permissionsxProfiles with your ID
	 * 
	 * @param idgnrprmxprf
	 *            Id the permissionsxProfiles
	 * @return Object the permissionsxProfiles wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("permissionsxProfiles/find/{id}")
	@ResponseBody

	public PermissionsxProfiles getPermissionsxProfiles(@PathVariable("id") long idgnrprmxprf) throws NovaHVDaoException {
		PermissionsxProfiles permissionsxProfiles = new PermissionsxProfiles();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in permissionsxProfiles");
		try {

			permissionsxProfiles = permissionsxProfilesDAO.findByIdgnrprmxprf(idgnrprmxprf);
			if (!permissionsxProfiles.equals(null)) {

				log.info("Log4j get the permissionsxProfiles with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for permissionsxProfiles " + e);
			throw new NovaHVDaoException(e);

		}

		return permissionsxProfiles;
	}

	
	
	/**
	 * Method for get all permissionsxProfiless in the BD
	 * 
	 * @return arrayList whit all permissionsxProfiless
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("permissionsxProfiles/findall")
	@ResponseBody
	public List<PermissionsxProfiles> getPermissionsxProfilesAll() throws NovaHVDaoException {
		List<PermissionsxProfiles> permissionsxProfiles = new ArrayList<PermissionsxProfiles>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for permissionsxProfiles");
		try {

			permissionsxProfiles = permissionsxProfilesDAO.findAll();
			if (permissionsxProfiles.equals(null)) {

				log.info("Log4j get the list permissionsxProfiless ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for permissionsxProfiless" + e);
			throw new NovaHVDaoException(e);

		}

		return permissionsxProfiles;
	}

	/**
	 * Method for Save one new permissionsxProfiles
	 * 
	 * @param data
	 *            for the new permissionsxProfiles
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "permissionsxProfiles/save", method = RequestMethod.POST)
	@ResponseBody
	public void setPermissionsxProfiles(@RequestBody PermissionsxProfiles permissionsxProfiles) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for permissionsxProfiles");
		try {
			permissionsxProfilesDAO.save(permissionsxProfiles);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for permissionsxProfiles " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one permissionsxProfiles
	 * 
	 * @param idgnrprmxprf
	 *            Id for permissionsxProfiles
	 * @param permissionsxProfiles
	 *            Data for update the permissionsxProfiles
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "permissionsxProfiles/edit/{id}")
	@ResponseBody

	public void editPermissionsxProfiles(@PathVariable("id") long idgnrprmxprf, @RequestBody PermissionsxProfiles permissionsxProfiles) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for permissionsxProfiles");
		try {
			permissionsxProfilesDAO.save(permissionsxProfiles);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for permissionsxProfiles " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one permissionsxProfiles
	 * 
	 * @param idgnrprmxprf
	 *            ID the permissionsxProfiles
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "permissionsxProfiles/delete/{id}")
	@ResponseBody
	public void getDeletePermissionsxProfiles(@PathVariable("id") long idgnrprmxprf) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for permissionsxProfiles");
		try {
			permissionsxProfilesDAO.delete(idgnrprmxprf);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for permissionsxProfiles " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
