package com.inet_Banking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerPage {
	
	WebDriver driver;

	public CustomerPage(WebDriver driver1){
		this.driver=driver1;
	}
	
	@FindBy(how=How.LINK_TEXT, using ="New Customer")
	@CacheLookup
	WebElement Customerbtn;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement customername;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(how=How.NAME, using="dob")
	@CacheLookup
	WebElement DOB;

	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement pin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement mobno;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.XPATH, using="//input[@type='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']")
	@CacheLookup
	WebElement submit;
	
	
	public void btnCustomer() {
		Customerbtn.click();
	}
	
	public void custName(String cname) {
		customername.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		gender.sendKeys(cgender);
	}
	
	public void custDOB(String dd,String mm, String yy ) {
		DOB.sendKeys(dd);
		DOB.sendKeys(mm);
		DOB.sendKeys(yy);
	}
	
	public void custAddress(String caddress) {
		address.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		city.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		state.sendKeys(cstate);
	}
	
	public void custPin(String cpin) {
		pin.sendKeys(cpin);
	}
	
	public void custMobile(String cmobile) {
		mobno.sendKeys(cmobile);
	}
	
	public void custEmail(String cemail) {
		email.sendKeys(cemail);
	}
	
	public void custPassword(String cpassword) {
		password.sendKeys(String.valueOf(cpassword)); //provide string value of int if available, otherwise provide string as it is.
	}
	
	public void btnSubmit() {
		submit.sendKeys(Keys.RETURN);
	}
	
}


