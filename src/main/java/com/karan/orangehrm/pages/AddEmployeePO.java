package com.karan.orangehrm.pages;

import org.openqa.selenium.By;

import com.karan.orangehrm.enums.WaitStrategy;
import com.karan.orangehrm.fixtures.entity.AddEmployeeData;
import com.karan.orangehrm.pages.enums.AddEmployee;
import com.karan.orangehrm.pages.enums.TopBarMenu;
import com.karan.orangehrm.utils.DynamicXpathUtils;

public class AddEmployeePO extends BasePO {

	private static final String EMPLOYEEFULLNAME = "//div[@class='--name-grouped-field']//input[@placeholder='%s']";
	private static final By EMPLOYEE_ID = By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']//input");
	private static final By CANCEL_BTN = By.xpath("//div[@class='oxd-form-actions']//button[1]");
	private static final By SAVE_BTN = By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']");

	public AddEmployeePO enterEmployeeDetails(AddEmployeeData empData) {
		enterNameData(AddEmployee.FIRSTNAME, empData.getFirstName())
				.enterNameData(AddEmployee.MIDDLENAME, empData.getMiddleName())
				.enterNameData(AddEmployee.LASTNAME, empData.getLastName()).enterEmployeeId(empData.getEmployeeId())
				.clickOnSaveBtn();
		return this;
	}

	public ViewEmployeeListPO navigateToEmployeeListPage() {
		String xpath = DynamicXpathUtils.getXpath(TOPBARMENUOPTIONS, TopBarMenu.EMPLOYEELIST.getName());
		waitAndClick(By.xpath(xpath), WaitStrategy.PRESENCE, "Employee List menu bar");
		return new ViewEmployeeListPO();
	}

	private AddEmployeePO enterNameData(AddEmployee emp, String fieldName) {
		StringBuilder name = new StringBuilder();
		if (emp.getName().equals(AddEmployee.FIRSTNAME.getName())) {
			name.append(DynamicXpathUtils.getXpath(EMPLOYEEFULLNAME,
					com.karan.orangehrm.pages.enums.AddEmployee.FIRSTNAME.getName()));
		} else if (emp.getName().equals(AddEmployee.MIDDLENAME.getName())) {
			name.append(DynamicXpathUtils.getXpath(EMPLOYEEFULLNAME,
					com.karan.orangehrm.pages.enums.AddEmployee.MIDDLENAME.getName()));
		} else if (emp.getName().equals(AddEmployee.LASTNAME.getName())) {
			name.append(DynamicXpathUtils.getXpath(EMPLOYEEFULLNAME,
					com.karan.orangehrm.pages.enums.AddEmployee.LASTNAME.getName()));
		}
		waitAndSendKeys(fieldName, By.xpath(name.toString()), WaitStrategy.PRESENCE, emp.getName() + " text box");
		return this;
	}

	private AddEmployeePO enterEmployeeId(int empId) {
		waitAndSendKeys(String.valueOf(empId), EMPLOYEE_ID, WaitStrategy.PRESENCE, "Employee Id text box");
		return this;
	}

	private AddEmployeePO clickOnSaveBtn() {
		waitAndClick(SAVE_BTN, WaitStrategy.PRESENCE, "Save button");
		return this;
	}

	@SuppressWarnings("unused")
	private AddEmployeePO clickOnCancelBtn() {
		waitAndClick(CANCEL_BTN, WaitStrategy.PRESENCE, "Cancel button");
		return this;
	}

}
