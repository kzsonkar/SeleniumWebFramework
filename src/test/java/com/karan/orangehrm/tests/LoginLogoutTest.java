/**
 * 
 */
package com.karan.orangehrm.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.karan.orangehrm.enums.ConfigProperties;
import com.karan.orangehrm.enums.ProfileDropDownOptions;
import com.karan.orangehrm.pages.LoginPO;
import com.karan.orangehrm.utils.PropertyUtils;

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

		String title = new LoginPO()
				.loginToApp(PropertyUtils.getValue(ConfigProperties.USERNAME),
						PropertyUtils.getValue(ConfigProperties.PASSWORD))
				.doLogout(ProfileDropDownOptions.LOGOUT).getCurrentPageTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}

}
