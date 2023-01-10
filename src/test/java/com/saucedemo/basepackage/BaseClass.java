package com.saucedemo.basepackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;          

	public static void readPropertyFile() {
		try {
			prop = new Properties();
			FileReader fis = new FileReader(".\\src\\test\\resources\\com\\configuration\\configuration.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Build() {
		String browserName = prop.getProperty("browserName");
		String url = prop.getProperty("url");
        
		if (browserName.equalsIgnoreCase("chrome")) {         
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("me")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else {
			System.out.println("Check browser name");
		}
		driver.manage().window().maximize();                 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
