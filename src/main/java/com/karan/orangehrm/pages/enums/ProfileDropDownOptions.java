/**
 * 
 */
package com.karan.orangehrm.pages.enums;

/**
 * @author karansonkar
 *
 */
public enum ProfileDropDownOptions {

	ABOUT("About"), SUPPORT("Support"), CHANGEPASSWORD("Change Password"), LOGOUT("Logout");

	private final String name;

	public String getName() {
		return name;
	}

	ProfileDropDownOptions(String name) {
		this.name = name;
	}

}
