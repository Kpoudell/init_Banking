package com.inet_Banking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inet_Banking.pageObjects.LoginPage;
import com.inet_Banking.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();

		}


	}


	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}

	}

// Here the Data provider portion is error!!!
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	
	{
		XLUtils reader=new XLUtils(System.getProperty("user.dir")+"/src\\test/java/com/inet_Banking/testData/LoginData.xlsx");
		int rowcount=reader.getRowCount("Sheet1");
		int colcount=reader.getColumnCount("Sheet1");
		


		String logindata[][]=new String[rowcount][colcount];

		for(int rownum=1;rownum<=rowcount;rownum++)
		{ for(int colnum=0;colnum<=colcount;colnum++) {
			reader.getCellData("Sheet1", colnum, rownum);
		}
		}
		return logindata;
	}

		
	}



