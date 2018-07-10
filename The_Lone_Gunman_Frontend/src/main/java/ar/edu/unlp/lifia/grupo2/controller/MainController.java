package ar.edu.unlp.lifia.grupo2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
@RequestMapping
public class MainController {
	
	@RequestMapping(value = "/index")
	public ModelAndView helloWorld(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("index");
		model.addObject("message", "Bienvenido usuario");
		model.addObject("alertClass", "alert-info");
		return model;
	}
}
