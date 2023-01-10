package com.saucedemo.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
 @CucumberOptions(
		 features = {//".\\src\\test\\resources\\com\\feature\\Step1_Login.feature",
				     ".\\src\\test\\resources\\com\\feature\\Step2_Product.feature",
//				     ".\\src\\test\\resources\\com\\feature\\Step3_Hover.feature",
//			         ".\\src\\test\\resources\\com\\feature\\Step4_Navigation.feature",                  
		          },
		 glue = {"com.saucedemo.stepsdefination"},
		 tags =  "@demo or @product1 or @product2 or @Hover or @Navigation",
		 dryRun = false,     
        plugin = {"html:.//testOutput//Report_1.html",
				   "json:.//testOutput//Report.json",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},	
		 monochrome = true
		 )
public class TestRunnerClass {

}

















//@RunWith(Cucumber.class)
//@CucumberOptions(
//		 features = {".\\src\\test\\resources\\com\\feature\\Allfunction.feature"
//		          },
//		 glue = {"com.saucedemo.stepsdefination"},
//		 dryRun = false,
//		 plugin = {"pretty","html:.//testOutput//Report_1.html"},
//		 monochrome = true , 
//		 tags =  "@demo or @product1 or @Hover or @Navigation"
//		 )
//public class TestRunnerClass {
//}

