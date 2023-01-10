package com.saucedemo.stepsdefination;

import java.io.IOException;

import org.junit.Assert;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.methodClass.ProductMethodClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepsDefination{
    ProductMethodClass productMethod;
    
    @When("User is on productPage")
    public void user_is_on_productPage() {
    	productMethod = new ProductMethodClass();
	}
	
	@And("User sorts products")
	public void user_sorts_products() {
		productMethod.doFilters();
	}
	
	@Then("Verify the sort order")
	public void verify_the_sort_order() {
	  Assert.assertTrue(productMethod.callSortOrder());
	}
	
	@And("User adds the products into cart by clicking on add to cart button")
	public void user_adds_the_products_into_cart_by_clicking_on_add_to_cart_button() throws InterruptedException {
		productMethod.AddProductToCart();
		HooksClass.getScenario().log("    USER CLICK ON ADDTOCARTBUTTON FOR MENTIONED PRODUCTS    ");
	}

	@Then("Products must be added to cart")
	public void products_must_be_added_to_cart() throws IOException{
		productMethod.clickCartIcon();
		Assert.assertTrue(productMethod.verifyProductsGetAddedToCartPage());
		HooksClass.getScenario().log("    PRODUCT ADDED TO CART SUCCESSFULLY    ");
	}

	@And("User clicks on checkout button")
	public void user_clicks_on_checkout_button() {
	 productMethod.clickCheckoutButton();
	}

	@Then("User is able to enter {string},{string} and {string} and clicks on continue")
	public void User_is_able_to_enter_and_and_clicks_on_continue(String firstName, String lastName, String zipCode) {
	    productMethod.enterDetailsInCheckOutPage(firstName,lastName,zipCode);
	    Assert.assertTrue(productMethod.verifyCheckoutOverviewIsDisplayed(firstName,lastName,zipCode));
	    HooksClass.getScenario().log("   USER SUCCESSFULLY SUBMITTED FIRSTNAME, LASTNAME AND ZIPCODE    ");
	}

	@When("User clicks on finish button")
	public void user_clicks_on_finish_button() {
	    productMethod.clickFinishButton();
	}

	@Then("User must have placed order successfully")
	public void user_must_have_placed_order_successfully() {
		Assert.assertEquals(BaseClass.prop.getProperty("orderCompletionText"), productMethod.getCompleteOrderMessage());
		HooksClass.getScenario().log("    USER SUCCESSFULLY PLACED THE ORDER    ");
	}

}
