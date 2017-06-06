/**
 * DMA - Data Management System. 
 * Copyright © 2013 DMA. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF DMA. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF DMA.
 */
package com.dma.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description: 
 * Name of Project: dma
 * Created on: Jul 18, 2013
 * Modified on: Jul 18, 2013 4:19:38 PM
 * @author rsingh4
 * Version: 
 */
@Controller
public class ControllerHome {

	private static final Logger LOGGER = Logger.getLogger(ControllerHome.class);

	
	/**
	 * Description:Getting Application Home Page
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		LOGGER.info("Application's home page view");

		System.out.println("Inside Home Page View");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	/**
	 * Description:
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {

		LOGGER.info("Application's welcome page view");

		System.out.println("Inside welcome Page View");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;
	}
	/**
	 * Description:
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelMap model) {
		
		LOGGER.info("Application's login failure due to invalid credentials");
 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		model.addAttribute("error", "true");
		return modelAndView;
 
	}
}