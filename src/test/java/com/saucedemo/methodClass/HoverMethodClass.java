package com.saucedemo.methodClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.pagesFactoryClass.HoverPage;

public class HoverMethodClass extends BaseClass {
	HoverPage hoverPage = new HoverPage();
	
	static String interest[];
	public static List<String> interestList;

	// Method to click menu button in cart page
	public void clickMenuButton() {
		hoverPage.getMenuButton().click();
	}

	// Method to select about inside menu option
	public void selectAboutOption() {
		hoverPage.getAboutOption().click();
	}

	// Method to hover on tabs
	public void hoverActionMethod() {
		Actions action = new Actions(BaseClass.driver);
		action.moveToElement(hoverPage.getContactElement()).perform();
		hoverPage.getContactSalesPage().click();
	}

	// Method to select type of interest by selecting checkbox
	public void selectInterest() {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver , Duration.ofSeconds(20));
		
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		splitsname();
		for (int i = 0; i < hoverPage.getInterestCheckBoxes().size(); i++) {
			for (String s1 : interestList) {
				if (hoverPage.getInterestCheckBoxes().get(i).getText().equalsIgnoreCase(s1)) {
					js.executeScript("arguments[0].scrollIntoView(true);", hoverPage.getInterestCheckBoxes().get(i));
					wait.until(ExpectedConditions.elementToBeClickable(hoverPage.getInterestCheckBoxes().get(i)));
					js.executeScript("arguments[0].click();", hoverPage.getInterestCheckBoxes().get(i));
				}
			}
		}
	}

	// Method to return contact text from about page
	public String getContactElementText() {
		return hoverPage.getContactElement().getText();
	}

	//Method to splits name from properties file
	public static void splitsname() {
		interest = BaseClass.prop.getProperty("testing").split(",");
		interestList = new ArrayList<String>();
		for (String s1 : interest) {
			interestList.add(s1.trim());
		}
	}
	
}
