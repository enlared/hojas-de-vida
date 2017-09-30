//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.InformationContactsDAO;
//import com.nova.MsHv.dto.InformationContacts;
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
// * @regionals enlaRed.co
// * @version 1.0
// */
//public class InformationContactsRestController {
//	static final Logger log = Logger.getLogger(InformationContactsRestController.class);
//	@Autowired
//	InformationContactsDAO informationContactsDAO;
//
//	/**
//	 * Method for get one information contacts with your ID
//	 * 
//	 * @param idinfcnt
//	 *            Id the information contacts
//	 * @return Object the information contacts wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("informationContacts/find/{id}")
//	@ResponseBody
//
//	public InformationContacts getInformationContacts(@PathVariable("id") long idinfcnt) throws NovaHVDaoException {
//		InformationContacts informationContacts = new InformationContacts();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in information contacts");
//		try {
//
//			informationContacts = informationContactsDAO.findByIdinfcnt(idinfcnt);
//			if (!informationContacts.equals(null)) {
//
//				log.info("Log4j get the information contacts with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for informaction contacts " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return informationContacts;
//	}
//
//	
//	
//	/**
//	 * Method for get all information contacts in the BD
//	 * 
//	 * @return arrayList whit all information contacts
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("informationContacts/findall")
//	@ResponseBody
//	public List<InformationContacts> getInformationContactsAll() throws NovaHVDaoException {
//		List<InformationContacts> informationContacts = new ArrayList<InformationContacts>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for information contacts");
//		try {
//
//			informationContacts = informationContactsDAO.findAll();
//			if (informationContacts.equals(null)) {
//
//				log.info("Log4j get the list information contacts");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for information contacts" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return informationContacts;
//	}
//
//	/**
//	 * Method for Save one new information contacts
//	 * 
//	 * @param data
//	 *            for the new information contacts
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "informationContacts/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setInformationContacts(@RequestBody InformationContacts informationContacts) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for information contacts");
//		try {
//			informationContactsDAO.save(informationContacts);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for information contacts " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one information contacts
//	 * 
//	 * @param idinfcnt
//	 *            Id for information contact
//	 * @param regionals
//	 *            Data for update the information contacts
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "informationContacts/edit/{id}")
//	@ResponseBody
//
//	public void editInformationContacts(@PathVariable("id") long idinfcnt, @RequestBody InformationContacts informationContacts) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for information contacts");
//		try {
//			informationContactsDAO.save(informationContacts);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for information contacts " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one information contacts
//	 * 
//	 * @param idinfcnt
//	 *            ID the information contacts
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "informationContacts/delete/{id}")
//	@ResponseBody
//	public void getDeleteInformationContacts(@PathVariable("id") long idinfcnt) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for information contacts");
//		try {
//			informationContactsDAO.delete(idinfcnt);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for information contacts " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
//
