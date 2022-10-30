/**
 * 
 */
package com.karan.orangehrm.pages;

import org.openqa.selenium.By;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.enums.WaitStrategy;
import com.karan.orangehrm.pages.enums.ProfileDropDownOptions;
import com.karan.orangehrm.pages.enums.TopBarMenu;
import com.karan.orangehrm.pages.homepagecomponents.EmployeeListComponent;
import com.karan.orangehrm.pages.homepagecomponents.LeftMenuComponent;
import com.karan.orangehrm.utils.DynamicXpathUtils;

/**
 * @author karansonkar
 *
 */
public final class HomePO extends BasePO {
	
	EmployeeListComponent employeeListComponent;
	LeftMenuComponent leftMenuComponent;
	private static final String TOPBARMENUOPTIONS = "//div[@class='oxd-topbar-body']//li//a[text()='%s']";
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

	@SuppressWarnings("deprecation")
	public <T> T selectTopMenuOption(TopBarMenu menu, Class<T> clazz) throws NumberFormatException, Exception {
		waitAndClick(By.xpath(DynamicXpathUtils.getXpath(TOPBARMENUOPTIONS, menu.getName())), WaitStrategy.PRESENCE,
				menu.getName());
		return clazz.newInstance();
	}

}
