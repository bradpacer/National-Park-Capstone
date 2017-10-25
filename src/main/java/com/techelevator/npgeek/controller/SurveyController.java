package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.SurveyDao;

@Controller
public class SurveyController {
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	SurveyDao surveyDao;
	
	@RequestMapping(path= "/survey", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		request.setAttribute("parkList", parkDao.getAllParks());
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String updateUnits(@RequestParam String park, @RequestParam String email, @RequestParam String state, @RequestParam String activity) {
		surveyDao.addSurveyToDb(park, email, state, activity);
		
		return "redirect:/surveyResult";
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String showSurveyResults(HttpServletRequest request) {
		request.setAttribute("topParks", surveyDao.getMostPopularParks());
		return "surveyResult";
	}
}
