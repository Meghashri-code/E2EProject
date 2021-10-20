package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By title = By.xpath("//*[text()='Featured Courses']");
	
	private By login = By.xpath("//*[text()='Login']");
	
	private By navbar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	
	private By banner = By.cssSelector("div[class*='video-banner'] h3");




	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}


	public WebElement Title()
	{
		return driver.findElement(title);
		
	}
	

	public WebElement Login()
	{
		return driver.findElement(login);
		
	}
	
	public WebElement Navigation()
	{
		return driver.findElement(navbar);
		
	}
	
	public WebElement videobanner()
	{
		return driver.findElement(banner);
		
	}
	
	
	

}
