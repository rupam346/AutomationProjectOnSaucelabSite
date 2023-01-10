package com.saucedemo.pagesFactoryClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.basepackage.BaseClass;

public class HoverPage extends BaseClass {
	
	public HoverPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuButton;

	@FindBy(css = "#about_sidebar_link")
	private WebElement aboutOption;

	@FindBy(xpath = "//div[@class='nav-menu']//a[@class='link'][contains(text(),'Contact')]")
	private WebElement contactElement;
	
	@FindBy(xpath = "//div[@class='nav-menu-link-group-row-list-wrapper']//span[contains(text(),'Contact Sales')]")
	private WebElement contactSalesPage;

	@FindBy(css = "input[name=Product_Interest__c]+ label")  //+adjacent sibling
	private static List<WebElement> interestCheckboxes;
	
	public WebElement getMenuButton() {
		return menuButton;
	}

	public WebElement getAboutOption() {
		return aboutOption;
	}

	public WebElement getContactElement() {
		return contactElement;
	}

	public WebElement getContactSalesPage() {
		return contactSalesPage;
	}

	public List<WebElement> getInterestCheckBoxes() {
		return interestCheckboxes;
	}
	
}
