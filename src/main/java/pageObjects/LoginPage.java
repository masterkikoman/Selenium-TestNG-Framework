package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By continueWithEmail = By.xpath("//*[text()='Continue with Email']");
	By email = By.xpath("//*[@id='email']");
	By continueButton = By.xpath("//*[@data-testid='email-view-continue-button']");
	By forgotPassword = By.xpath("//*[text()='Forgot your password?']");
	By resetPassword = By.xpath("//*[@data-testid='forgot-password-view-continue-button']");
	
	public LoginPage(WebDriver driver ) {
		
		this.driver = driver;
	}

	public WebElement getContinueWithEmail() {
		LandingPage landing = new LandingPage(driver);
		landing.getLogin().click();
		
		return driver.findElement(continueWithEmail);
	}
	
	public WebElement getEmail() {

		
		return driver.findElement(email);
	}
	
	public WebElement getContinueButton() {
		
		return driver.findElement(continueButton);
	}
	
	public WebElement getForgotPassword() {
		
		return driver.findElement(forgotPassword);
	}
	
	public WebElement getResetPassword() {
		
		return driver.findElement(resetPassword);
	}
	
	

}
