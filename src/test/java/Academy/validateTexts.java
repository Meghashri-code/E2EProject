package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;


@Test
public class validateTexts extends base {
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage lp;
	
	@BeforeTest
	public void first() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver Initiated");
	    driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	    
	}

	public void gettitle() 
	{
		
		
	
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.Title().getText(), "FEATURED COURSES");
		Assert.assertTrue(lp.Navigation().isDisplayed());
		log.info("Successfully validated text message");
		
	
	
}
	
	public void getbanner() 
	{
		
		
	
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.videobanner().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
		log.info("Successfully validated text message");
		
	
	
}
	@AfterTest
	public void last()
	{
		driver.close();
	}
}
