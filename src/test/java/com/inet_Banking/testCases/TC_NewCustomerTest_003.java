package com.inet_Banking.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet_Banking.pageObjects.CustomerPage;

public class TC_NewCustomerTest_003 extends BaseClass {

	TC_LoginTest_001 log=new TC_LoginTest_001();
	
	
	@Test
	public void NewCustomerTest() throws Exception {
		log.loginTest();// to execute login test-case.
		
		CustomerPage elements=PageFactory.initElements(driver, CustomerPage.class);
		elements.btnCustomer();
		elements.custName("Kusum");
		elements.custGender("male");
		elements.custDOB("13", "01", "1997");
		elements.custAddress("Sanepa");
		elements.custCity("lalitpur");
		elements.custState("Hetauda");
		String pin=randomnumber();
		elements.custPin(pin);
		String email= (randomstring()+"@gmail.com");
		elements.custEmail(email);
		String phone=("9860"+randomnumber());
		elements.custMobile(phone);
		elements.custPassword("12345");
		elements.btnSubmit();

		boolean confirmation=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (confirmation==true) {
			Assert.assertTrue(true);
			System.out.println("New customer added.");
			logger.info("New Customer Added");

		}else {
			captureScreen(driver, "NewCustomerTest");
			logger.info("New member cannot be added.");
			Assert.assertTrue(false);

		}



	}


}
