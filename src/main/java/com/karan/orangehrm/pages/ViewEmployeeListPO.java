package com.karan.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.karan.orangehrm.enums.WaitStrategy;
import com.karan.orangehrm.factories.ExplicitWaitFactory;
import com.karan.orangehrm.utils.DynamicXpathUtils;

public class ViewEmployeeListPO extends BasePO{

	private static final String EMP_ID = "//div[@class='oxd-table-cell oxd-padding-cell']//div[text()='%s']";

	public boolean isIdPresent(int empId) throws NumberFormatException, Exception {
		String id = DynamicXpathUtils.getXpath(EMP_ID, String.valueOf(empId));
		try {
			ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBILITY, By.xpath(id));
			return true;
		} catch(TimeoutException e) {
			e.printStackTrace();
			return false;
		}
	}

}
