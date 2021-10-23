package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	private By email = By.id("user_email");
	
	private By password = By.id("user_password");
	
	private By submit = By.cssSelector("input.btn.btn-primary.btn-md.login-button");
	
	private By forgotlink = By.cssSelector("a.link-below-button");
	
	private By error = By.cssSelector("div.alert.alert-danger.alert-show.mb-5");
	

	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}



	public WebElement Email()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement submit()
	{
		return driver.findElement(submit);
		
	}
	
	public WebElement ForgotPassword()
	{
		return driver.findElement(forgotlink);
	}
	
	public WebElement errormsg()
	{
		return driver.findElement(error);
	}
	
}
