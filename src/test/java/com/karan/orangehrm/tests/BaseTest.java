/**
 * 
 */
package com.karan.orangehrm.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.karan.orangehrm.driver.Driver;

/**
 * @author karansonkar
 *
 */
public class BaseTest {

	protected BaseTest() {
	}

	@BeforeMethod
	protected void setup() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
