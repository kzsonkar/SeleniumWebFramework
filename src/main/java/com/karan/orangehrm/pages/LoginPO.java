/**
 * 
 */
package com.karan.orangehrm.pages;

import org.openqa.selenium.By;

import com.karan.orangehrm.driver.DriverManager;

/**
 * @author karansonkar
 *
 */
public final class LoginPO extends BasePO{
	
	private static final By USER_NAME_TEXT_BOX = By.name("username");
	private static final By PASSWORD_TEXT_BOX = By.xpath("//input[@name='password' and @type='password']");
	private static final By LOGIN_BUTTON = By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/button[@type='submit']");
	private static final By LOGIN_CONTAINER = By.className("orangehrm-login-slot-wrapper");
	
	
	public HomePO loginToApp(String username, String password) {
		return setUsername(username).setPassword(password).clickLoginButton();
	}
	
	private LoginPO setUsername(String username) {
		waitAndSendKeys(username, USER_NAME_TEXT_BOX);
		return this;
	}
	
	private LoginPO setPassword(String password) {
		waitAndSendKeys(password, PASSWORD_TEXT_BOX);
		return this;
	}
	
	private HomePO clickLoginButton() {
		waitAndClick(LOGIN_BUTTON);
		return new HomePO();
	}
	
	public boolean validateLoginPage() {
		return DriverManager.getDriver().findElement(LOGIN_CONTAINER).isDisplayed();
	}
	
}
