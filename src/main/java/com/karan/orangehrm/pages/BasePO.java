/**
 * 
 */
package com.karan.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.utils.ReadPropertyFile;

/**
 * @author karansonkar
 *
 */
public class BasePO {

	private static WebDriverWait waitDriver = null;

	static {
		try {
			waitDriver = new WebDriverWait(DriverManager.getDriver(),
					Integer.parseInt(ReadPropertyFile.getValue("explicitWaitTime")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	protected BasePO() {
	}

	public static void waitAndClick(By locator) {
		waitDriver.until(ExpectedConditions.presenceOfElementLocated(locator));
		DriverManager.getDriver().findElement(locator).click();
	}
	
	public static void waitAndSendKeys(String text, By locator) {
		waitDriver.until(ExpectedConditions.presenceOfElementLocated(locator));
		DriverManager.getDriver().findElement(locator).sendKeys(text);
	}
	
	public static void selectFromBootStrapDropDown(By locators, String toBeSelected) {
		
	}

}
