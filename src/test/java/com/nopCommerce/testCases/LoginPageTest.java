package com.nopCommerce.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.HomePage;
import com.nopCommerce.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateLoginPageTitleTest()
	{
		loginPage=new LoginPage();
		String actTitle=loginPage.validateLoginPageTitle();
		System.out.println("Login Page Title--->"+actTitle);
		Assert.assertEquals(actTitle,"Your store. Login");
		logger.info("Validating Login Page Title");
	}

	@Test(priority=2)
	public void validateLoginPageTextTest()
	{
		loginPage=new LoginPage();
		String actText=loginPage.validateLoginPageText();
		System.out.println("Login Page Text--->"+actText);
		Assert.assertEquals(actText,"Welcome, please sign in!");
		logger.info("Validating Login Page Text");
	}

	@Test(priority=3)
	public void loginTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Login Done Successfully");
	}

}
