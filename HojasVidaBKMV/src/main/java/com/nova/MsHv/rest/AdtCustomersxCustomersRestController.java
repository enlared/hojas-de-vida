//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//import com.nova.MsHv.dao.AdtCustomersxCustomersDAO;
//import com.nova.MsHv.dto.AdtCustomersxCustomers;
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
// * @author enlaRed.co
// * @version 1.0
// */
//public class AdtCustomersxCustomersRestController {
//	static final Logger log = Logger.getLogger(AdtCustomersxCustomersRestController.class);
//	@Autowired
//	AdtCustomersxCustomersDAO adtCustomersxCustomersDAO;
//
//	
//
//	@RequestMapping("AdtCustomersxCustomers/find/{id}")
//	@ResponseBody
//
//	public AdtCustomersxCustomers getAuthor(@PathVariable("id") long idadtcstxcst) throws NovaHVDaoException {
//		AdtCustomersxCustomers adtCustomersxCustomers = new AdtCustomersxCustomers();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in adtCustomersxCustomers");
//		try {
//
//			adtCustomersxCustomers = adtCustomersxCustomersDAO.findByIdadtcstxcst(idadtcstxcst);
//			if (!adtCustomersxCustomers.equals(null)) {
//
//				log.info("Log4j get the adtCustomersxCustomers with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for adtCustomersxCustomers " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return adtCustomersxCustomers;
//	}
//
//
//	@RequestMapping("adtCustomersxCustomers/findall")
//	@ResponseBody
//	public List<AdtCustomersxCustomers> getAuthorAll() throws NovaHVDaoException {
//		List<AdtCustomersxCustomers> adtCustomersxCustomers = new ArrayList<AdtCustomersxCustomers>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for adtCustomersxCustomers");
//		try {
//
//			adtCustomersxCustomers = adtCustomersxCustomersDAO.findAll();
//			if (adtCustomersxCustomers.equals(null)) {
//
//				log.info("Log4j get the list adtCustomersxCustomers ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for adtCustomersxCustomers" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return adtCustomersxCustomers;
//	}
//
//	@RequestMapping(value = "AdtCustomersxCustomersauthor/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setAdtCustomersxCustomers(@RequestBody AdtCustomersxCustomers adtCustomersxCustomers) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for adtCustomersxCustomers");
//		try {
//			adtCustomersxCustomersDAO.save(adtCustomersxCustomers);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for adtCustomersxCustomers " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//
//	@RequestMapping(method = RequestMethod.PUT, path = "AdtCustomersxCustomers/edit/{id}")
//	@ResponseBody
//
//	public void editAdtCustomersxCustomers(@PathVariable("id") long idadtcstxcst, @RequestBody AdtCustomersxCustomers adtCustomersxCustomers) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for adtCustomersxCustomers");
//		try {
//			adtCustomersxCustomersDAO.save(adtCustomersxCustomers);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for author " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "AdtCustomersxCustomers/delete/{id}")
//	@ResponseBody
//	public void getDeleteAdtCustomersxCustomers(@PathVariable("id") long idadtcstxcst) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for adtCustomersxCustomers");
//		try {
//			adtCustomersxCustomersDAO.delete(idadtcstxcst);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for adtCustomersxCustomers " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
