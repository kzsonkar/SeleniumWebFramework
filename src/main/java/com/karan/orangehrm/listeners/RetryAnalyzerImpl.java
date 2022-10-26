package com.karan.orangehrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpl implements IRetryAnalyzer {
	
	int count=0;
	int limit=2;

	@Override
	public boolean retry(ITestResult result) {
		if(count<limit) count++;
		return false;
	}

}
