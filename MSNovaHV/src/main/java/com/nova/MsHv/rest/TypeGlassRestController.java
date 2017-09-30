//package com.nova.MsHv.rest;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nova.MsHv.dao.TypeGlassDAO;
//import com.nova.MsHv.dto.TypeGlass;
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
//public class TypeGlassRestController {
//	static final Logger log = Logger.getLogger(TypeGlassRestController.class);
//	@Autowired
//	TypeGlassDAO typeGlassDAO;
//
//	/**
//	 * Method for get one type glass with your ID
//	 * 
//	 * @param idtpglass
//	 *            Id the type glass
//	 * @return Object the type glass wanted
//	 * @throws NovaHVDaoException
//	 *             Exception when the object not found
//	 */
//
//	@RequestMapping("typeGlass/find/{id}")
//	@ResponseBody
//
//	public TypeGlass getTypeGlass(@PathVariable("id") long idtpglass) throws NovaHVDaoException {
//		TypeGlass typeGlass = new TypeGlass();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j for method find one in type Glass");
//		try {
//
//			typeGlass = typeGlassDAO.findByIdtpglass(idtpglass);
//			if (!typeGlass.equals(null)) {
//
//				log.info("Log4j get the type glass with id ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in Method Find for type glass " + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return typeGlass;
//	}
//
//	
//	
//	/**
//	 * Method for get all type Glass in the BD
//	 * 
//	 * @return arrayList whit all type glass
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping("typeGlass/findall")
//	@ResponseBody
//	public List<TypeGlass> getTypeGlassAll() throws NovaHVDaoException {
//		List<TypeGlass> typeGlass = new ArrayList<TypeGlass>();
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method find All for type glass");
//		try {
//
//			typeGlass = typeGlassDAO.findAll();
//			if (typeGlass.equals(null)) {
//
//				log.info("Log4j get the list type glass ");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Find All for type glass" + e);
//			throw new NovaHVDaoException(e);
//
//		}
//
//		return typeGlass;
//	}
//
//	/**
//	 * Method for Save one new typeGlass
//	 * 
//	 * @param data
//	 *            for the new typeglass
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(value = "typeGlass/save", method = RequestMethod.POST)
//	@ResponseBody
//	public void setTypeGlass(@RequestBody TypeGlass typeGlass) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method save for typeglass");
//		try {
//			typeGlassDAO.save(typeGlass);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Save for type glass " + e);
//			throw new NovaHVRestException(e);
//
//		}
//
//	}
//
//	/**
//	 * Method for edit one type glass
//	 * 
//	 * @param idtpglass
//	 *            Id for type glass
//	 * @param regionals
//	 *            Data for update the type glass
//	 * @throws NovaHVRestException
//	 */
//
//	@RequestMapping(method = RequestMethod.PUT, path = "typeGlass/edit/{id}")
//	@ResponseBody
//
//	public void editTypeGlass(@PathVariable("id") long idtpglass, @RequestBody TypeGlass typeGlass) throws NovaHVRestException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method edit for type glass");
//		try {
//			typeGlassDAO.save(typeGlass);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error("Log4j Error in method Update for type glass " + e);
//			throw new NovaHVRestException(e);
//		}
//
//	}
//
//	/**
//	 * Method for Delete one type glass
//	 * 
//	 * @param idtpglass
//	 *            ID the type glass
//	 * @throws NovaHVDaoException
//	 */
//
//	@RequestMapping(method = RequestMethod.DELETE, path = "typeGlass/delete/{id}")
//	@ResponseBody
//	public void getDeleteTypeGlass(@PathVariable("id") long idtpglass) throws NovaHVDaoException {
//
//		PropertyConfigurator.configure("log4j.properties");
//		log.info("Log4j method Delete for type glass");
//		try {
//			typeGlassDAO.delete(idtpglass);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//
//			log.error("Log4j Error in method Delete for type glass " + e);
//			throw new NovaHVDaoException(e);
//		}
//
//	}
//
//
//}
