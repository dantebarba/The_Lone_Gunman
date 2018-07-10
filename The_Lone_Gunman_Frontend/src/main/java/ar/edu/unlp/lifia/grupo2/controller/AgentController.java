package ar.edu.unlp.lifia.grupo2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlp.lifia.grupo2.dto.AgentDto;
import ar.edu.unlp.lifia.grupo2.dto.RankDto;
import ar.edu.unlp.lifia.grupo2.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RestController
public class AgentController {

	private static final String URI = "/agent";

	@RequestMapping(value = "/agent/findAll")
	public ModelAndView getAll() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseDto agentList = restTemplate.getForObject(
					Resources.BASE_URL + AgentController.URI,
					ResponseDto.class);
			ModelAndView mav = new ModelAndView("listAgents");
			mav.addObject("agentList", agentList);
			return mav;
		} catch (Exception e) {
			return Resources.errorHandling(e);
		}
	}

	@RequestMapping(value = "/agent/add", method=RequestMethod.GET)
	public ModelAndView addAgentForm() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			final ResponseEntity<List> rankList = restTemplate.getForEntity(Resources.BASE_URL+"/rank", List.class);
			ModelAndView mav = new ModelAndView("addAgent");
			mav.addObject("agentDto", new AgentDto());
			mav.addObject("rankList", rankList.getBody());
			return mav;
		}
		catch (Exception e) {
			return Resources.errorHandling(e);
		}
	}

	@RequestMapping(value = "/agent/add", method = RequestMethod.POST)
	public ModelAndView addAgent(@ModelAttribute("agentDto") AgentDto agentDto) {
		try {
			MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
			map.add("agent", agentDto);
			RestTemplate restTemplate = new RestTemplate();
			ResponseDto message = restTemplate.postForObject(Resources.BASE_URL
					+ AgentController.URI + "/", map, ResponseDto.class);
			ModelAndView mav = new ModelAndView("addAgent");
			mav.addObject("message", message);
			mav.addObject("alertClass", "alert-success");
			return mav;
		} catch (Exception e) {
			return Resources.errorHandling(e);
		}
	}

}
