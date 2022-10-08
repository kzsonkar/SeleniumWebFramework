/**
 * 
 */
package com.karan.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author karansonkar
 *
 */
public final class FirstTest {
	
	private FirstTest() {}
	
	@Test
	public void f() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.close();
		driver.quit();
	}

}
