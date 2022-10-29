package com.karan.orangehrm.pages.enums;

public enum TopBarMenu {

	CONFIGURATION("Configuration "), EMPLOYEELIST("Employee List"), ADDEMPLOYEE("Add Employee"), REPORTS("Reports");

	private final String name;

	public String getName() {
		return name;
	}

	TopBarMenu(String name) {
		this.name = name;
	}

}
