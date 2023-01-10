package com.saucedemo.pagesFactoryClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.basepackage.BaseClass;

public class NavigationPage  extends BaseClass{

	public NavigationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='nav-menu']//a[@class='link'][contains(text(), 'Resources')]")
	private WebElement resourceTab;

	@FindBy(xpath = "//div[@class='nav-menu-link-group-row-list-wrapper']//span[contains(text(),'Documentation')]")
	private WebElement documentationLink;

	@FindBy(xpath = "//h1[@class='hero__title']")
	private WebElement sauceLabDocumentationHeading;

	public WebElement getResourceTab() {
		return resourceTab;
	}

	public WebElement getDocumentationLink() {
		return documentationLink;
	}

	public WebElement getSauceLabDocumentationHeading() {
		return sauceLabDocumentationHeading;
	}
}
