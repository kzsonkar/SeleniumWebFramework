/**
 * 
 */
package com.karan.orangehrm.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.karan.orangehrm.enums.ConfigProperties;
import com.karan.orangehrm.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author karansonkar
 *
 */
public final class Driver {

	private Driver() {
	}

	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
			DriverManager.getDriver().manage().timeouts()
					.implicitlyWait(Integer.parseInt(PropertyUtils.getValue(ConfigProperties.IMPLICITWAITTIME)), TimeUnit.SECONDS);
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().close();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
