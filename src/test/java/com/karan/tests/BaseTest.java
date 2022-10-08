/**
 * 
 */
package com.karan.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.karan.driver.Driver;

/**
 * @author karansonkar
 *
 */
public class BaseTest {

	protected BaseTest() {
	}

	@BeforeMethod
	protected void setup() {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
