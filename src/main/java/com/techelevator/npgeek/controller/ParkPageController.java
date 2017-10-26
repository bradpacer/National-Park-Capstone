package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

@Controller
@SessionAttributes("unitCharacter")
public class ParkPageController {
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
	
	@RequestMapping(path= "/park", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request, @RequestParam String code, ModelMap model) {
		Park park = parkDao.getParkByCode(code);
		request.setAttribute("park", park);
		
		List<Weather> weather = weatherDao.getWeatherForPark(code);
		request.setAttribute("todaysWeather", weather.get(0));
		weather.remove(0);
		request.setAttribute("futureWeather", weather);
		
		if (!model.containsKey("unitCharacter")) {
			model.addAttribute("unitCharacter", "F");
		}
		return "park";
	}
	
	@RequestMapping(path="/setUnit", method=RequestMethod.POST)
	public String updateUnits(@RequestParam String unit, @RequestParam String code, ModelMap model, HttpServletRequest request, RedirectAttributes attrs) {
		if (unit.equals("c")) {
			model.addAttribute("unitCharacter", "C");
		} else {
			model.addAttribute("unitCharacter", "F");
		}
		
		attrs.addAttribute("code", code);
		return "redirect:/park";
	}
}
