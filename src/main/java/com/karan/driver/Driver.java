/**
 * 
 */
package com.karan.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author karansonkar
 *
 */
public final class Driver {
	
	private Driver() {}
	
	public static void initDriver() {
		if(Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get("https://google.com");
			DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().close();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}