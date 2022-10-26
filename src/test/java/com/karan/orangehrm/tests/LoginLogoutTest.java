/**
 * 
 */
package com.karan.orangehrm.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.karan.orangehrm.annotations.FrameworkAnnotation;
import com.karan.orangehrm.enums.CategoryType;
import com.karan.orangehrm.enums.ProfileDropDownOptions;
import com.karan.orangehrm.pages.LoginPO;

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

	/**
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Test
	@FrameworkAnnotation(author = { "Karan" }, category = { CategoryType.REGRESSION })
	public void loginLogoutTest(Map<String, String> data) throws Exception {

		String title = new LoginPO().loginToApp(data.get("username"), data.get("password"))
				.doLogout(ProfileDropDownOptions.LOGOUT).getCurrentPageTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}

}
