package com.inet_Banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage {

	WebDriver driver;
	public NewAccountPage(WebDriver driver1) {
		this.driver=driver1;

	}

	@FindBy(how=How.LINK_TEXT, using="New Account")
	@CacheLookup
	WebElement Newaccountbtn;

	@FindBy(how=How.XPATH, using="input[@name='cusid']")
	@CacheLookup
	WebElement txtcusid;

	@FindBy(how=How.NAME, using="selaccount")
	@CacheLookup
	WebElement txtacctype;

	@FindBy(how=How.NAME, using="inideposit")
	@CacheLookup
	WebElement txtindeposit;

	@FindBy(how=How.NAME, using="button2")
	@CacheLookup
	WebElement accsubmitbtn;


	public void clicknewaccountbtn() {
		Actions actions = new Actions(driver);
	    actions.moveToElement(Newaccountbtn).click().build().perform();
		//Newaccountbtn.click();
	}

	public void typecusID(String cid) {
		txtcusid.sendKeys(cid);
	}

	public void typeacctype(String acctype) {
		txtacctype.sendKeys(acctype);
	}

	public void typeinitialdeposite(String idep) {
		txtindeposit.sendKeys(idep);
	}

	public void clickAccountSubmitBtn(){
		accsubmitbtn.click();
	}
}
