package com.crm.comcast.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int retrylimit=4;
	
	public boolean retry(ITestResult result) {
		
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
