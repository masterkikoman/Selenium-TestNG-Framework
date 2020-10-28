package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	
	public WebDriver driver;
	
	By search = By.xpath("//*[@id='delivery-information-postal-index']");
	By suggestion = By.xpath("//*[@id='address-suggestions']/ul/li");
	By delivery = By.xpath("//*[text()='Delivery']");
	By findRestaurants = By.xpath("//*[@id='submit-location']");
	By footerCountries = By.xpath("//*[@class='othercountries']");
	By login = By.xpath("//*[@class='login-label']");	
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public WebElement getSearch() {
		
		return driver.findElement(search);
	}
	
	public List<WebElement> getSuggestion() {
		
		return driver.findElements(suggestion);
	}
	
	public WebElement getDelivery() {
		
		return driver.findElement(delivery);
	}
	
	public RestoPage getFindRestaurants() {
		
		
		driver.findElement(findRestaurants).click();
		RestoPage restoPage = new RestoPage(driver);
		return restoPage;
	
	}
	
	public WebElement getFooterCountries() {
		
		return driver.findElement(footerCountries);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	
}
