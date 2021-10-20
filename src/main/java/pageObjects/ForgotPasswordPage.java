package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	By femailid = By.id("user_email");
	By button = By.cssSelector("input.btn.btn-primary.btn-md.login-button");
	
	public ForgotPasswordPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	
	public WebElement forgotpasswordemail()
	{
		return driver.findElement(femailid);
	}
	
	public WebElement submitfpg()
	{
		return driver.findElement(button);
	}


}
