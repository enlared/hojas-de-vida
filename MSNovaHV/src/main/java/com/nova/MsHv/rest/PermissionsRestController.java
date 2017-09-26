package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.PermissionsDAO;
import com.nova.MsHv.dto.Permissions;
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
 * @permissions enlaRed.co
 * @version 1.0
 */
public class PermissionsRestController {
	static final Logger log = Logger.getLogger(PermissionsRestController.class);
	@Autowired
	PermissionsDAO permissionsDAO;

	/**
	 * Method for get one permissions with your ID
	 * 
	 * @param idprm
	 *            Id the permissions
	 * @return Object the permissions wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("permissions/find/{id}")
	@ResponseBody

	public Permissions getPermissions(@PathVariable("id") long idprm) throws NovaHVDaoException {
		Permissions permissions = new Permissions();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in permissions");
		try {

			permissions = permissionsDAO.findByIdprm(idprm);
			if (!permissions.equals(null)) {

				log.info("Log4j get the permissions with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for permissions " + e);
			throw new NovaHVDaoException(e);

		}

		return permissions;
	}

	
	
	/**
	 * Method for get all permissionss in the BD
	 * 
	 * @return arrayList whit all permissionss
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("permissions/findall")
	@ResponseBody
	public List<Permissions> getPermissionsAll() throws NovaHVDaoException {
		List<Permissions> permissions = new ArrayList<Permissions>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for permissions");
		try {

			permissions = permissionsDAO.findAll();
			if (permissions.equals(null)) {

				log.info("Log4j get the list permissionss ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for permissionss" + e);
			throw new NovaHVDaoException(e);

		}

		return permissions;
	}

	/**
	 * Method for Save one new permissions
	 * 
	 * @param data
	 *            for the new permissions
	 * @throws NovaHvRestException
	 */

	@RequestMapping(value = "permissions/save", method = RequestMethod.POST)
	@ResponseBody
	public void setPermissions(@RequestBody Permissions permissions) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for permissions");
		try {
			permissionsDAO.save(permissions);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for permissions " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one permissions
	 * 
	 * @param idprm
	 *            Id for permissions
	 * @param permissions
	 *            Data for update the permissions
	 * @throws NovaHvRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "permissions/edit/{id}")
	@ResponseBody

	public void editPermissions(@PathVariable("id") long idprm, @RequestBody Permissions permissions) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for permissions");
		try {
			permissionsDAO.save(permissions);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for permissions " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one permissions
	 * 
	 * @param idprm
	 *            ID the permissions
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "permissions/delete/{id}")
	@ResponseBody
	public void getDeletePermissions(@PathVariable("id") long idprm) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for permissions");
		try {
			permissionsDAO.delete(idprm);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for permissions " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
