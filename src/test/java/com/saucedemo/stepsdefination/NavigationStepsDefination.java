package com.saucedemo.stepsdefination;

import java.awt.AWTException;

import org.junit.Assert;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.methodClass.HoverMethodClass;
import com.saucedemo.methodClass.NavigationMethodClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationStepsDefination {
	NavigationMethodClass navigationMethod;
	HoverMethodClass hoverMethod = new HoverMethodClass();

	@When("User is in About page")
	public void user_is_in_about_page() {
		navigationMethod = new NavigationMethodClass();
	}

	@When("User hovers to Resource tab")
	public void user_hover_to_resource_tab() throws InterruptedException {
		navigationMethod.hoverResourceTab();
	}

	@And("User clicks on Documention option")
	public void user_click_on_documention_option() throws InterruptedException {
		navigationMethod.clickDocumentationOption();
	}

	@Then("User must be in Documentation Page in a New tab")
	public void user_must_be_in_documentation_page_in_a_new_tab() {
		navigationMethod.switchToChildTab();
		Assert.assertEquals(BaseClass.prop.getProperty("sauceLabDocumentationText"),
				navigationMethod.getSauceLabsDocumentationText());
		HooksClass.getScenario().log("    USER LANDED SUCCESSFULLY IN DOCUMENTATION PAGE   ");
	}

	@And("User closes that tab")
	public void user_closes_that_tab() {
		BaseClass.driver.close();
	}

	// New window and context menu

	@Then("User must be in about page after closing new tab")
	public void user_must_be_in_about_page_after_closing_new_tab() {
		navigationMethod.switchToParentWindow();
		Assert.assertEquals(BaseClass.prop.getProperty("aboutPageElement"), hoverMethod.getContactElementText());
		HooksClass.getScenario().log("    USER LANDED SUCCESSFULLY IN ABOUT PAGE    ");
	}

	@And("User hovers on Resource")
	public void user_hovers_on_resource() throws InterruptedException {
		navigationMethod.hoverResourceTab();
	}

	@And("User right-click on Documentation option and clicks on open in new window")
	public void user_right_click_on_documentation_option_and_clicks_on_open_in_new_window() throws AWTException {
		navigationMethod.rightClick();
	}

	@Then("User must be in Documentation page in new window")
	public void user_is_in_documentation_page() {
		navigationMethod.switchToChildTab();
		Assert.assertEquals(BaseClass.prop.getProperty("sauceLabDocumentationText"),
				navigationMethod.getSauceLabsDocumentationText());
		HooksClass.getScenario().log("    USER LANDED SUCCESSFULLY IN DOCUMENTATION PAGE   ");
	}

	@And("New window is closed")
	public void new_window_is_closed() {
		BaseClass.driver.close();
	}
}
