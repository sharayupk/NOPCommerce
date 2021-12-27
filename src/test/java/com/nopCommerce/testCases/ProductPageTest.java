package com.nopCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.HomePage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.ProductPage;

public class ProductPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;

	public ProductPageTest()
	{
		super();
	}
	
	@Test(priority=1)
	public void validateProductTextTest() throws InterruptedException
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.clickOnCatalogLink();
		Thread.sleep(2000);
		productPage=homePage.clickOnProductLink();
		logger.info("Clicked on Product Link");
		
		boolean result=productPage.validateProductText();
		Assert.assertTrue(result);
		logger.info("Validate Product Text Present on Product Page");
	}
	
	@Test(priority=2)
	public void clickOnProductTest() throws InterruptedException
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.clickOnCatalogLink();
		Thread.sleep(2000);
		productPage=homePage.clickOnProductLink();
		logger.info("Clicked on Product Link");
		
		Thread.sleep(2000);
		productPage.clickOnProduct();
		logger.info("Clicked on Product Check Box in the product List");
		Thread.sleep(2000);
	}
	

	@Test(priority=3)
	public void addProductDetailsTest() throws InterruptedException
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		homePage.clickOnCatalogLink();
		Thread.sleep(2000);
		productPage=homePage.clickOnProductLink();
		logger.info("Clicked on Product Link");
		
		productPage.addProductDetails("Smart Watch");
		logger.info("Added Product");
		
	}

}
