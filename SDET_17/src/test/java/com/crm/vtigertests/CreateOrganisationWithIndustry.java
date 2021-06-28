package com.crm.vtigertests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.JSONFileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.PropertyUtility;
import com.crm.GenericUtils.WebDriverUtility;

public class CreateOrganisationWithIndustry {
	
	@Test
	public void createOrganisationWithIndustryTest() throws Throwable
	{
		/*PropertyUtility pUtil=new PropertyUtility();
		String URL=pUtil.getPropertyKeyValue("url");
		String USERNAME=pUtil.getPropertyKeyValue("username");
		String PASSWORD=pUtil.getPropertyKeyValue("password");*/
		
		JSONFileUtility jUtil=new JSONFileUtility();
		String URL=jUtil.readDataFromJSON("url");
		String USERNAME=jUtil.readDataFromJSON("username");
		String PASSWORD=jUtil.readDataFromJSON("password");
		
		WebDriverUtility wUtil=new WebDriverUtility();
		
		ExcelUtility eUtil=new ExcelUtility();
		String orgName=eUtil.getExcelData("Sheet1", 3, 2);
		String indType=eUtil.getExcelData("Sheet1", 3, 3);
		
		//Launch Browser
		WebDriver driver=new ChromeDriver();
		wUtil.waitUntilPageLoad(driver);
		
		//Get URL
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to organisation
		driver.findElement(By.linkText("Organizations")).click();
		
		//Create organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		
		
		wUtil.selectOption(driver.findElement(By.name("industry")), indType);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
