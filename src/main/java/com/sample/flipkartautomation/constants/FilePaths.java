package com.sample.flipkartautomation.constants;

public interface FilePaths {
	String userDir = System.getProperty("user.dir");
	String chromeDriverDir = userDir+ "/lib/chromedriver.exe";
	String mozillaDriverDir = userDir+"/lib/geckodriver.exe";
	String 	ieDriverDir = userDir+"/lib/IEDriverServer.exe";
}
