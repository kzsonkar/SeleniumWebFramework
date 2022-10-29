package com.karan.orangehrm.pages.enums;

public enum AddEmployee {

	FIRSTNAME("First Name"), MIDDLENAME("Middle Name"), LASTNAME("Last Name");

	private final String name;

	public String getName() {
		return name;
	}

	AddEmployee(String name) {
		this.name = name;
	}

}
