package com.techelevator.npgeek.model;

import java.util.Calendar;

public class Weather {
	private String parkCode;
	private int fiveDayValue;
	private int low;
	private int high;
	private String forecast;
	
	public Weather(String parkCode, int fiveDayValue, int low, int high, String forecast) {
		this.parkCode = parkCode;
		this.fiveDayValue = fiveDayValue;
		this.low = low;
		this.high = high;
		this.forecast = forecast;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayValue() {
		return fiveDayValue;
	}
	public void setFiveDayValue(int fiveDayValue) {
		this.fiveDayValue = fiveDayValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	public String getImageUrl() {
		if (forecast.equals("partly cloudy")) {
			return "partlyCloudy.png";
		} else {
			return forecast + ".png";
		}
	}
	
	public String getDayOfWeek() {
		Calendar now = Calendar.getInstance();
		
		// get today's dayOfWeek, add the fiveDayValue offset, then subtract 1 (because today is 1)
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK) + fiveDayValue - 1;
		
		if (fiveDayValue == 2) {
			return "Tomorrow";
		} else if (dayOfWeek % 7 == 1) {
			return "Sunday";
		} else if (dayOfWeek % 7 == 2) {
			return "Monday";
		} else if (dayOfWeek % 7 == 3) {
			return "Tuesday";
		} else if (dayOfWeek % 7== 4) {
			return "Wednesday";
		} else if (dayOfWeek % 7 == 5) {
			return "Thursday";
		} else if (dayOfWeek % 7 == 6) {
			return "Friday";
		} else {
			return "Saturday";
		}
	}

	public String getRecommendation() {
		String recommendation = "";
		
		recommendation += (forecast.equals("snow")) ? "Pack your snow shoes! " : "";
		recommendation += (forecast.equals("rain")) ? "Pack your rain gear and wear waterproof shoes. " : "";
		recommendation += (forecast.equals("thunderstorms")) ? "SEEK SHELTER! AVOID HIKING ON EXPOSED RIDGES! " : "";
		recommendation += (forecast.equals("sun")) ? "Pack sunblock. " : "";
		recommendation += (high > 75) ? "Bring an extra gallon of water. " : "";
		recommendation += (high - low > 20) ? "Wear breathable layers. " : "";
		recommendation += (low < 20) ? "BEWARE THE DANGERS OF EXPOSURE TO FRIGID TEMPERATURES! " : "";
		recommendation += (recommendation.length() == 0) ? "Today is a perfect day to visit!" : "";
		
		return recommendation;
	}
}
