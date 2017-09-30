//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.TypeEmployeesDAO;
//import com.nova.MsHv.dto.TypeEmployees;
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
// * @typeEmployees enlaRed.co
// * @version 1.0
// */
//public class TypeEmployeesRestController {
//	static final Logger log = Logger.getLogger(TypeEmployeesRestController.class);
//	@Autowired
//	TypeEmployeesDAO typeEmployeesDAO;
//
//	/**
//	 * Method for get one typeEmployees with your ID
//	 * 
//	 * @param idtpemp
//	 *            Id the typeEmployees
//	 * @return Object the typeEmployees wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("typeEmployees/find/{id}")
//	@ResponseBody
//
//	public TypeEmployees getTypeEmployees(@PathVariable("id") long idtpemp) throws NovaHVDaoException {
//		TypeEmployees typeEmployees = new TypeEmployees();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in typeEmployees");
//		try {
//
//			typeEmployees = typeEmployeesDAO.findByIdtpemp(idtpemp);
//			if (!typeEmployees.equals(null)) {
//
//				log.info("Log4j get the typeEmployees with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for typeEmployees " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return typeEmployees;
//	}
//
//	
//	
//	/**
//	 * Method for get all typeEmployeess in the BD
//	 * 
//	 * @return arrayList whit all typeEmployeess
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("typeEmployees/findall")
//	@ResponseBody
//	public List<TypeEmployees> getTypeEmployeesAll() throws NovaHVDaoException {
//		List<TypeEmployees> typeEmployees = new ArrayList<TypeEmployees>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for typeEmployees");
//		try {
//
//			typeEmployees = typeEmployeesDAO.findAll();
//			if (typeEmployees.equals(null)) {
//
//				log.info("Log4j get the list typeEmployeess ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for typeEmployeess" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return typeEmployees;
//	}
//
//	/**
//	 * Method for Save one new typeEmployees
//	 * 
//	 * @param data
//	 *            for the new typeEmployees
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "typeEmployees/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setTypeEmployees(@RequestBody TypeEmployees typeEmployees) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for typeEmployees");
//		try {
//			typeEmployeesDAO.save(typeEmployees);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for typeEmployees " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one typeEmployees
//	 * 
//	 * @param idtpemp
//	 *            Id for typeEmployees
//	 * @param typeEmployees
//	 *            Data for update the typeEmployees
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "typeEmployees/edit/{id}")
//	@ResponseBody
//
//	public void editTypeEmployees(@PathVariable("id") long idtpemp, @RequestBody TypeEmployees typeEmployees) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for typeEmployees");
//		try {
//			typeEmployeesDAO.save(typeEmployees);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for typeEmployees " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one typeEmployees
//	 * 
//	 * @param idtpemp
//	 *            ID the typeEmployees
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "typeEmployees/delete/{id}")
//	@ResponseBody
//	public void getDeleteTypeEmployees(@PathVariable("id") long idtpemp) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for typeEmployees");
//		try {
//			typeEmployeesDAO.delete(idtpemp);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for typeEmployees " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
