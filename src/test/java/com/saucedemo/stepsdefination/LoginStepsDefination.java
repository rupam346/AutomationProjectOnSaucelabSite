package com.saucedemo.stepsdefination;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.methodClass.LoginMethodClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepsDefination{
	LoginMethodClass loginMethod;

	@Given("User is on SwagLabs Page")
	public void user_is_on_swag_lab_page() {
		loginMethod = new LoginMethodClass();
	}

	@Given("User enters username and password and user clicks on Login button")
	public void user_enter_username_and_password_and_user_click_on_Login_button() {
		loginMethod.enterUserNameAndPassword(BaseClass.prop.getProperty("userName"),
				BaseClass.prop.getProperty("password"));
		loginMethod.clickLoginButton();
	}

	@Then("User must be in products page")
	public void user_must_be_in_products_page() {
		boolean flag = false;

		try {
			if (loginMethod.productTextIsDisplayed()) {
				Assert.assertTrue(loginMethod.productTextIsDisplayed());
				HooksClass.getScenario().log("    USER SUCCESFULLY LOGGED IN    ");
				flag = true;
			}
		} catch (NoSuchElementException noSuchElementException) {
			noSuchElementException.printStackTrace();
		}
		if (flag == false) {
			Assert.assertTrue(loginMethod.checkErrorMessage());
			HooksClass.getScenario().log("    LOGIN ERROR MESSAGE IS DISPLAYED    ");
			HooksClass.getScenario().log("    PLEASE ENTER CORRECT USERNAME AND PASSWORD    ");
			Assert.assertTrue(false); //wrong
		}
	}
}
