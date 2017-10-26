package com.techelevator.npgeek.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkTest {
	private Park p;
	
	@Before
	public void setup() {
		p = new Park();
	}
	
	@Test
	public void parkCode_getters_setters() {
		p.setParkCode("CVNP");
		Assert.assertEquals("CVNP", p.getParkCode());
	}
	
	@Test
	public void name_getters_setters() {
		p.setName("Cuyahoga Valley");
		Assert.assertEquals("Cuyahoga Valley", p.getName());
	}
	
	@Test
	public void state_getters_setters() {
		p.setState("OH");
		Assert.assertEquals("OH", p.getState());
	}
	
	@Test
	public void acreage_getters_setters() {
		p.setAcreage(100);
		Assert.assertEquals(100, p.getAcreage());
	}
	
	@Test
	public void elevation_getters_setters() {
		p.setElevation(100);
		Assert.assertEquals(100, p.getElevation());
	}
	
	@Test
	public void milesOfTrail_getters_setters() {
		p.setMilesOfTrail(300.9);
		Assert.assertEquals(300.9, p.getMilesOfTrail(), 0);
	}
	
	@Test
	public void campsites_getters_setters() {
		p.setCampsites(1000);
		Assert.assertEquals(1000, p.getCampsites());
	}
	
	@Test
	public void climate_getters_setters() {
		p.setClimate("temperate");
		Assert.assertEquals("temperate", p.getClimate());
	}
	
	@Test
	public void yearFounded_getters_setters() {
		p.setYearFounded(2017);
		Assert.assertEquals(2017, p.getYearFounded());
	}
	
	@Test
	public void annualVisitorCount_getters_setters() {
		p.setAnnualVisitorCount(0);
		Assert.assertEquals(0, p.getAnnualVisitorCount());
	}
	
	@Test
	public void quote_getters_setters() {
		p.setQuote("That's just, like, your opinion, man.");
		Assert.assertEquals("That's just, like, your opinion, man.", p.getQuote());
	}
	
	@Test
	public void quoteSource_getters_setters() {
		p.setQuoteSource("The Dude");
		Assert.assertEquals("The Dude", p.getQuoteSource());
	}
	
	@Test
	public void description_getters_setters() {
		p.setDescription("This is the description");
		Assert.assertEquals("This is the description", p.getDescription());
	}
	
	@Test
	public void entryFee_getters_setters() {
		p.setEntryFee(10);
		Assert.assertEquals(10, p.getEntryFee());
	}
	
	@Test
	public void numberOfAnimalSpecies_getters_setters() {
		p.setNumberOfAnimalSpecies(10);
		Assert.assertEquals(10, p.getNumberOfAnimalSpecies());
	}
	
	@Test
	public void numberOfSurveys_getters_setters() {
		p.setNumberOfSurveys(10);
		Assert.assertEquals(10, p.getNumberOfSurveys());
	}
	
	@Test
	public void getImageUrl_works() {
		p.setParkCode("WOOT");
		Assert.assertEquals("woot.jpg", p.getImageUrl());
	}
}
