package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.HomePage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.ProductPage;

public class HomePageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;

	public HomePageTest()
	{
		super();
	}
	
	@Test(priority=1)
	public void validateHomePageLogoTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateHomePageLogo();
		Assert.assertTrue(result);
		logger.info("Validating Home Page Logo");
	}
	
	@Test(priority=2)
	public void clickOnCatalogLinkTest() throws InterruptedException
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.clickOnCatalogLink();
		logger.info("Clicked on Catalog Link");
	}
	
	@Test(priority=3)
	public void clickOnProductLinkTest() throws InterruptedException
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.clickOnCatalogLink();
		Thread.sleep(2000);
		productPage=homePage.clickOnProductLink();
		logger.info("Clicked on Product Link");
	}

}
