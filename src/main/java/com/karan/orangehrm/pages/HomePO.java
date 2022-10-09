/**
 * 
 */
package com.karan.orangehrm.pages;

import org.openqa.selenium.By;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.enums.ProfileDropDownOptions;

/**
 * @author karansonkar
 *
 */
public final class HomePO extends BasePO{
	
	private static final By RECORDSCONTAINER = By.className("orangehrm-container");
	private static final String USERDROPDOWNOPTIONS = "//ul[@class='oxd-dropdown-menu']//li/a[text()='%s']";
	private static final By USERPROFILE = By.xpath("//span[@class='oxd-userdropdown-tab']/i");
	
	public boolean validateHomePage() {
		return DriverManager.getDriver().findElement(RECORDSCONTAINER).isDisplayed();
	}
	
	public LoginPO doLogout(ProfileDropDownOptions options) {
		selectUserProfile();
		String xpath = String.format(USERDROPDOWNOPTIONS, options.getName());
		waitAndClick(By.xpath(xpath));
		return new LoginPO();
	}
	
	private void selectUserProfile() {
		waitAndClick(USERPROFILE);
	}

}
