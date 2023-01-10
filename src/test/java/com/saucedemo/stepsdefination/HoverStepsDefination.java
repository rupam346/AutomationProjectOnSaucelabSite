package com.saucedemo.stepsdefination;

import org.junit.Assert;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.methodClass.HoverMethodClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HoverStepsDefination {
	HoverMethodClass hoverMethod;
	
	@When("User is on product page")
	public void user_is_on_product_page() {
		hoverMethod = new HoverMethodClass();
	}

	@When("User clicks on left menuBar")
	public void user_click_on_left_menu_bar() throws InterruptedException {
		hoverMethod.clickMenuButton();
	}

	@And("User clicks ABOUT option")
	public void user_select_about_option() {
		hoverMethod.selectAboutOption();
	}

	@Then("User must be in ABOUT Page")
	public void User_must_be_in_about_Page() {
		Assert.assertEquals(BaseClass.prop.getProperty("aboutPageElement"), hoverMethod.getContactElementText());
		HooksClass.getScenario().log("    USER LANDED SUCCESSFULLY IN ABOUT PAGE    ");
	}

	@And("User hover contact tab")
	public void User_hover_contact_tab() throws InterruptedException {
		hoverMethod.hoverActionMethod();
	}
	
	@And("User select contactSales page and select crossBrowsertesting")
	public void user_select_contactSales_page_and_select_crossBrowsertesting() {
		hoverMethod.selectInterest();				
	}
}
