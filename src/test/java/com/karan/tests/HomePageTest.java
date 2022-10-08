/**
 * 
 */
package com.karan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.karan.driver.DriverManager;

/**
 * @author karansonkar
 *
 */
public final class HomePageTest extends BaseTest{
	
	private HomePageTest() {}
	
	@Test
	public void f() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Home page test", Keys.ENTER);
		Thread.sleep(2000);
	}

}