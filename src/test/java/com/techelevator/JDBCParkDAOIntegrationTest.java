package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.dao.JDBCParkDao;
import com.techelevator.npgeek.model.Park;



public class JDBCParkDAOIntegrationTest {
		
	private static SingleConnectionDataSource dataSource;
	private JDBCParkDao dao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
	
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertPark = "INSERT INTO park(parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, numberOfCampsites, climate, yearFounded, annualVisitorCount, inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies) VALUES ('XYZ', 'Yeti', 'Ohio', 32832, 696, 125, 0, 'Woodland', 2000, 2189849, 'Of all the paths you take in life, make sure a few of them are dirt.', 'John Muir', 'Though a short distance', 0, 390)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertPark);
		dao = new JDBCParkDao(getDataSource());
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void returns_all_parks() {
		
		List<Park> result = dao.getAllParks();
		
		assertNotNull(result);
		assertEquals(11, result.size());
		
	}
	
	@Test
	public void returns_park_by_park_code() {
		
		Park result = dao.getParkByCode("XYZ");
		
		assertNotNull(result);
		assertEquals("XYZ", result.getParkCode());
	}
}



























