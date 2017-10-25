package com.techelevator.npgeek.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;

@Component
public interface SurveyDao {
	public void addSurveyToDb(String parkcode, String emailaddress, String state, String activitylevel);
	public List<Park> getMostPopularParks();
}
