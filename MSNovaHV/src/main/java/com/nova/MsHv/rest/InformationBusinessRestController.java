//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.InformationBusinessDAO;
//import com.nova.MsHv.dto.InformationBusiness;
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
// * @informationBusiness enlaRed.co
// * @version 1.0
// */
//public class InformationBusinessRestController {
//	static final Logger log = Logger.getLogger(InformationBusinessRestController.class);
//	@Autowired
//	InformationBusinessDAO informationBusinessDAO;
//
//	/**
//	 * Method for get one informationBusiness with your ID
//	 * 
//	 * @param idinfbsn
//	 *            Id the informationBusiness
//	 * @return Object the informationBusiness wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("informationBusiness/find/{id}")
//	@ResponseBody
//
//	public InformationBusiness getInformationBusiness(@PathVariable("id") long idinfbsn) throws NovaHVDaoException {
//		InformationBusiness informationBusiness = new InformationBusiness();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in informationBusiness");
//		try {
//
//			informationBusiness = informationBusinessDAO.findByIdinfbsn(idinfbsn);
//			if (!informationBusiness.equals(null)) {
//
//				log.info("Log4j get the informationBusiness with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for informationBusiness " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return informationBusiness;
//	}
//
//	
//	
//	/**
//	 * Method for get all informationBusinesss in the BD
//	 * 
//	 * @return arrayList whit all informationBusinesss
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("informationBusiness/findall")
//	@ResponseBody
//	public List<InformationBusiness> getInformationBusinessAll() throws NovaHVDaoException {
//		List<InformationBusiness> informationBusiness = new ArrayList<InformationBusiness>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for informationBusiness");
//		try {
//
//			informationBusiness = informationBusinessDAO.findAll();
//			if (informationBusiness.equals(null)) {
//
//				log.info("Log4j get the list informationBusinesss ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for informationBusinesss" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return informationBusiness;
//	}
//
//	/**
//	 * Method for Save one new informationBusiness
//	 * 
//	 * @param data
//	 *            for the new informationBusiness
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "informationBusiness/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setInformationBusiness(@RequestBody InformationBusiness informationBusiness) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for informationBusiness");
//		try {
//			informationBusinessDAO.save(informationBusiness);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for informationBusiness " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one informationBusiness
//	 * 
//	 * @param idinfbsn
//	 *            Id for informationBusiness
//	 * @param informationBusiness
//	 *            Data for update the informationBusiness
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "informationBusiness/edit/{id}")
//	@ResponseBody
//
//	public void editInformationBusiness(@PathVariable("id") long idinfbsn, @RequestBody InformationBusiness informationBusiness) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for informationBusiness");
//		try {
//			informationBusinessDAO.save(informationBusiness);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for informationBusiness " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one informationBusiness
//	 * 
//	 * @param idinfbsn
//	 *            ID the informationBusiness
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "informationBusiness/delete/{id}")
//	@ResponseBody
//	public void getDeleteInformationBusiness(@PathVariable("id") long idinfbsn) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for informationBusiness");
//		try {
//			informationBusinessDAO.delete(idinfbsn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for informationBusiness " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
