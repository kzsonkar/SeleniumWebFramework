/**
 * 
 */
package com.karan.orangehrm.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.testng.annotations.Test;

import com.karan.orangehrm.annotations.FrameworkAnnotation;
import com.karan.orangehrm.enums.CategoryType;
import com.karan.orangehrm.pages.LoginPO;
import com.karan.orangehrm.pages.enums.ProfileDropDownOptions;

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
	 * @throws Exception
	 */
	@Test
	@FrameworkAnnotation(author = { "KARAN" }, category = { CategoryType.REGRESSION, CategoryType.HEALTHCHECK })
	public void loginLogoutTest(Map<String, String> data) throws Exception {

		String title = new LoginPO().loginToApp(data.get("username"), data.get("password"))
				.doLogout(ProfileDropDownOptions.LOGOUT).getCurrentPageTitle();

		assertThat(title).isEqualTo("OrangeHRM");

	}

}
