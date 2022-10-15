/**
 * 
 */
package com.karan.orangehrm.pages;

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

	protected void waitAndClick(By locator, WaitStrategy strategy) throws NumberFormatException, Exception {
		ExplicitWaitFactory.performExplicitWait(strategy, locator).click();
	}

	protected void waitAndSendKeys(String text, By locator, WaitStrategy strategy)
			throws NumberFormatException, Exception {
		ExplicitWaitFactory.performExplicitWait(strategy, locator).sendKeys(text);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void selectFromBootStrapDropDown(By locators, String toBeSelected) {

	}

}
