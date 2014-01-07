package com.inflinx.spring4.web.handler;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/*
	 * ############### Define specific exception handlers here ###############
	 */
	
	// Catch all exception handler
	@ExceptionHandler({ Exception.class })
    public ModelAndView  defaultExceptionHandler(Exception exception) 
	{
		// Create correlation id
		String errorId = RandomStringUtils.randomNumeric(6);
		
		// Log the error
		logger.error("An error has occured in the application. Reference Id: " + errorId ,exception);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exception");
		mav.addObject("errorId", errorId);
		
		return mav;
    }
}
