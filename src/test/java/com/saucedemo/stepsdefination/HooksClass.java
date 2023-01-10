package com.saucedemo.stepsdefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.saucedemo.basepackage.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass {	
	private static Scenario scenario;
	
	public static Scenario getScenario() {
		return scenario;
	}
	
	@Before
	public void setUp() {
		BaseClass.readPropertyFile();
		BaseClass.Build();
	}
	
	@AfterStep
	public void addScreenShotAndLog(Scenario scenario) throws IOException {
		this.scenario = scenario;
		try {
			File src = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			scenario.attach(fileContent, "image/png", "image");
			scenario.log("Executed Line Number: " + scenario.getLine() + "\n" + " In Source Tag : "
					+ scenario.getSourceTagNames());
		} catch (NoSuchSessionException noSuchSessionException) {
			System.out.println("Caught noSuchSessionException");
		} catch (NoSuchWindowException noSuchWindowException) {
			System.out.println("Caught NoSuchWindowException");
		}
	}
	
	@After
	public  void tearDown() {
		BaseClass.driver.quit();
		scenario.log("The browser is closed");
	}
}
