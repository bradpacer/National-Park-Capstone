package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;

@Component
public class JDBCSurveyDao implements SurveyDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addSurveyToDb(String parkcode, String emailaddress, String state,
			String activitylevel) {
		String sqlAddSurveyToDb = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddSurveyToDb, parkcode, emailaddress, state, activitylevel);
	}

	@Override
	public List<Park> getMostPopularParks() {
		String sqlGetMostPopularParks = "SELECT s.parkcode, p.parkname, COUNT(s.parkcode) as parkcount, p.parkdescription " + 
										"FROM survey_result s " + 
										"JOIN park p ON p.parkcode = s.parkcode " + 
										"GROUP BY s.parkcode, p.parkname, p.parkdescription " + 
										"ORDER BY parkcount desc, parkname " + 
										"LIMIT 5";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetMostPopularParks);
		
		List<Park> parks = new ArrayList<Park>();
		while (result.next()) {
			Park park = new Park();
			park.setParkCode(result.getString("parkcode"));
			park.setName(result.getString("parkname"));
			park.setDescription(result.getString("parkdescription"));
			park.setNumberOfSurveys(result.getInt("parkcount"));
			parks.add(park);
		}
		
		return parks;
	}

}
