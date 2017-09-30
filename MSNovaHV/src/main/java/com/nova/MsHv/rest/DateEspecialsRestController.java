//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.DateEspecialsDAO;
//import com.nova.MsHv.dto.DateEspecials;
//import com.nova.MsHvExcepciones.NovaHVDaoException;
//import com.nova.MsHvExcepciones.NovaHVRestException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//@CrossOrigin
//@Controller
//
///**
// * Class for rest service http for CRUD
// * 
// * @dateEspecials enlaRed.co
// * @version 1.0
// */
//public class DateEspecialsRestController {
//	static final Logger log = Logger.getLogger(DateEspecialsRestController.class);
//	@Autowired
//	DateEspecialsDAO dateEspecialsDAO;
//
//	/**
//	 * Method for get one dateEspecials with your ID
//	 * 
//	 * @param iddtspc
//	 *            Id the dateEspecials
//	 * @return Object the dateEspecials wanted
//	 * @throws NovaHvDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("dateEspecials/find/{id}")
//	@ResponseBody
//
//	public DateEspecials getDateEspecials(@PathVariable("id") long iddtspc) throws NovaHVDaoException {
//		DateEspecials dateEspecials = new DateEspecials();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in dateEspecials");
//		try {
//
//			dateEspecials = dateEspecialsDAO.findByIddtspc(iddtspc);
//			if (!dateEspecials.equals(null)) {
//
//				log.info("Log4j get the dateEspecials with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for dateEspecials " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return dateEspecials;
//	}
//
//	
//	
//	/**
//	 * Method for get all dateEspecialss in the BD
//	 * 
//	 * @return arrayList whit all dateEspecialss
//	 * @throws NovaHvDaoException
//	 */
//
//	@RequestMapping("dateEspecials/findall")
//	@ResponseBody
//	public List<DateEspecials> getDateEspecialsAll() throws NovaHVDaoException {
//		List<DateEspecials> dateEspecials = new ArrayList<DateEspecials>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for dateEspecials");
//		try {
//
//			dateEspecials = dateEspecialsDAO.findAll();
//			if (dateEspecials.equals(null)) {
//
//				log.info("Log4j get the list dateEspecialss ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for dateEspecialss" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return dateEspecials;
//	}
//
//	/**
//	 * Method for Save one new dateEspecials
//	 * 
//	 * @param data
//	 *            for the new dateEspecials
//	 * @throws NovaHvRestException
//	 */
//
//	@RequestMapping(value = "dateEspecials/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setDateEspecials(@RequestBody DateEspecials dateEspecials) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for dateEspecials");
//		try {
//			dateEspecialsDAO.save(dateEspecials);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for dateEspecials " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one dateEspecials
//	 * 
//	 * @param iddtspc
//	 *            Id for dateEspecials
//	 * @param dateEspecials
//	 *            Data for update the dateEspecials
//	 * @throws NovaHvRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "dateEspecials/edit/{id}")
//	@ResponseBody
//
//	public void editDateEspecials(@PathVariable("id") long iddtspc, @RequestBody DateEspecials dateEspecials) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for dateEspecials");
//		try {
//			dateEspecialsDAO.save(dateEspecials);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for dateEspecials " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one dateEspecials
//	 * 
//	 * @param iddtspc
//	 *            ID the dateEspecials
//	 * @throws NovaHvDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "dateEspecials/delete/{id}")
//	@ResponseBody
//	public void getDeleteDateEspecials(@PathVariable("id") long iddtspc) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for dateEspecials");
//		try {
//			dateEspecialsDAO.delete(iddtspc);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for dateEspecials " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//
//}
