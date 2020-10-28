package FrameWorkSample.EndToEndTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class FooterLinks extends Base{
	
	public WebDriver driver;//Add this declaration if you want to run in sequential mode
	//logging in log4j
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void footerTest() throws IOException {

		LandingPage footerLinks = new LandingPage(driver);
		Assert.assertEquals(footerLinks.getFooterCountries().findElements(By.tagName("a")).size(), 14);	
		log.info("Size should be 13");
	
	  }
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
