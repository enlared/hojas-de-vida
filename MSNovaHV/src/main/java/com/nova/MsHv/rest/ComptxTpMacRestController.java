package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.ComptxTpMacDAO;
import com.nova.MsHv.dto.ComptxTpMach;
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
 * @author enlaRed.co
 * @version 1.0
 */
public class ComptxTpMacRestController {
	static final Logger log = Logger.getLogger(ComptxTpMacRestController.class);
	@Autowired
	ComptxTpMacDAO comptxTpMacDAO;



	@RequestMapping("comptxTpMac/find/{id}")
	@ResponseBody

	public ComptxTpMach getComptxTpMac(@PathVariable("id") long idcompxtpmac) throws NovaHVDaoException {
		ComptxTpMach comptxTpMach = new ComptxTpMach();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in author");
		try {

			comptxTpMach = comptxTpMacDAO.findByIdcompxtpmac(idcompxtpmac);
			if (!comptxTpMach.equals(null)) {

				log.info("Log4j get the author with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for author " + e);
			throw new NovaHVDaoException(e);

		}

		return comptxTpMach;
	}

	

	@RequestMapping("comptxTpMac/findall")
	@ResponseBody
	public List<ComptxTpMach> getComptxTpMachAll() throws NovaHVDaoException {
		List<ComptxTpMach> comptxTpMach = new ArrayList<ComptxTpMach>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for comptxTpMac");
		try {

			comptxTpMach = comptxTpMacDAO.findAll();
			if (comptxTpMach.equals(null)) {

				log.info("Log4j get the list comptxTpMac");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for comptxTpMac" + e);
			throw new NovaHVDaoException(e);

		}

		return comptxTpMach;
	}



	@RequestMapping(value = "comptxTpMac/save", method = RequestMethod.POST)
	@ResponseBody
	public void setComptxTpMac(@RequestBody ComptxTpMach comptxTpMach) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for comptxTpMach");
		try {
			comptxTpMacDAO.save(comptxTpMach);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for coptxTpMach " + e);
			throw new NovaHVRestException(e);

		}

	}

	

	@RequestMapping(method = RequestMethod.PUT, path = "comptxTpMac/edit/{id}")
	@ResponseBody

	public void editComptxTpMach(@PathVariable("id") long idcompxtpmac, @RequestBody ComptxTpMach comptxTpMach) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for comptxTpMach");
		try {
			comptxTpMacDAO.save(comptxTpMach);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for comptxTpMac" + e);
			throw new NovaHVRestException(e);
		}

	}



	@RequestMapping(method = RequestMethod.DELETE, path = "comptxTpMac/delete/{id}")
	@ResponseBody
	public void getDeleteAuthor(@PathVariable("id") long idcompxtpmac) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for comptxTpMac");
		try {
			comptxTpMacDAO.delete(idcompxtpmac);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for comptxTpMac " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
