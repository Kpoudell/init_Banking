package com.inet_Banking.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet_Banking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws InterruptedException, Exception
	{


		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Logged iN.");
		Thread.sleep(5000);
		String Title=(driver.getTitle());
		System.out.println(Title);
		logger.info("Title is printed");


		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{

			captureScreen(driver,"loginTest");// call this method from base class in failed case to capture sc.shot, provide testcase name in paramerter.

			Assert.assertTrue(false);
		}

	}

}
