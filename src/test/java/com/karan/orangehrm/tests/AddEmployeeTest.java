/**
 * 
 */
package com.karan.orangehrm.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.karan.orangehrm.annotations.FrameworkAnnotation;
import com.karan.orangehrm.enums.CategoryType;
import com.karan.orangehrm.fixtures.entity.AddEmployeeData;
import com.karan.orangehrm.pages.AddEmployeePO;
import com.karan.orangehrm.pages.HomePO;
import com.karan.orangehrm.pages.LoginPO;
import com.karan.orangehrm.pages.enums.ProfileDropDownOptions;
import com.karan.orangehrm.pages.enums.TopBarMenu;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * @author karansonkar
 *
 */
public final class AddEmployeeTest extends BaseTest {

	private AddEmployeeTest() {

	}

	@FrameworkAnnotation(author = { "KARAN" }, category = { CategoryType.SMOKE, CategoryType.SMOKE })
	@Test
	public void addEmployeeTest(Map<String, String> data) {
		FixtureFactoryLoader.loadTemplates("com.karan.orangehrm.fixtures");
		AddEmployeeData empData = Fixture.from(AddEmployeeData.class).gimme("mandatories");
		try {
			boolean result = new LoginPO().loginToApp(data.get("username"), data.get("password"))
					.selectTopMenuOption(TopBarMenu.ADDEMPLOYEE, AddEmployeePO.class).enterEmployeeDetails(empData)
					.navigateToEmployeeListPage().isIdPresent(empData.getEmployeeId());
			if (result) {
				new HomePO().doLogout(ProfileDropDownOptions.LOGOUT).getCurrentPageTitle();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
