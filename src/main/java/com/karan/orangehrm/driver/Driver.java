/**
 * 
 */
package com.karan.orangehrm.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.karan.orangehrm.utils.ReadPropertyFile;

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
			DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
			DriverManager.getDriver().manage().timeouts()
					.implicitlyWait(Integer.parseInt(ReadPropertyFile.getValue("implicitWaitTime")), TimeUnit.SECONDS);
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
