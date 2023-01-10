package com.saucedemo.pagesFactoryClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.basepackage.BaseClass;

public class ProductPage extends BaseClass {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement filterButton;
	
	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item_price']")
	private List<WebElement> priceLabel;
	
	@FindBy(xpath = "//div[@class='inventory_item_label']//div[@class='inventory_item_name']")
	private List<WebElement> nameLabel;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIconLink;

	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "postal-code")
	private WebElement zipCodeField;

	@FindBy(id = "continue")
	private WebElement continueButton;

	@FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]")
	private WebElement checkoutOverviewHeader;

	@FindBy(id = "finish")
	private WebElement finishButton;

	@FindBy(xpath = "//div[@id='checkout_complete_container']/h2")
	private WebElement completeOrderMessage;

	
	public WebElement getFilterButton() {
		return filterButton;
	}

	public List<WebElement> getPriceLabel() {
		return priceLabel;
	}

	public List<WebElement> getNameLabel() {
		return nameLabel;
	}
	
	public WebElement getCartIconLink() {
		return cartIconLink;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getZipCodeField() {
		return zipCodeField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getCheckoutOverviewHeader() {
		return checkoutOverviewHeader;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}

	public WebElement getCompleteOrderMessage() {
		return completeOrderMessage;
	}
}
