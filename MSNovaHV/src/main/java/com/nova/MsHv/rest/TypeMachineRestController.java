package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.TypeMachineDAO;
import com.nova.MsHv.dto.TypeMachine;
import com.nova.MsHvExcepciones.NovaHVDaoException;
import com.nova.MsHvExcepciones.NovaHVRestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @typeMachine enlaRed.co
 * @version 1.0
 */
public class TypeMachineRestController {
	static final Logger log = Logger.getLogger(TypeMachineRestController.class);
	@Autowired
	TypeMachineDAO typeMachineDAO;

	/**
	 * Method for get one typeMachine with your ID
	 * 
	 * @param idtpmac
	 *            Id the typeMachine
	 * @return Object the typeMachine wanted
	 * @throws NovaHVDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("typeMachine/find/{id}")
	@ResponseBody

	public TypeMachine getTypeMachine(@PathVariable("id") long idtpmac) throws NovaHVDaoException {
		TypeMachine typeMachine = new TypeMachine();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in typeMachine");
		try {

			typeMachine = typeMachineDAO.findByIdtpmac(idtpmac);
			if (!typeMachine.equals(null)) {

				log.info("Log4j get the typeMachine with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for typeMachine " + e);
			throw new NovaHVDaoException(e);

		}

		return typeMachine;
	}

	
	
	/**
	 * Method for get all typeMachines in the BD
	 * 
	 * @return arrayList whit all typeMachines
	 * @throws NovaHVDaoException
	 */

	@RequestMapping("typeMachine/findall")
	@ResponseBody
	public List<TypeMachine> getTypeMachineAll() throws NovaHVDaoException {
		List<TypeMachine> typeMachine = new ArrayList<TypeMachine>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for typeMachine");
		try {

			typeMachine = typeMachineDAO.findAll();
			if (typeMachine.equals(null)) {

				log.info("Log4j get the list typeMachines ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for typeMachines" + e);
			throw new NovaHVDaoException(e);

		}

		return typeMachine;
	}

	/**
	 * Method for Save one new typeMachine
	 * 
	 * @param data
	 *            for the new typeMachine
	 * @throws NovaHVRestException
	 */

	@RequestMapping(value = "typeMachine/save", method = RequestMethod.POST)
	@ResponseBody
	public void setTypeMachine(@RequestBody TypeMachine typeMachine) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for typeMachine");
		try {
			typeMachineDAO.save(typeMachine);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for typeMachine " + e);
			throw new NovaHVRestException(e);

		}

	}

	/**
	 * Method for edit one typeMachine
	 * 
	 * @param idtpmac
	 *            Id for typeMachine
	 * @param typeMachine
	 *            Data for update the typeMachine
	 * @throws NovaHVRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "typeMachine/edit/{id}")
	@ResponseBody

	public void editTypeMachine(@PathVariable("id") long idtpmac, @RequestBody TypeMachine typeMachine) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for typeMachine");
		try {
			typeMachineDAO.save(typeMachine);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for typeMachine " + e);
			throw new NovaHVRestException(e);
		}

	}

	/**
	 * Method for Delete one typeMachine
	 * 
	 * @param idtpmac
	 *            ID the typeMachine
	 * @throws NovaHVDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "typeMachine/delete/{id}")
	@ResponseBody
	public void getDeleteTypeMachine(@PathVariable("id") long idtpmac) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for typeMachine");
		try {
			typeMachineDAO.delete(idtpmac);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for typeMachine " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
