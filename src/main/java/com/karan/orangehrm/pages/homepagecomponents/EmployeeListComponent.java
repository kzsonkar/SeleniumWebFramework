package com.karan.orangehrm.pages.homepagecomponents;

public final class EmployeeListComponent {

	private EmployeeListComponent() {

	}

	// %s indicates emp first & middle name
	private static final String EMP_RECORD_DELETE_BTN = "//div[@class='oxd-table orangehrm-employee-list']//div[text()='%s']/parent::div/parent::div//button[1]";
	private static final String EMP_RECORD_EDIT_BTN = "//div[@class='oxd-table orangehrm-employee-list']//div[text()='%s']/parent::div/parent::div//button[2]";

}
