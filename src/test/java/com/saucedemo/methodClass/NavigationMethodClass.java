package com.saucedemo.methodClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.pagesFactoryClass.NavigationPage;

public class NavigationMethodClass extends BaseClass{
	NavigationPage navigationPage = new NavigationPage();
	String parentWindow;

	//Method to hover on resource tab
	public void hoverResourceTab() {
		Actions action = new Actions(driver);
		action.moveToElement(navigationPage.getResourceTab()).perform();
	}

	//Method to click on documentation link 
	public void clickDocumentationOption() {
		navigationPage.getDocumentationLink().click();
	}

	//Method to switch driver to child tab
	public void switchToChildTab() {
		
		if(driver.getWindowHandles().size() > 1) {
			parentWindow = driver.getWindowHandle();
			Set<String> windowHandles = null;
			windowHandles = driver.getWindowHandles();
			for (String a : windowHandles) {
				if (!a.equals(parentWindow)) {
					driver.switchTo().window(a);
				}
			}
		} else {
			switchToChildTab();
		}
	}

	//Method to switch driver back to parent window
	public void switchToParentWindow() {
		driver.switchTo().window(parentWindow);
	}

	//Method to context click on documentation link 
	public void rightClick() throws AWTException {
		Actions action = new Actions(driver);
		action.contextClick(navigationPage.getDocumentationLink()).perform();
	
		robotEvent(2,KeyEvent.VK_DOWN);
		robotEvent(KeyEvent.VK_ENTER);
	}

	//Method to return sauceLabsDocumentationText from documentation page
    public String getSauceLabsDocumentationText() {
    	return navigationPage.getSauceLabDocumentationHeading().getText();
    }
    
    //Method to perform keyboard actions
	public void robotEvent(int keyCode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);
	}
	
	public void robotEvent(int noOfTimes , int keyCode) throws AWTException {
		for(int i =0; i<noOfTimes ; i++) {
			robotEvent(keyCode);
		}
	}
}
