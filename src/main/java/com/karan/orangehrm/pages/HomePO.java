/**
 * 
 */
package com.karan.orangehrm.pages;

import org.openqa.selenium.By;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.enums.ProfileDropDownOptions;
import com.karan.orangehrm.enums.WaitStrategy;

/**
 * @author karansonkar
 *
 */
public final class HomePO extends BasePO {

	private static final By RECORDSCONTAINER = By.className("orangehrm-container");
	private static final String USERDROPDOWNOPTIONS = "//ul[@class='oxd-dropdown-menu']//li/a[text()='%s']";
	private static final By USERPROFILE = By.xpath("//span[@class='oxd-userdropdown-tab']/i");

	public boolean validateHomePage() {
		return DriverManager.getDriver().findElement(RECORDSCONTAINER).isDisplayed();
	}

	public LoginPO doLogout(ProfileDropDownOptions options) throws NumberFormatException, Exception {
		selectUserProfile();
		String xpath = String.format(USERDROPDOWNOPTIONS, options.getName());
		waitAndClick(By.xpath(xpath), WaitStrategy.PRESENCE, options.getName());
		return new LoginPO();
	}

	private void selectUserProfile() throws NumberFormatException, Exception {
		waitAndClick(USERPROFILE, WaitStrategy.PRESENCE, "Userprofile");
	}

}
