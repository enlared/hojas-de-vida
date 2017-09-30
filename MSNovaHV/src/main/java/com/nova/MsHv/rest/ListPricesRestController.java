//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.ListPricesDAO;
//import com.nova.MsHv.dto.ListPrices;
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
// * @listPrices enlaRed.co
// * @version 1.0
// */
//public class ListPricesRestController {
//	static final Logger log = Logger.getLogger(ListPricesRestController.class);
//	@Autowired
//	ListPricesDAO listPricesDAO;
//
//	/**
//	 * Method for get one listPrices with your ID
//	 * 
//	 * @param idlstprc
//	 *            Id the listPrices
//	 * @return Object the listPrices wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("listPrices/find/{id}")
//	@ResponseBody
//
//	public ListPrices getListPrices(@PathVariable("id") long idlstprc) throws NovaHVDaoException {
//		ListPrices listPrices = new ListPrices();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in listPrices");
//		try {
//
//			listPrices = listPricesDAO.findByIdlstprc(idlstprc);
//			if (!listPrices.equals(null)) {
//
//				log.info("Log4j get the listPrices with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for listPrices " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return listPrices;
//	}
//
//	
//	
//	/**
//	 * Method for get all listPricess in the BD
//	 * 
//	 * @return arrayList whit all listPricess
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("listPrices/findall")
//	@ResponseBody
//	public List<ListPrices> getListPricesAll() throws NovaHVDaoException {
//		List<ListPrices> listPrices = new ArrayList<ListPrices>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for listPrices");
//		try {
//
//			listPrices = listPricesDAO.findAll();
//			if (listPrices.equals(null)) {
//
//				log.info("Log4j get the list listPricess ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for listPricess" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return listPrices;
//	}
//
//	/**
//	 * Method for Save one new listPrices
//	 * 
//	 * @param data
//	 *            for the new listPrices
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "listPrices/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setListPrices(@RequestBody ListPrices listPrices) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for listPrices");
//		try {
//			listPricesDAO.save(listPrices);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for listPrices " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one listPrices
//	 * 
//	 * @param idlstprc
//	 *            Id for listPrices
//	 * @param listPrices
//	 *            Data for update the listPrices
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "listPrices/edit/{id}")
//	@ResponseBody
//
//	public void editListPrices(@PathVariable("id") long idlstprc, @RequestBody ListPrices listPrices) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for listPrices");
//		try {
//			listPricesDAO.save(listPrices);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for listPrices " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one listPrices
//	 * 
//	 * @param idlstprc
//	 *            ID the listPrices
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "listPrices/delete/{id}")
//	@ResponseBody
//	public void getDeleteListPrices(@PathVariable("id") long idlstprc) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for listPrices");
//		try {
//			listPricesDAO.delete(idlstprc);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for listPrices " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
