//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.AnchorageDAO;
//import com.nova.MsHv.dto.Anchorage;
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
//public class AnchorageRestController {
//	static final Logger log = Logger.getLogger(AnchorageRestController.class);
//	@Autowired
//	AnchorageDAO anchorageDAO;
//
//
//	@RequestMapping("anchorage/find/{id}")
//	@ResponseBody
//
//	public Anchorage getAnchorage(@PathVariable("id") long idanchg) throws NovaHVDaoException {
//		Anchorage anchorage = new Anchorage();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in anchorage");
//		try {
//
//			anchorage = anchorageDAO.findByIdanchg(idanchg);
//			if (!anchorage.equals(null)) {
//
//				log.info("Log4j get the anchorage with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for anchorage " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return anchorage;
//	}
//
//
//	@RequestMapping("anchorage/findall")
//	@ResponseBody
//	public List<Anchorage> getAnchorageAll() throws NovaHVDaoException {
//		List<Anchorage> anchorage = new ArrayList<Anchorage>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for anchorage");
//		try {
//			
//			anchorage = anchorageDAO.findAll();
//			if (anchorage.equals(null)) {
//
//				log.info("Log4j get the list anchorage ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for anchorage" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return anchorage;
//	}
//
//
//	@RequestMapping(value = "anchorage/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setAnchorage(@RequestBody Anchorage anchorage) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for anchorage");
//		try {
//			anchorageDAO.save(anchorage);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for anchorage " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//
//
//	@RequestMapping(method = RequestMethod.PUT, path = "anchorage/edit/{id}")
//	@ResponseBody
//
//	public void editAuthor(@PathVariable("id") long idanchg, @RequestBody Anchorage anchorage) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for anchorage");
//		try {
//			anchorageDAO.save(anchorage);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for anchorage " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "anchorage/delete/{id}")
//	@ResponseBody
//	public void getDeleteAnchorage(@PathVariable("id") long idanchg) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for anchorage");
//		try {
//			anchorageDAO.delete(idanchg);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for anchorage " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
