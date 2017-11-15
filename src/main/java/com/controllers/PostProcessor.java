package com.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {

	 public Object postProcessBeforeInitialization(Object bean, String beanName) 
		      throws BeansException {
		      
		      System.out.println("BeforeInitialization : " + beanName);
		      return bean;  // you can return any other object as well
		   }
		   public Object postProcessAfterInitialization(Object bean, String beanName) 
		      throws BeansException {
		      
		      System.out.println("AfterInitialization : " + beanName);
		      return bean;  // you can return any other object as well
		   }
}
