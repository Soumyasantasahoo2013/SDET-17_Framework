package com.crm.comcast.VtigerTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;
import com.crm.comcast.GenericUtils.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganisationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganisationInformationPage;
import com.crm.comcast.objectRepository.OrganisationPage;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable
	{

		//fetch the data
		String OrgName = eLib.getExcelData("sheet1","TC_01","OrgName")+JavaUtility.getRandomNumber();
		
		wLib.waitForPageToLoad(driver);

		//navigate to organizations
		homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();

		//navigate to create organization
		OrganisationPage orgPage=new OrganisationPage(driver);
		orgPage.clickOnCreateOrgImg();

		//enter mandatory fields and create organization
		CreateOrganisationPage createOrgPage=new CreateOrganisationPage(driver);
		createOrgPage.createOrganisation(OrgName);

		//validate
		OrganisationInformationPage orgInfoPage=new OrganisationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganisationText();
		Assert.assertTrue(actualOrgName.contains(OrgName));
		
		Reporter.log("Test Script for Create Org.",true);
	}
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustry() throws Throwable
	{
		//Fetch the data
		String OrgName = eLib.getExcelData("sheet1", 1,2)+JavaUtility.getRandomNumber();
		String IndustryType = eLib.getExcelData("sheet1",3,3);

		//Navigate to organizations
		homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();

		//create organization
		OrganisationPage orgPage=new OrganisationPage(driver);
		orgPage.clickOnCreateOrgImg();

		//enter mandatory fields and create organization
		CreateOrganisationPage createOrgPage=new CreateOrganisationPage(driver);
		createOrgPage.createOrganisationWithIndustry(OrgName, IndustryType);

		//validate
		OrganisationInformationPage orgInfoPage=new OrganisationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganisationText();
		Assert.assertTrue(actualOrgName.contains(OrgName));
		String actualIndustryName=orgInfoPage.getIndusInfo();
		Assert.assertEquals(actualIndustryName, IndustryType);
		
		Reporter.log("Test Script for Create org with Industry",true);
	}
}
