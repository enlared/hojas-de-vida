package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.TypeNegociationDAO;
import com.nova.MsHv.dto.TypeNegociation;
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
 * @typeNegociation enlaRed.co
 * @version 1.0
 */
public class TypeNegociationRestController {
	static final Logger log = Logger.getLogger(TypeNegociationRestController.class);
	@Autowired
	TypeNegociationDAO typeNegociationDAO;

	/**
	 * Method for get one typeNegociation with your ID
	 * 
	 * @param idtpngc
	 *            Id the typeNegociation
	 * @return Object the typeNegociation wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("typeNegociation/find/{id}")
	@ResponseBody

	public TypeNegociation getTypeNegociation(@PathVariable("id") long idtpngc) throws NovaHVDaoException {
		TypeNegociation typeNegociation = new TypeNegociation();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in typeNegociation");
		try {

			typeNegociation = typeNegociationDAO.findByIdtpngc(idtpngc);
			if (!typeNegociation.equals(null)) {

				log.info("Log4j get the typeNegociation with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for typeNegociation " + e);
			throw new NovaHVDaoException(e);

		}

		return typeNegociation;
	}

	
	
	/**
	 * Method for get all typeNegociations in the BD
	 * 
	 * @return arrayList whit all typeNegociations
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("typeNegociation/findall")
	@ResponseBody
	public List<TypeNegociation> getTypeNegociationAll() throws NovaHVDaoException {
		List<TypeNegociation> typeNegociation = new ArrayList<TypeNegociation>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for typeNegociation");
		try {

			typeNegociation = typeNegociationDAO.findAll();
			if (typeNegociation.equals(null)) {

				log.info("Log4j get the list typeNegociations ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for typeNegociations" + e);
			throw new NovaHVDaoException(e);

		}

		return typeNegociation;
	}

	/**
	 * Method for Save one new typeNegociation
	 * 
	 * @param data
	 *            for the new typeNegociation
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "typeNegociation/save", method = RequestMethod.POST)
	@ResponseBody
	public void setTypeNegociation(@RequestBody TypeNegociation typeNegociation) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for typeNegociation");
		try {
			typeNegociationDAO.save(typeNegociation);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for typeNegociation " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one typeNegociation
	 * 
	 * @param idtpngc
	 *            Id for typeNegociation
	 * @param typeNegociation
	 *            Data for update the typeNegociation
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "typeNegociation/edit/{id}")
	@ResponseBody

	public void editTypeNegociation(@PathVariable("id") long idtpngc, @RequestBody TypeNegociation typeNegociation) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for typeNegociation");
		try {
			typeNegociationDAO.save(typeNegociation);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for typeNegociation " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one typeNegociation
	 * 
	 * @param idtpngc
	 *            ID the typeNegociation
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "typeNegociation/delete/{id}")
	@ResponseBody
	public void getDeleteTypeNegociation(@PathVariable("id") long idtpngc) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for typeNegociation");
		try {
			typeNegociationDAO.delete(idtpngc);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for typeNegociation " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
