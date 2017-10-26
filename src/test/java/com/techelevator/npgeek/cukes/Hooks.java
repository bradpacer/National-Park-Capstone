package com.techelevator.npgeek.cukes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Hooks {

	private static @Autowired WebDriver webDriver;

	@BeforeClass
	public static void openWebBrowserForTesting() {

		String homeDir = System.getProperty("user.home");

		System.setProperty("webdriver.chrome.driver", homeDir + "/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void setup() {
		webDriver.manage().deleteAllCookies();
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}

	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}

	@Given("^I am on the home page$")
	public void goToTheHomePage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}

	@When("^ I click on the (.*) link$")
	public void clickOnParkLink(String parkName) {
		page.clickParkLink(parkName);
	}

	@Then("^I am on the (.*) page$")
	public void onGivenPage(String name) {
		Assert.assertTrue("Should be on the selected page", page.isOn(name));
	}

	@Given("^I am on the (.*) page$")
	public void onTheGivenPage(String name) {
		page.goToGivenPage(name);
	}

	@When("^I select celsius from the choose a unit$")
	public void chooseAUnit() {
		page.switchToCelsius();
	}

	@When("^I click update$")
	public void clickUpdate() {
		page.clickUpdate();
	}

	@Then("^The temperature is in celsius$")
	public void tempInCelsius() {
		Assert.assertTrue("temperature should be in celsius", page.isCelsius());
	}

	@When("^I choose (.*)$")
	public void selectGlacierPark(String parkName) {
		page.choosePark(parkName);
	}

	@When("^I enter the email (.*) $")
	public void enterEmail(String email) {
		page.choosePark(email);
	}

	@When("^I choose the state (.*)$")
	public void chooseState(String state) {
		page.choosePark(state);

	}
	
	@When("^I choose the activity level (.*)$")
	public void chooseActivityLevel(String activityLevel) {
		page.choosePark(activityLevel);
	}
	
	@When("^I click submit$")
	public void clickSubmit() {
		page.clickSubmit();
	}
	

}






















