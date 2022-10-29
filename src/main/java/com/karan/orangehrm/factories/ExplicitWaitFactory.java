/**
 * 
 */
package com.karan.orangehrm.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.enums.ConfigProperties;
import com.karan.orangehrm.enums.WaitStrategy;
import com.karan.orangehrm.utils.PropertyUtils;

/**
 * @author karansonkar
 *
 */
public final class ExplicitWaitFactory {

	/**
	 * 
	 */
	private ExplicitWaitFactory() {
	}

	public static WebElement performExplicitWait(WaitStrategy strategy, By by) throws NumberFormatException, Exception {
		WebElement element = null;
		if (strategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Integer.parseInt(PropertyUtils.getValue(ConfigProperties.EXPLICITWAITTIME)))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (strategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Integer.parseInt(PropertyUtils.getValue(ConfigProperties.EXPLICITWAITTIME)))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (strategy == WaitStrategy.VISIBILITY) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Integer.parseInt(PropertyUtils.getValue(ConfigProperties.EXPLICITWAITTIME)))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (strategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
