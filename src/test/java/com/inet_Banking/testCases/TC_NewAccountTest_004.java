package com.inet_Banking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet_Banking.pageObjects.NewAccountPage;

public class TC_NewAccountTest_004 extends BaseClass {

	TC_LoginTest_001 login= new TC_LoginTest_001();
	@Test
	public void NewAccTest() throws Exception {

		login.loginTest();
		Thread.sleep(3000);

		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().dismiss();
		}


		NewAccountPage elements	=PageFactory.initElements(driver, NewAccountPage.class);



		elements.clicknewaccountbtn();
		elements.typecusID("1");
		elements.typeacctype("Current");
		elements.typeinitialdeposite("1000");
		elements.clickAccountSubmitBtn();

		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			Assert.assertTrue(false);
			logger.warn("New Customer can't be added");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("New Customer added");
			String alerttxt=driver.switchTo().alert().getText();
			System.out.println(alerttxt);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}     
	private boolean isAlertPresent() {
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	} }
