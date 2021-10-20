package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class HomePage extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void first() throws IOException
	{
		driver = initializeDriver();
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    LandingPage lp = new LandingPage(driver);
		lp.Login().click();
		log.info("successfully initialized the browser before 2 combinations of test");
	    
	}
	
	@Test(dataProvider="getdata")
	
	public void basePageNavigation(String uname, String pswd, String text) 
	{
		
		
		
		LoginPage pg = new LoginPage(driver);
		pg.Email().sendKeys(uname);
		pg.Password().sendKeys(pswd);
		log.info(text);
		pg.submit().click();	
		
		
	}
	
	@DataProvider
	
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][3];	
		
		
		data[0][0] = "firstuser@gmail.com";
		data[0][1] = "uuuu";	
		data[0][2] = "firstusertesting";
		data[1][0] = "seconduser@gmail.com";
		data[1][1] = "uuuuuu";
		data[1][2] = "secondusertesting";
		
		return data;
		
		
	}
	
	@AfterTest
	public void last()
	{
		
		LoginPage pg = new LoginPage(driver);
		pg.ForgotPassword().click();
		log.info("I clicked on forgot password");
		ForgotPasswordPage fpg = new ForgotPasswordPage(driver);
		fpg.forgotpasswordemail().sendKeys("jjjjjj@gmail.com");
		fpg.submitfpg().click();
		driver.close();
	}
}
