package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.model.Park;

@Controller
public class HomeController {
	
	@Autowired
	ParkDao dao;
	
	@RequestMapping(path= {"/", "/home"}, method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		request.setAttribute("parkList", dao.getAllParks());
		return "home";
	}
}
