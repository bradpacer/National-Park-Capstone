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

import com.techelevator.npgeek.dao.JDBCWeatherDao;
import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Weather;

public class JDBCWeatherIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private WeatherDao dao;
	
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
				"'WOOT', 'Test Park', 'OH', 10, 10, 10, 10, 'temperate', "+
				"2017, 10, 'Do or do not, there is no try', 'Yoda', "+
				"'This is a great description', 10, 10)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlAddTestPark);
		String sqlAddWeather = "INSERT INTO weather (parkcode, fivedayforecastvalue, "+
							   "low, high, forecast) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddWeather, "WOOT", 1, 10, 20, "sunny");
		jdbcTemplate.update(sqlAddWeather, "WOOT", 2, 35, 50, "snow");
		jdbcTemplate.update(sqlAddWeather, "WOOT", 3, 41, 63, "rain");
		jdbcTemplate.update(sqlAddWeather, "WOOT", 4, 30, 31, "thunderstorm");
		jdbcTemplate.update(sqlAddWeather, "WOOT", 5, 90, 100, "partly cloudy");
		dao = new JDBCWeatherDao(getDataSource());
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
	public void getWeatherForPark_works() {
		List<Weather> wl = dao.getWeatherForPark("WOOT");
		Assert.assertEquals(5, wl.size());
		Assert.assertEquals("sunny", wl.get(0).getForecast());
		Assert.assertEquals("snow", wl.get(1).getForecast());
		Assert.assertEquals("rain", wl.get(2).getForecast());
		Assert.assertEquals("thunderstorm", wl.get(3).getForecast());
		Assert.assertEquals("partly cloudy", wl.get(4).getForecast());
	}
	
	private DataSource getDataSource() {
		return dataSource;
	}
}
