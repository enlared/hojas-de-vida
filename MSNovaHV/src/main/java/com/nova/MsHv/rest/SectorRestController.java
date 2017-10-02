package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.SectorDAO;
import com.nova.MsHv.entidad.Sector;
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
 * @sector enlaRed.co
 * @version 1.0
 */
public class SectorRestController {
	static final Logger log = Logger.getLogger(SectorRestController.class);
	@Autowired
	SectorDAO sectorDAO;

	/**
	 * Method for get one sector with your ID
	 * 
	 * @param idsct
	 *            Id the sector
	 * @return Object the sector wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("sector/find/{id}")
	@ResponseBody

	public Sector getSector(@PathVariable("id") int idsct) throws NovaHVDaoException {
		Sector sector = new Sector();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in sector");
		try {

			sector = sectorDAO.findById(idsct);
			if (!sector.equals(null)) {

				log.info("Log4j get the sector with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for sector " + e);
			throw new NovaHVDaoException(e);

		}

		return sector;
	}

	
	
	/**
	 * Method for get all sectors in the BD
	 * 
	 * @return arrayList whit all sectors
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("sector/findall")
	@ResponseBody
	public List<Sector> getSectorAll() throws NovaHVDaoException {
		List<Sector> sector = new ArrayList<Sector>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for sector");
		try {

			sector = sectorDAO.findAll();
			if (sector.equals(null)) {

				log.info("Log4j get the list sectors ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for sectors" + e);
			throw new NovaHVDaoException(e);

		}

		return sector;
	}

	/**
	 * Method for Save one new sector
	 * 
	 * @param data
	 *            for the new sector
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "sector/save", method = RequestMethod.POST)
	@ResponseBody
	public void setSector(@RequestBody Sector sector) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for sector");
		try {
			sectorDAO.save(sector);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for sector " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one sector
	 * 
	 * @param idsct
	 *            Id for sector
	 * @param sector
	 *            Data for update the sector
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "sector/edit/{id}")
	@ResponseBody

	public void editSector(@PathVariable("id") long idsct, @RequestBody Sector sector) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for sector");
		try {
			sectorDAO.save(sector);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for sector " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one sector
	 * 
	 * @param idsct
	 *            ID the sector
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "sector/delete/{id}")
	@ResponseBody
	public void getDeleteSector(@PathVariable("id") long idsct) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for sector");
		try {
			sectorDAO.delete(idsct);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for sector " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
