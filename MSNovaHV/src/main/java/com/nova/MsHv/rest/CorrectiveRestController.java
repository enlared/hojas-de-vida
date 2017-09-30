//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.CorrectiveDAO;
//import com.nova.MsHv.dto.Corrective;
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
// * @corrective enlaRed.co
// * @version 1.0
// */
//public class CorrectiveRestController {
//	static final Logger log = Logger.getLogger(CorrectiveRestController.class);
//	@Autowired
//	CorrectiveDAO correctiveDAO;
//
//	/**
//	 * Method for get one corrective with your ID
//	 * 
//	 * @param idcorrective
//	 *            Id the corrective
//	 * @return Object the corrective wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("corrective/find/{id}")
//	@ResponseBody
//
//	public Corrective getCorrective(@PathVariable("id") long idcorrective) throws NovaHVDaoException {
//		Corrective corrective = new Corrective();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in corrective");
//		try {
//
//			corrective = correctiveDAO.findByIdcorrective(idcorrective);
//			if (!corrective.equals(null)) {
//
//				log.info("Log4j get the corrective with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for corrective " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return corrective;
//	}
//
//	
//	
//	/**
//	 * Method for get all correctives in the BD
//	 * 
//	 * @return arrayList whit all correctives
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("corrective/findall")
//	@ResponseBody
//	public List<Corrective> getCorrectiveAll() throws NovaHVDaoException {
//		List<Corrective> corrective = new ArrayList<Corrective>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for corrective");
//		try {
//
//			corrective = correctiveDAO.findAll();
//			if (corrective.equals(null)) {
//
//				log.info("Log4j get the list correctives ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for correctives" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return corrective;
//	}
//
//	/**
//	 * Method for Save one new corrective
//	 * 
//	 * @param data
//	 *            for the new corrective
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "corrective/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setCorrective(@RequestBody Corrective corrective) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for corrective");
//		try {
//			correctiveDAO.save(corrective);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for corrective " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one corrective
//	 * 
//	 * @param idcorrective
//	 *            Id for corrective
//	 * @param corrective
//	 *            Data for update the corrective
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "corrective/edit/{id}")
//	@ResponseBody
//
//	public void editCorrective(@PathVariable("id") long idcorrective, @RequestBody Corrective corrective) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for corrective");
//		try {
//			correctiveDAO.save(corrective);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for corrective " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one corrective
//	 * 
//	 * @param idcorrective
//	 *            ID the corrective
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "corrective/delete/{id}")
//	@ResponseBody
//	public void getDeleteCorrective(@PathVariable("id") long idcorrective) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for corrective");
//		try {
//			correctiveDAO.delete(idcorrective);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for corrective " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
