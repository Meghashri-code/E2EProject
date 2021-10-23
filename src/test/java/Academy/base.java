package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName= System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver_win32\\chromedriver.exe");	
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("chromeheadless"))
			{
			options.addArguments("--headless");
			
			}
			 driver = new ChromeDriver(options);
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IE.exe");		
			driver = new ChromeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String screenshots(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile =System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
		
	}
	
	
	
	
}





