package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.testCases.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(@class,'brand-link navbar-dark logo-switch')]")
	WebElement homePageLogo;
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/a/p")
	WebElement catalogLink;
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/ul/li[1]/a")
	WebElement productLink;
	
	public boolean validateHomePageLogo()
	{
		return homePageLogo.isDisplayed();
	}
	
	public void clickOnCatalogLink()
	{
		catalogLink.click();
	}
	
	public ProductPage clickOnProductLink()
	{
		productLink.click();
		return new ProductPage();
	}

}
