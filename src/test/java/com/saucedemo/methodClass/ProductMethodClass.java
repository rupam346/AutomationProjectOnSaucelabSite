package com.saucedemo.methodClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.saucedemo.basepackage.BaseClass;
import com.saucedemo.pagesFactoryClass.ProductPage;

public class ProductMethodClass  extends BaseClass implements CommonMethods {
	ProductPage productPage = new ProductPage();
	String productNames[];                              
	List<String> products;
	static Select select;
	static String selectOption;

	//Method to separate userInput(productNames) from configuration.properties file
	public void splitProductName() {
		productNames = BaseClass.prop.getProperty("productName").split(",");
		products = new ArrayList<String>();
		for (String s1 : productNames) {
			products.add(s1.trim().replaceAll(" ", "-").toLowerCase());
		}
	}
	
	//Method to add required products to cart
	public void AddProductToCart() {
		splitProductName();
		for (String s2 : products) {
				driver.findElement(By.id("add-to-cart-" + s2)).click();
		}
	}

	//Method to filter
	public void doFilters() {
		productPage.getFilterButton().click();
		
		CommonMethods c = new ProductMethodClass();
		
		select = new Select(productPage.getFilterButton());
		if(prop.getProperty("filter").matches("[0-9]+")) {
			String indexValueInString = prop.getProperty("filter");
			int index = Integer.parseInt(indexValueInString);
			c.doFilter(index);
	  }
		else {
			c.doFilter(prop.getProperty("filter"));
		}
	}

	public void doFilter(int index) {
		 select.selectByIndex(index);
		selectOption =  select.getFirstSelectedOption().getText();
		}

	public void doFilter(String text) {
		select.selectByVisibleText(text);
		selectOption =  select.getFirstSelectedOption().getText();
		}

		//Method to click cart icon
	public void clickCartIcon() {
		productPage.getCartIconLink().click();
	}

	//Method to verify products are added to cart
	public boolean verifyProductsGetAddedToCartPage() {
		boolean flag = false;
		for(int i=0; i<products.size(); i++) {
			if (driver.getPageSource().contains(products.get(i))) {
				flag = true;
			} else {
				return false;
			}
		}
		return flag;
	}
	
	//Method to click checkout button in your cart page 
	public void clickCheckoutButton() {
		productPage.getCheckoutButton().click();
	}
	
	//Method to enter input text fields and click on continue button in checkout:your information page 
	public void enterDetailsInCheckOutPage(String firstName, String lastName, String zipCode) {
			productPage.getFirstNameField().sendKeys(firstName);
			productPage.getLastNameField().sendKeys(lastName);
			productPage.getZipCodeField().sendKeys(zipCode);
			productPage.getContinueButton().click();
	}
	
	//Method to validate text fields data and verify user lands on checkout overview page
	public boolean verifyCheckoutOverviewIsDisplayed(String firstName, String lastName, String zipCode) {
		if(firstName.matches("^[a-zA-Z]*$") && lastName.matches("^[a-zA-Z]*$") && zipCode.matches("[0-9]{6}+")){
			return productPage.getCheckoutOverviewHeader().isDisplayed();
		}else {
			return false;
		}		
	}
	
	//Method to click finish button in checkout overview page
	public void clickFinishButton() {
		productPage.getFinishButton().click();
	}
	
	//Method to return complete order message from checkout:complete! page
	public String getCompleteOrderMessage() {
		return productPage.getCompleteOrderMessage().getText();
	}
	
	//Method to verify filter functionality in product page based on double and it return boolean  
	public boolean verifySortOrder(List<Double> prices) {
		boolean flag = false;
       for(int i=0; i<prices.size()-1; i++) {
    	   if(selectOption.equalsIgnoreCase("Price (low to high)")) {
    	   if(prices.get(i)<=prices.get(i+1)) {
    		   flag = true;
    	   }else {
    		   flag = false;
    		   return flag;
    	   }
       }
    	  if(selectOption.equalsIgnoreCase("Price (high to low)")) {
    		   if(prices.get(i)>=prices.get(i+1)) {
        		   flag = true;
        	   }else {
        		   flag = false;
        		   return flag;
        	   } 
    	   }
       }
		return flag;
	}
	
	public boolean verifySortOrder(String[] names) {
		boolean flag = false;
	       for(int i=0; i<names.length-1; i++) {
	    	   if(selectOption.equalsIgnoreCase("Name (Z to A)")) {
	    	   if(names[i].compareTo(names[i+1]) >0) {
	    		   flag = true;
	    	   }else {
	    		   flag = false;
	    		   return flag;
	    	   }
	       }
	    	  if(selectOption.equalsIgnoreCase("Name (A to Z)")) {
	    		   if(names[i].compareTo(names[i+1]) <0) {
	        		   flag = true;
	        	   }else {
	        		   flag = false;
	        		   return flag;
	        	   } 
	    	   }
	       }
			return flag;

	}
	//Method to call verifySortOrder()
	public boolean callSortOrder() {
		if(selectOption.contains("Name")) {
			List<WebElement> name = productPage.getNameLabel();
		    String[] names = new String[productPage.getNameLabel().size()];
		
			for(int i=0; i<name.size(); i++){
				names[i] = name.get(i).getText();
			}
		return verifySortOrder(names);
		}
		
		 if(selectOption.contains("Price")) {
			
			List<WebElement> price = productPage.getPriceLabel();
			List<Double>  prices = new ArrayList<Double>();
			for(int i=0; i<price.size(); i++){
				prices.add(Double.parseDouble(price.get(i).getText().replaceAll("[^\\d.]", "")));
			}
		return verifySortOrder(prices);
		}else {		
		return false;
		}
	}

	
}
