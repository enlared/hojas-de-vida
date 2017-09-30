//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.InformationContactxCustomersDAO;
//import com.nova.MsHv.dto.InformationContacts;
//import com.nova.MsHv.dto.InformationContactxCustomers;
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
// * @informationContactxCustomers enlaRed.co
// * @version 1.0
// */
//public class InformationContactxCustomersRestController {
//	static final Logger log = Logger.getLogger(InformationContactxCustomersRestController.class);
//	@Autowired
//	InformationContactxCustomersDAO informationContactxCustomersDAO;
//
//	/**
//	 * Method for get one informationContactxCustomers with your ID
//	 * 
//	 * @param idgnrinfcontc
//	 *            Id the informationContactxCustomers
//	 * @return Object the informationContactxCustomers wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("informationContactxCustomers/find/{id}")
//	@ResponseBody
//
//	public InformationContactxCustomers getInformationContactxCustomers(@PathVariable("id") long idgnrinfcontc) throws NovaHVDaoException {
//		InformationContactxCustomers informationContactxCustomers = new InformationContactxCustomers();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in informationContactxCustomers");
//		try {
//
//			informationContactxCustomers = informationContactxCustomersDAO.findByIdgnrinfcontc(idgnrinfcontc);
//			if (!informationContactxCustomers.equals(null)) {
//
//				log.info("Log4j get the informationContactxCustomers with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for informationContactxCustomers " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return informationContactxCustomers;
//	}
//
//	
//	
//	/**
//	 * Method for get all informationContactxCustomerss in the BD
//	 * 
//	 * @return arrayList whit all informationContactxCustomerss
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("informationContactxCustomers/findall")
//	@ResponseBody
//	public List<InformationContactxCustomers> getInformationContactxCustomersAll() throws NovaHVDaoException {
//		List<InformationContactxCustomers> informationContactxCustomers = new ArrayList<InformationContactxCustomers>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for informationContactxCustomers");
//		try {
//
//			informationContactxCustomers = informationContactxCustomersDAO.findAll();
//			if (informationContactxCustomers.equals(null)) {
//
//				log.info("Log4j get the list informationContactxCustomerss ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for informationContactxCustomerss" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return informationContactxCustomers;
//	}
//
//	/**
//	 * Method for Save one new informationContactxCustomers
//	 * 
//	 * @param data
//	 *            for the new informationContactxCustomers
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "informationContactxCustomers/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setInformationContactxCustomers(@RequestBody InformationContactxCustomers informationContactxCustomers) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for informationContactxCustomers");
//		try {
//			informationContactxCustomersDAO.save(informationContactxCustomers);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for informationContactxCustomers " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one informationContactxCustomers
//	 * 
//	 * @param idgnrinfcontc
//	 *            Id for informationContactxCustomers
//	 * @param informationContactxCustomers
//	 *            Data for update the informationContactxCustomers
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "informationContactxCustomers/edit/{id}")
//	@ResponseBody
//
//	public void editInformationContactxCustomers(@PathVariable("id") long idgnrinfcontc, @RequestBody InformationContactxCustomers informationContactxCustomers) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for informationContactxCustomers");
//		try {
//			informationContactxCustomersDAO.save(informationContactxCustomers);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for informationContactxCustomers " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one informationContactxCustomers
//	 * 
//	 * @param idgnrinfcontc
//	 *            ID the informationContactxCustomers
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "informationContactxCustomers/delete/{id}")
//	@ResponseBody
//	public void getDeleteInformationContactxCustomers(@PathVariable("id") long idgnrinfcontc) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for informationContactxCustomers");
//		try {
//			informationContactxCustomersDAO.delete(idgnrinfcontc);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for informationContactxCustomers " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
