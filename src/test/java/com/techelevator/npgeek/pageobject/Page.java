package com.techelevator.npgeek.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {
	private WebDriver webDriver;

	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void clickParkLink(String parkName) {
		WebElement link = webDriver.findElement(By.linkText(parkName));
		link.click();
	}

	public void goToGivenPage(String name) {
		WebElement link = webDriver.findElement(By.linkText(name));
		link.click();	
	}

	public void switchToCelsius() {
		Select dropdown = new Select(webDriver.findElement(By.tagName("select")));
		dropdown.selectByVisibleText("Celsius");
	}

	public void clickUpdate() {
		WebElement updateButton = webDriver.findElement(By.id("unit-form-submit"));
		updateButton.click();
	}

	public boolean isOn(String name) {
		String title = webDriver.getTitle();
		return name.equalsIgnoreCase(title);
	}

	public boolean isCelsius() {
		WebElement temp = webDriver.findElement(By.cssSelector(".today-weather p"));
		String tempText = temp.getText();
		String unit = tempText.substring(tempText.length() - 2);
		return (unit.equals("C"));
	}

	public void choosePark(String park) {
		Select dropdown = new Select(webDriver.findElement(By.name("park")));
		dropdown.selectByVisibleText(park);
	}

	public void enterEmail(String email) {
		WebElement emailField = webDriver.findElement(By.name("email"));
		emailField.sendKeys(email);
	}

	public void chooseState(String state) {
		Select dropdown = new Select(webDriver.findElement(By.name("state")));
		dropdown.selectByVisibleText(state);
	}

	public void chooseActivity(String activity) {
		WebElement activityButton = webDriver.findElement(By.id(activity));
		activityButton.click();	}

	public void submitSurvey() {
		WebElement submitButton = webDriver.findElement(By.id("unit-form-submit"));
		submitButton.click();
	}

}
