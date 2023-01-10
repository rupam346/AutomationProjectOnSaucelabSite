package com.saucedemo.methodClass;

import com.saucedemo.pagesFactoryClass.LoginPage;

public class LoginMethodClass {
 	LoginPage loginPage = new LoginPage(); 
	
	//Method to enter username and password
	public void enterUserNameAndPassword(String username, String passWord) {
       	loginPage.getUserName().sendKeys(username);
		loginPage.getPassword().sendKeys(passWord); 
	}

	//Method to click login button
	public void clickLoginButton(){
		loginPage.getLoginButton().click(); 
	}
 
	//Method to verify login error message
	public boolean checkErrorMessage() {
		return loginPage.getErrorMessage().isDisplayed();
	}
	
	//Method to check presence of product text(returns boolean value)
	public boolean productTextIsDisplayed() {
		return loginPage.getProductText().isDisplayed();
	}
}
