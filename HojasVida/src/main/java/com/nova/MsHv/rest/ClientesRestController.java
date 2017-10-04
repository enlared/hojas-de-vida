package com.nova.MsHv.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.ClienteDAO;
import com.nova.MsHv.entidad.Cliente;
import com.nova.MsHvExcepciones.NovaHVDaoException;
import com.nova.MsHvExcepciones.NovaHVRestException;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @customers enlaRed.co
 * @version 1.0
 */
public class ClientesRestController {
	static final Logger log = Logger.getLogger(ClientesRestController.class);
	@Autowired
	ClienteDAO clienteDAO;

	
	
	@RequestMapping("clientes/findAll")
	@ResponseBody
	public List<Cliente> getCustomersAll() throws NovaHVDaoException {
		List<Cliente> customers = new ArrayList<>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for Cliente");
		try {

			customers = clienteDAO.findAll();
		} catch (Exception e) {
			log.error("Log4j Error in method Find All for Cliente" + e);
			throw new NovaHVDaoException(e);

		}

		return customers;
	}

	@RequestMapping(value = "clientes/consultarSap", method = RequestMethod.POST)
	@ResponseBody
	public Cliente consultarSap(@RequestBody Cliente cliente) throws NovaHVRestException {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for clientes");
		 List<Cliente> var= new ArrayList<>();
		try {
			 var = clienteDAO.findByCodigosap(cliente.getCodigosap());
		} catch (Exception e) {
			log.error("Log4j Error in method Save for Cliente " + e);
			throw new NovaHVRestException(e);

		}
		return !var.isEmpty()? var.get(0):null;
	}

	
	
	@RequestMapping(value = "clientes/save", method = RequestMethod.POST)
	@ResponseBody
	public void setCustomers(@RequestBody Cliente cliente) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for clientes");
		try {
			clienteDAO.save(cliente);
		} catch (Exception e) {
			log.error("Log4j Error in method Save for Cliente " + e);
			throw new NovaHVRestException(e);

		}

	}

	

	@RequestMapping(method = RequestMethod.PUT, path = "customers/edit/{id}")
	@ResponseBody

	public void editCustomers(@PathVariable("id") long idadtcst, @RequestBody Cliente clientes) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for clientes");
		try {
			clienteDAO.save(clientes);

		} catch (Exception e) {
			log.error("Log4j Error in method Update for clientes " + e);
			throw new NovaHVRestException(e);
		}

	}

	
	@RequestMapping(method = RequestMethod.DELETE, path = "clientes/delete/{id}")
	@ResponseBody
	public void getDeleteCustomers(@PathVariable("id") long codsap) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for Cliente");
		try {
			clienteDAO.delete(codsap);
		} catch (Exception e) {
			log.error("Log4j Error in method Delete for clientes " + e);
			throw new NovaHVDaoException(e);
		}

	}


}

