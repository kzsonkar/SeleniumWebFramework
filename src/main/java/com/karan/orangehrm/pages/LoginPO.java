/**
 * 
 */
package com.karan.orangehrm.pages;

import org.openqa.selenium.By;

import com.karan.orangehrm.driver.DriverManager;
import com.karan.orangehrm.enums.WaitStrategy;

/**
 * @author karansonkar
 *
 */
public final class LoginPO extends BasePO {

	private static final By USER_NAME_TEXT_BOX = By.name("username");
	private static final By PASSWORD_TEXT_BOX = By.xpath("//input[@name='password' and @type='password']");
	private static final By LOGIN_BUTTON = By
			.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/button[@type='submit']");
	private static final By LOGIN_CONTAINER = By.className("orangehrm-login-slot-wrapper");

	public HomePO loginToApp(String username, String password) throws NumberFormatException, Exception {
		return setUsername(username).setPassword(password).clickLoginButton();
	}

	private LoginPO setUsername(String username) throws NumberFormatException, Exception {
		waitAndSendKeys(username, USER_NAME_TEXT_BOX, WaitStrategy.PRESENCE, "Username text box");
		return this;
	}

	private LoginPO setPassword(String password) throws NumberFormatException, Exception {
		waitAndSendKeys(password, PASSWORD_TEXT_BOX, WaitStrategy.PRESENCE, "Password text box");
		return this;
	}

	public String getCurrentPageTitle() {
		return getTitle();
	}

	private HomePO clickLoginButton() throws NumberFormatException, Exception {
		waitAndClick(LOGIN_BUTTON, WaitStrategy.PRESENCE, "Login button");
		return new HomePO();
	}

	public boolean validateLoginPage() {
		return DriverManager.getDriver().findElement(LOGIN_CONTAINER).isDisplayed();
	}

}
