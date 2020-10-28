package FrameWorkSample.EndToEndTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.OrderingPage;
import pageObjects.RestoPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver; //Add this declaration if you want to run in sequential mode
	
	//logging in log4j
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	
	}
	
	//if a data will be passed on a test
	//@Test(dataProvider="getData") 
	@Test
	public void homePage() throws IOException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getSearch().click();
		landingPage.getSearch().sendKeys("Makati");
		Integer size = landingPage.getSuggestion().size();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.foodpanda.ph/");
		log.info("Url is correct");
		
		for (int i =0; i < size; i++) {
			List<WebElement> suggestions = landingPage.getSuggestion();
			String places = suggestions.get(i).getText();
			
				if(places.contains("Avenue")) {
					
					suggestions.get(i).click();
					break;
				
				}
		}
		
		
		landingPage.getDelivery().click();
		//Since test is still on Landing page created return for this in Landing Page Object
		RestoPage restoPage = landingPage.getFindRestaurants();
		restoPage.getRestoSearch().click();
	}
	
	@Test
	public void restoPage() {
		RestoPage restoPage = new RestoPage(driver);
		restoPage.getRestoSearch().sendKeys("Jollibee");
		restoPage.getRestoSearch().sendKeys(Keys.ENTER);
		WebElement restoList = restoPage.getVendorList();
		Integer restoSize = restoList.findElements(By.tagName("a")).size();
		
		for (int i = 0; i < restoSize; i++) {
			List <WebElement> restoVal = restoList.findElements(By.tagName("a"));
			String restaurants = restoVal.get(i).getText();
			 
			if(restaurants.contains("Jollibee")) {
			
				restoVal.get(i).click();
				break;
			
			}
		}
		
		OrderingPage restoName = new OrderingPage(driver);
		Assert.assertEquals(restoName.getRestoName().getText(), "Jollibee - Philfirst");
		log.info("Restaurant is chosen");
				
	}
	
	//sample declaration of data provider
	/*@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types should run
		//Columns stands for how many values for each test
		Object[][] data = new Object[1][2];
		//first row
		data[0][0] ="nonrestricteduser@gmail.com";
		data[0][1]="12312";
		data[0][2]="Non-Restricted user";
		//second row
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="2312131";
		data[1][2]="Restricted user";
		
		return data;		
		
	}*/
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
