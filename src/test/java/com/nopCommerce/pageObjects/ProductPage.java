package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.testCases.BaseClass;

public class ProductPage extends BaseClass{
	
	public ProductPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement addNewBtn;
	@FindBy(id="Name")
	WebElement productName;
	@FindBy(name="save")
	WebElement saveBtn;
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/h1")
	WebElement productText;
	
	public boolean validateProductText()
	{
		return productText.isDisplayed();
	}
	
	public void clickOnProduct()
	{
		int rowCount=driver.findElements(By.xpath("//*[@id=\"products-grid\"]/tbody/tr")).size();
		System.out.println("Total No. of Rows--->"+rowCount);
		
		String beforeXpath="//*[@id='products-grid']/tbody/tr[";
		String afterXpath="]/td[3]";
		
		for(int i=1;i<=rowCount;i++)
		{
			String prodText=driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			
			if(prodText.contains("Build your own computer"))
			{
				driver.findElement(By.xpath("//*[@id='products-grid']/tbody/tr[1]/td[1]/input")).click();
				break;
			}
		}
	}
	
	public void addProductDetails(String prodName)
	{
		addNewBtn.click();
		productName.sendKeys(prodName);
		saveBtn.click();
	}
	
	
	

}
