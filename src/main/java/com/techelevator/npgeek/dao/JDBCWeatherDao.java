package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;

@Component
public class JDBCWeatherDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherForPark(String code) {
		String sqlGetWeatherForPark = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetWeatherForPark, code);
		List<Weather> weather = new ArrayList<Weather>();
		
		while(result.next()) {
			Weather thisWeather = new Weather(result.getString("parkcode"),
											 result.getInt("fivedayforecastvalue"),
											 result.getInt("low"),
											 result.getInt("high"),
											 result.getString("forecast"));
			weather.add(thisWeather);
		}
		
		return weather;
		
	}

}
