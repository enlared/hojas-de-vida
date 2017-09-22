package com.nova.MsHv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MsHv.dao.CategoryDAO;
import com.nova.MsHv.dto.Category;
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
 * @author enlaRed.co
 * @version 1.0
 */
public class CategoryRestController {
	static final Logger log = Logger.getLogger(CategoryRestController.class);
	@Autowired
	CategoryDAO categoryDAO;



	@RequestMapping("category/find/{id}")
	@ResponseBody

	public Category getCategory(@PathVariable("id") long idctg) throws NovaHVDaoException {
		Category category = new Category();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in category");
		try {

			category = categoryDAO.findByIdctg(idctg);
			if (!category.equals(null)) {

				log.info("Log4j get the author with category ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for category " + e);
			throw new NovaHVDaoException(e);

		}

		return category;
	}

	
	
	@RequestMapping("category/findall")
	@ResponseBody
	public List<Category> getCategoryAll() throws NovaHVDaoException {
		List<Category> category = new ArrayList<Category>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for category");
		try {

			category = categoryDAO.findAll();
			if (category.equals(null)) {

				log.info("Log4j get the list category ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for category" + e);
			throw new NovaHVDaoException(e);

		}

		return category;
	}

	
	@RequestMapping(value = "category/save", method = RequestMethod.POST)
	@ResponseBody
	public void setCategory(@RequestBody Category category) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for category");
		try {
			categoryDAO.save(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for category" + e);
			throw new NovaHVRestException(e);

		}

	}


	@RequestMapping(method = RequestMethod.PUT, path = "category/edit/{id}")
	@ResponseBody

	public void editCategory(@PathVariable("id") long idctg, @RequestBody Category category) throws NovaHVRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for category");
		try {
			categoryDAO.save(category);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for category " + e);
			throw new NovaHVRestException(e);
		}

	}



	@RequestMapping(method = RequestMethod.DELETE, path = "category/delete/{id}")
	@ResponseBody
	public void getDeleteCategory(@PathVariable("id") long idctg) throws NovaHVDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for category");
		try {
			categoryDAO.delete(idctg);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for category " + e);
			throw new NovaHVDaoException(e);
		}

	}


}
