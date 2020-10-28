package FrameWorkSample.EndToEndTest;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import resources.Base;

public class LogIn extends Base{
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		
	}
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		LoginPage log = new LoginPage(driver);
		log.getContinueWithEmail().click();
		log.getEmail().sendKeys("xxxx@gmail.com");
		Assert.assertTrue(log.getContinueButton().isDisplayed());

	  }
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
