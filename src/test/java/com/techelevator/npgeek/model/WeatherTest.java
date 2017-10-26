package com.techelevator.npgeek.model;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherTest {
	
	private Weather w;
	
	@Before
	public void setup() {
		w = new Weather("CVNP", 1, 10, 20, "rain");
	}
	
	@Test
	public void constructor_works() {
		
		Assert.assertEquals("CVNP", w.getParkCode());
		Assert.assertEquals(1, w.getFiveDayValue());
		Assert.assertEquals(10, w.getLow());
		Assert.assertEquals(20, w.getHigh());
		Assert.assertEquals("rain", w.getForecast());
	}
	
	@Test
	public void setParkCode_works() {
		w.setParkCode("YNP");
		Assert.assertEquals("YNP", w.getParkCode());
	}
	
	@Test
	public void setFiveDayValue_works() {
		w.setFiveDayValue(4);
		Assert.assertEquals(4, w.getFiveDayValue());
	}
	
	@Test
	public void setLow_works() {
		w.setLow(30);
		Assert.assertEquals(30, w.getLow());
	}
	
	@Test
	public void setHigh_works() {
		w.setHigh(100);
		Assert.assertEquals(100, w.getHigh());
	}
	
	@Test
	public void setForecast_works() {
		w.setForecast("thunderstorms");
		Assert.assertEquals("thunderstorms", w.getForecast());
	}
	
	@Test
	public void getImageUrl_works_with_partly_cloudy() {
		w.setForecast("partly cloudy");
		Assert.assertEquals("partlyCloudy.png", w.getImageUrl());
	}
	
	@Test
	public void getImageUrl_works_with_single_word_forecast() {
		w.setForecast("rain");
		Assert.assertEquals("rain.png", w.getImageUrl());
	}
	
	@Test
	public void getDayOfWeek_works_day_2() {
		w.setFiveDayValue(2);
		Assert.assertEquals("Tomorrow", w.getDayOfWeek());
	}
	
	@Test
	public void getDayOfWeek_works_day_3() {
		Clock c = Clock.fixed(Instant.parse("2017-10-26T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(3);
		Assert.assertEquals("Saturday", w.getDayOfWeek(c));
	}
	
	@Test
	public void getDayOfWeek_works_day_4() {
		Clock c = Clock.fixed(Instant.parse("2017-10-26T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(4);
		Assert.assertEquals("Sunday", w.getDayOfWeek(c));
	}
	
	@Test
	public void getDayOfWeek_works_day_5() {
		Clock c = Clock.fixed(Instant.parse("2017-10-26T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(5);
		Assert.assertEquals("Monday", w.getDayOfWeek(c));
	}
	
	@Test
	public void getDayOfWeek_works_day_2_from_sunday() {
		Clock c = Clock.fixed(Instant.parse("2017-10-29T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(2);
		Assert.assertEquals("Tomorrow", w.getDayOfWeek(c));
	}
	
	@Test
	public void getDayOfWeek_works_day_3_from_sunday() {
		Clock c = Clock.fixed(Instant.parse("2017-10-29T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(3);
		Assert.assertEquals("Tuesday", w.getDayOfWeek(c));
	}
	@Test
	public void getDayOfWeek_works_day_4_from_sunday() {
		Clock c = Clock.fixed(Instant.parse("2017-10-29T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(4);
		Assert.assertEquals("Wednesday", w.getDayOfWeek(c));
	}
	@Test
	public void getDayOfWeek_works_day_5_from_sunday() {
		Clock c = Clock.fixed(Instant.parse("2017-10-29T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(5);
		Assert.assertEquals("Thursday", w.getDayOfWeek(c));
	}
	@Test
	public void getDayOfWeek_works_day_5_from_monday() {
		Clock c = Clock.fixed(Instant.parse("2017-10-30T06:00:00Z"), ZoneOffset.systemDefault());
		w.setFiveDayValue(5);
		Assert.assertEquals("Friday", w.getDayOfWeek(c));
	}
	
	@Test
	public void getRecommendation_works_with_snow() {
		w.setForecast("snow");
		Assert.assertTrue(w.getRecommendation().contains("Pack your snow shoes!"));
	}
	
	@Test
	public void getRecommendation_works_with_rain() {
		w.setForecast("rain");
		Assert.assertTrue(w.getRecommendation().contains("Pack your rain gear and wear waterproof shoes."));
	}
	
	@Test
	public void getRecommendation_works_with_thunderstorms() {
		w.setForecast("thunderstorms");
		Assert.assertTrue(w.getRecommendation().contains("SEEK SHELTER! AVOID HIKING ON EXPOSED RIDGES!"));
	}
	
	@Test
	public void getRecommendation_works_with_sun() {
		w.setForecast("sun");
		Assert.assertTrue(w.getRecommendation().contains("Pack sunblock."));
	}
	
	@Test
	public void getRecommendation_works_with_high_over_75() {
		w.setHigh(76);
		Assert.assertTrue(w.getRecommendation().contains("Bring an extra gallon of water."));
	}
	
	@Test
	public void getRecommendation_works_with_20_degree_diff_between_low_and_high() {
		w.setHigh(76);
		w.setLow(0);
		Assert.assertTrue(w.getRecommendation().contains("Wear breathable layers."));
	}
	
	@Test
	public void getRecommendation_works_with_low_below_20() {
		w.setLow(0);
		Assert.assertTrue(w.getRecommendation().contains("BEWARE THE DANGERS OF EXPOSURE TO FRIGID TEMPERATURES!"));
	}
	
	@Test
	public void getRecommendation_works_with_empty_recommendation() {
		w = new Weather("CVNP", 1, 30, 35, "partly cloudy");
		Assert.assertTrue(w.getRecommendation().equals("Today is a perfect day to visit!"));
	}
}
