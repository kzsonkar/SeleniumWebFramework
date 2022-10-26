/**
 * 
 */
package com.karan.orangehrm.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.karan.orangehrm.enums.CategoryType;

/**
 * @author karansonkar
 *
 */
public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports report;
	public static ExtentTest test;

	public static void initReports() {
		if (Objects.isNull(report)) {
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			report.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("OrangeHrm Reports");
			spark.config().setReportName("My Tests");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(report)) {
			report.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File("index.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		test = report.createTest(testCaseName);
		ExtentManager.setExtentTest(test);
	}

	/**
	 * Logs the authors details in the authors view in the extent report. Gives an
	 * clear idea of Authors Vs Percentage success metrics
	 * 
	 * @param authors Authors who created a particular test case
	 */
	public static void addAuthors(String[] authors) {
		for (String temp : authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

	/**
	 * Adds the category a particular test case belongs to. Gives an clear idea of
	 * Group Vs Percentage success metrics.
	 * 
	 * @param categories category a particular test case belongs to.
	 */
	public static void addCategories(CategoryType[] categories) {
		for (CategoryType temp : categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}

}
