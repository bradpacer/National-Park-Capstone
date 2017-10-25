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
public class JDBCParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		String sqlGetAllParks = "SELECT * from park";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		List<Park> parks = new ArrayList<Park>();
		
		while(result.next()) {
			Park park = new Park();
			park.setParkCode(result.getString("parkcode"));
			park.setName(result.getString("parkname"));
			park.setDescription(result.getString("parkdescription"));
			parks.add(park);
		}
		
		return parks;
	}

	@Override
	public Park getParkByCode(String code) {
		String sqlGetParkByCode = "SELECT * from park where parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetParkByCode, code);
		Park park = new Park();
		
		if (result.next()) {
			park.setParkCode(result.getString("parkcode"));
			park.setName(result.getString("parkname"));
			park.setState(result.getString("state"));
			park.setAcreage(result.getInt("acreage"));
			park.setElevation(result.getInt("elevationinfeet"));
			park.setMilesOfTrail(result.getFloat("milesoftrail"));
			park.setCampsites(result.getInt("numberofcampsites"));
			park.setClimate(result.getString("climate"));
			park.setYearFounded(result.getInt("yearfounded"));
			park.setAnnualVisitorCount(result.getInt("annualvisitorcount"));
			park.setQuote(result.getString("inspirationalquote"));
			park.setQuoteSource(result.getString("inspirationalquotesource"));
			park.setDescription(result.getString("parkdescription"));
			park.setEntryFee(result.getInt("entryfee"));
			park.setNumberOfAnimalSpecies(result.getInt("numberofanimalspecies"));
		}
		return park;
	}

}
