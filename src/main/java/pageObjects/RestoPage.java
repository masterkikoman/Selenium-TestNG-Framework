package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestoPage {
	
	public WebDriver driver;
	
	By restoSearch = By.xpath("//*[@class='restaurants-search-input']");
	By vendorList = By.xpath("//*[@class='vendor-list-section open-section']");

	
	

	public RestoPage(WebDriver driver) {
		
		this.driver = driver;
		
		}


	public WebElement getRestoSearch() {
		
		return driver.findElement(restoSearch);
	
	}
	
	public WebElement getVendorList () {
		
		return driver.findElement(vendorList);
		
	}
	

}
