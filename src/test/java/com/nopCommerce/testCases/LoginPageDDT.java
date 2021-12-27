package com.nopCommerce.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.HomePage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.utilities.XLUtils;

public class LoginPageDDT extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageDDT()
	{
		super();
	}
	
	@Test(dataProvider="loginData")
	public void loginTest(String userName,String pwd)
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(userName,pwd);
		logger.info("Login Done Successfully");
	}
	
	@DataProvider
	public Object[][] loginData() throws Exception
	{
		String excelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\nopCommerce\\testData\\nopCommerce.xlsx";
		
		int rownum=XLUtils.getRowCount(excelPath, "Sheet1");
		int cellnum=XLUtils.getColCount(excelPath, "Sheet1",1);
		
		String loginData[][]=new String[rownum][cellnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
			    loginData[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}
		return loginData;
		
	}


}
