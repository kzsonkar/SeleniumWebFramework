/**
 * 
 */
package com.karan.orangehrm.pages;

import static com.karan.orangehrm.enums.LogType.PASS;
import static com.karan.orangehrm.reports.FrameworkLogger.log;

import org.openqa.selenium.By;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.enums.WaitStrategy;
import com.karan.orangehrm.factories.ExplicitWaitFactory;

/**
 * @author karansonkar
 *
 */
public class BasePO {

	/**
	 * 
	 */
	protected BasePO() {
	}

	protected void waitAndClick(By locator, WaitStrategy strategy, String elementName) throws NumberFormatException, Exception {
		ExplicitWaitFactory.performExplicitWait(strategy, locator).click();
		log(PASS, "Clicked on " + elementName);
	}

	protected void waitAndSendKeys(String text, By locator, WaitStrategy strategy, String elementName)
			throws NumberFormatException, Exception {
		ExplicitWaitFactory.performExplicitWait(strategy, locator).sendKeys(text);
		log(PASS, text + " value entered successfully in " + elementName);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void selectFromBootStrapDropDown(By locators, String toBeSelected) {

	}

}
