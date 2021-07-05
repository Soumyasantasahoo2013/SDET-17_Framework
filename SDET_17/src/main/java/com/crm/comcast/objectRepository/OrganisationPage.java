package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganisationIMG;

	/**
	 * @return the createOrganisationIMG
	 */
	public WebElement getCreateOrganisationIMG() {
		return createOrganisationIMG;
	}
	
	public void clickOnCreateOrgImg()
	{
		createOrganisationIMG.click();
	}

}
