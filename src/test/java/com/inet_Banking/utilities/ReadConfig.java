package com.inet_Banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File src=new File("./Configurations/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}

	
	public String getApplicatonurl()
	{
		String url=pro.getProperty("Url");
		return url;
	}
	
	public String getUsername()
	{
		String url=pro.getProperty("username");
		return url;
	}
	
	public String getPassword()
	{
		String url=pro.getProperty("password");
		return url;
	}
	
	public String getChromepath()
	{
		String url=pro.getProperty("chromepath");
		return url;
	}

	public String getFirefoxpath()
	{
		String url=pro.getProperty("firefoxpath");
		return url;
	}
}
