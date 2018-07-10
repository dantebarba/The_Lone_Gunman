package ar.edu.unlp.lifia.grupo2.controller;

import org.springframework.web.servlet.ModelAndView;

public class Resources {
	public static final String BASE_URL = "http://localhost:9090/The_Lone_Gunman";
	
	public static ModelAndView errorHandling(Exception e) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", e.getClass()+" "+ e.getMessage());
		mav.addObject("alertClass", "alert-danger");
		return mav;
	}
	
}
