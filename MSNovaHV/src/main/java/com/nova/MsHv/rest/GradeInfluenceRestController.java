package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.GradeInfuenceDAO;
import com.nova.MsHv.dto.GradeInfluence;
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
 * @gradeInfluence enlaRed.co
 * @version 1.0
 */
public class GradeInfluenceRestController {
	static final Logger log = Logger.getLogger(GradeInfluenceRestController.class);
	@Autowired
	GradeInfuenceDAO gradeInfluenceDAO;

	/**
	 * Method for get one gradeInfluence with your ID
	 * 
	 * @param idgrdinfl
	 *            Id the gradeInfluence
	 * @return Object the gradeInfluence wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("gradeInfluence/find/{id}")
	@ResponseBody

	public GradeInfluence getGradeInfluence(@PathVariable("id") long idgrdinfl) throws NovaHVDaoException {
		GradeInfluence gradeInfluence = new GradeInfluence();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in gradeInfluence");
		try {

			gradeInfluence = gradeInfluenceDAO.findByIdgrdinfl(idgrdinfl);
			if (!gradeInfluence.equals(null)) {

				log.info("Log4j get the gradeInfluence with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for gradeInfluence " + e);
			throw new NovaHVDaoException(e);

		}

		return gradeInfluence;
	}

	
	
	/**
	 * Method for get all gradeInfluences in the BD
	 * 
	 * @return arrayList whit all gradeInfluences
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("gradeInfluence/findall")
	@ResponseBody
	public List<GradeInfluence> getGradeInfluenceAll() throws NovaHVDaoException {
		List<GradeInfluence> gradeInfluence = new ArrayList<GradeInfluence>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for gradeInfluence");
		try {

			gradeInfluence = gradeInfluenceDAO.findAll();
			if (gradeInfluence.equals(null)) {

				log.info("Log4j get the list gradeInfluences ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for gradeInfluences" + e);
			throw new NovaHVDaoException(e);

		}

		return gradeInfluence;
	}

	/**
	 * Method for Save one new gradeInfluence
	 * 
	 * @param data
	 *            for the new gradeInfluence
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "gradeInfluence/save", method = RequestMethod.POST)
	@ResponseBody
	public void setGradeInfluence(@RequestBody GradeInfluence gradeInfluence) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for gradeInfluence");
		try {
			gradeInfluenceDAO.save(gradeInfluence);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for gradeInfluence " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one gradeInfluence
	 * 
	 * @param idgrdinfl
	 *            Id for gradeInfluence
	 * @param gradeInfluence
	 *            Data for update the gradeInfluence
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "gradeInfluence/edit/{id}")
	@ResponseBody

	public void editGradeInfluence(@PathVariable("id") long idgrdinfl, @RequestBody GradeInfluence gradeInfluence) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for gradeInfluence");
		try {
			gradeInfluenceDAO.save(gradeInfluence);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for gradeInfluence " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one gradeInfluence
	 * 
	 * @param idgrdinfl
	 *            ID the gradeInfluence
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "gradeInfluence/delete/{id}")
	@ResponseBody
	public void getDeleteGradeInfluence(@PathVariable("id") long idgrdinfl) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for gradeInfluence");
		try {
			gradeInfluenceDAO.delete(idgrdinfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for gradeInfluence " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
