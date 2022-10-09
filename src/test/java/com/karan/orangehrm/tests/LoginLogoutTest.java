/**
 * 
 */
package com.karan.orangehrm.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.karan.orangehrm.enums.ProfileDropDownOptions;
import com.karan.orangehrm.pages.HomePO;
import com.karan.orangehrm.pages.LoginPO;
import com.karan.orangehrm.utils.ReadPropertyFile;

/**
 * @author karansonkar
 *
 */
public final class LoginLogoutTest extends BaseTest {

	/**
	 * 
	 */
	private LoginLogoutTest() {
	}

	@Test
	public void f() throws Exception {

		boolean homePageValidation = new LoginPO()
				.loginToApp(ReadPropertyFile.getValue("username"), ReadPropertyFile.getValue("password"))
				.validateHomePage();
		
		Assertions.assertThat(homePageValidation).isTrue();
		
		if(homePageValidation) {
			boolean loginPageValidation = new HomePO().doLogout(ProfileDropDownOptions.LOGOUT).validateLoginPage();
			Assertions.assertThat(loginPageValidation).isTrue();
		}

	}

}
