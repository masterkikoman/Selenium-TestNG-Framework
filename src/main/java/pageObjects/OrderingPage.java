package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderingPage {
	
	public WebDriver driver;
	
	By restoName = By.xpath("//h1[@class='fn']");
	
	public OrderingPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public WebElement getRestoName() {
		
		return driver.findElement(restoName);
	}

}
