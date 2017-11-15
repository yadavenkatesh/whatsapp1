package com.controllers;

import org.apache.log4j.Logger;

public class Test {

	final static Logger logger = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
	
		logger.warn("warning message1");//
		logger.info("information message2");
		logger.fatal("fatal meessage3");
		logger.debug("debug message4");//
		logger.info("information message5");
		logger.warn("warning message6");//
		logger.error("error message7");//catch block
		logger.fatal("fatal meessage8");
		logger.debug("debug message9");//
		
		System.out.println("Debug message");
		System.out.println("information message");
		System.out.println("waring message");
		System.out.println("error message");
		System.out.println("fatal message");
	}
}
