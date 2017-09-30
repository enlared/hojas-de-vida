//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.KeyBusinessDAO;
//import com.nova.MsHv.dto.KeyBusiness;
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
// * @keyBusiness enlaRed.co
// * @version 1.0
// */
//public class KeyBusinessRestController {
//	static final Logger log = Logger.getLogger(KeyBusinessRestController.class);
//	@Autowired
//	KeyBusinessDAO keyBusinessDAO;
//
//	/**
//	 * Method for get one keyBusiness with your ID
//	 * 
//	 * @param idkbsn
//	 *            Id the keyBusiness
//	 * @return Object the keyBusiness wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("keyBusiness/find/{id}")
//	@ResponseBody
//
//	public KeyBusiness getKeyBusiness(@PathVariable("id") long idkbsn) throws NovaHVDaoException {
//		KeyBusiness keyBusiness = new KeyBusiness();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in keyBusiness");
//		try {
//
//			keyBusiness = keyBusinessDAO.findByIdkbsn(idkbsn);
//			if (!keyBusiness.equals(null)) {
//
//				log.info("Log4j get the keyBusiness with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for keyBusiness " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return keyBusiness;
//	}
//
//	
//	
//	/**
//	 * Method for get all keyBusinesss in the BD
//	 * 
//	 * @return arrayList whit all keyBusinesss
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("keyBusiness/findall")
//	@ResponseBody
//	public List<KeyBusiness> getKeyBusinessAll() throws NovaHVDaoException {
//		List<KeyBusiness> keyBusiness = new ArrayList<KeyBusiness>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for keyBusiness");
//		try {
//
//			keyBusiness = keyBusinessDAO.findAll();
//			if (keyBusiness.equals(null)) {
//
//				log.info("Log4j get the list keyBusinesss ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for keyBusinesss" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return keyBusiness;
//	}
//
//	/**
//	 * Method for Save one new keyBusiness
//	 * 
//	 * @param data
//	 *            for the new keyBusiness
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "keyBusiness/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setKeyBusiness(@RequestBody KeyBusiness keyBusiness) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for keyBusiness");
//		try {
//			keyBusinessDAO.save(keyBusiness);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for keyBusiness " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one keyBusiness
//	 * 
//	 * @param idkbsn
//	 *            Id for keyBusiness
//	 * @param keyBusiness
//	 *            Data for update the keyBusiness
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "keyBusiness/edit/{id}")
//	@ResponseBody
//
//	public void editKeyBusiness(@PathVariable("id") long idkbsn, @RequestBody KeyBusiness keyBusiness) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for keyBusiness");
//		try {
//			keyBusinessDAO.save(keyBusiness);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for keyBusiness " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one keyBusiness
//	 * 
//	 * @param idkbsn
//	 *            ID the keyBusiness
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "keyBusiness/delete/{id}")
//	@ResponseBody
//	public void getDeleteKeyBusiness(@PathVariable("id") long idkbsn) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for keyBusiness");
//		try {
//			keyBusinessDAO.delete(idkbsn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for keyBusiness " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
