package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.CompetitionDAO;
import com.nova.MsHv.dto.Competition;
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
public class CompetitionRestController {
	static final Logger log = Logger.getLogger(CompetitionRestController.class);
	@Autowired
	CompetitionDAO competitionDAO;



	@RequestMapping("competition/find/{id}")
	@ResponseBody

	public Competition getCompetition(@PathVariable("id") long idanlcmp) throws NovaHVDaoException {
		Competition competition = new Competition();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in competition");
		try {

			competition = competitionDAO.findByIdanlcmp(idanlcmp);
			if (!competition.equals(null)) {

				log.info("Log4j get the competition with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for competition " + e);
			throw new NovaHVDaoException(e);

		}

		return competition;
	}

	


	@RequestMapping("competition/findall")
	@ResponseBody
	public List<Competition> getCompetitionAll() throws NovaHVDaoException {
		List<Competition> competition = new ArrayList<Competition>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for competition");
		try {

			competition = competitionDAO.findAll();
			if (competition.equals(null)) {

				log.info("Log4j get the list competition ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for competition" + e);
			throw new NovaHVDaoException(e);

		}

		return competition;
	}

	@RequestMapping(value = "competition/save", method = RequestMethod.POST)
	@ResponseBody
	public void setCompetition(@RequestBody Competition competition) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for competition");
		try {
			competitionDAO.save(competition);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for competition " + e);
			throw new NovaHVRestException(e);

		}

	}



	@RequestMapping(method = RequestMethod.PUT, path = "competition/edit/{id}")
	@ResponseBody

	public void editCompetition(@PathVariable("id") long idanlcmp, @RequestBody Competition competition) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for competition");
		try {
			competitionDAO.save(competition);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for competition " + e);
			throw new NovaHVRestException(e);
		}

	}


	@RequestMapping(method = RequestMethod.DELETE, path = "competition/delete/{id}")
	@ResponseBody
	public void getDeleteCompmetition(@PathVariable("id") long idanlcmp) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for competition");
		try {
			competitionDAO.delete(idanlcmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for competition" + e);
			throw new NovaHVDaoException(e);
		}

	}


}
