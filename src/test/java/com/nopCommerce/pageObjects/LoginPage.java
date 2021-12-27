package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.testCases.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="Email")
	WebElement userName;
	@FindBy(id="Password")
	WebElement Password;
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginBtn;
	@FindBy(xpath="//div[@class='title']/strong")
	WebElement loginPageText;
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateLoginPageText()
	{
		return loginPageText.getText();
	}
	
	public HomePage login(String userid,String pwd)
	{
		userName.clear();
		userName.sendKeys(userid);
		Password.clear();
		Password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
