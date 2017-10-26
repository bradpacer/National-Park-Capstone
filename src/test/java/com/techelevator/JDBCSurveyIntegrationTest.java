package com.techelevator;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.dao.JDBCSurveyDao;
import com.techelevator.npgeek.dao.JDBCWeatherDao;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

public class JDBCSurveyIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private SurveyDao dao;
	JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@Before
	public void setup() {
		String sqlAddTestPark = "INSERT INTO park ("+
				"parkcode, parkname, state, acreage, elevationinfeet, "+
				"milesoftrail, numberofcampsites, climate, yearfounded, "+
				"annualvisitorcount, inspirationalquote, inspirationalquotesource, "+
				"parkdescription, entryfee, numberofanimalspecies) "+
				"VALUES ("+
				"?, 'Test Park', 'OH', 10, 10, 10, 10, 'temperate', "+
				"2017, 10, 'Do or do not, there is no try', 'Yoda', "+
				"'This is a great description', 10, 10)";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		dao = new JDBCSurveyDao(getDataSource());
		
		for (int i = 1; i <= 5; i++) {
			jdbcTemplate.update(sqlAddTestPark, "WOOT"+i);
		}
		
		for (int i = 1; i <= 5; i++) {
			String parkCode = "WOOT" + i;
			for (int j = i; j < 1000; j++) {
				dao.addSurveyToDb(parkCode, "test@test.com", "OH", "active");
			}
		}
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void constructor_works() {
		Assert.assertNotNull(dao);
	}
	
	@Test
	public void surveys_can_be_added_to_db() {
		for (int i = 1; i <= 5; i++) {
			Assert.assertEquals(1000 - i, countSurveysByParkCode("WOOT"+i));
		}
	}
	
	@Test
	public void canGetMostPopularParks() {
		List<Park> results = dao.getMostPopularParks();
		Assert.assertEquals(5, results.size());
		Assert.assertEquals("WOOT1", results.get(0).getParkCode());
		Assert.assertEquals("WOOT2", results.get(1).getParkCode());
		Assert.assertEquals("WOOT3", results.get(2).getParkCode());
		Assert.assertEquals("WOOT4", results.get(3).getParkCode());
		Assert.assertEquals("WOOT5", results.get(4).getParkCode());
	}
	
	private DataSource getDataSource() {
		return dataSource;
	}
	
	private int countSurveysByParkCode(String parkCode) {
		String sqlCountSurveysByParkCode = "SELECT COUNT(*) FROM survey_result "+
										  "WHERE parkcode = ? GROUP BY parkcode";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlCountSurveysByParkCode, parkCode);
		if (result.next()) {
			return result.getInt(1);
		} else {
			return 0;
		}
	}
}
