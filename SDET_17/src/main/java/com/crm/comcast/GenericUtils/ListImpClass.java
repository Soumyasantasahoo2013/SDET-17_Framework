package com.crm.comcast.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String failedTestCaseName=result.getMethod().getMethodName();
		String currentSysDate=new Date().toString().replace(":", "_").replace(" ", "_");
		EventFiringWebDriver ed=new EventFiringWebDriver(BaseClass.sdriver);
		File srcImg = ed.getScreenshotAs(OutputType.FILE);
		File destImg=new File("./screenshot/"+failedTestCaseName+currentSysDate+".png");
		try {
			FileUtils.copyFile(srcImg, destImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
