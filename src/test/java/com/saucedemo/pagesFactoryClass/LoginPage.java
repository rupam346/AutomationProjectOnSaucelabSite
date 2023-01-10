package com.saucedemo.pagesFactoryClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.basepackage.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;

	@FindBy(className = "title")
	private WebElement productText;

	public WebElement getUserName() {
		return usernameField;
	}

	public WebElement getPassword() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getProductText() {
		return productText;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}
}
