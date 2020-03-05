package com.inet_Banking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inet_Banking.utilities.ReadConfig;




public class BaseClass {
	ReadConfig readconfig=new ReadConfig();

	public String Url=readconfig.getApplicatonurl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	//public String pageTitle=("Guru99 Bank Manager HomePage");
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{

		logger=Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver=new ChromeDriver();
		}else if (br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}


		driver.manage().timeouts().pageLoadTimeout(110, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Url);

	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourse = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(sourse, target);
		System.out.println("Screenshot Taken");
	}

	public String randomstring() {
		String generatedstring=	RandomStringUtils.randomAlphabetic(5);
		return(generatedstring);
	}

	public String randomnumber() {
		String generatednumber=	RandomStringUtils.randomNumeric(6);
		return(generatednumber);
	}

}
