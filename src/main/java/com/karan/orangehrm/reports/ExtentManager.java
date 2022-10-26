/**
 * 
 */
package com.karan.orangehrm.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author karansonkar
 *
 */
public class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return test.get();
	}

	static void setExtentTest(ExtentTest testRef) {
		if (Objects.nonNull(test)) {
			test.set(testRef);
		}
	}

	static void unload() {
		test.remove();
	}

}
