
package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public ResourceBundle rb;//to read config.properties
	
	public static WebDriver driver;
	
	public Logger logger;
	
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")//getting browser parameters from testng.xml
	
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		
		if(br.equalsIgnoreCase("chrome"))
			{
			logger.info("Launching Chrome Browser...");
			
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
			
			driver=new ChromeDriver(options);
			}
		else if(br.equalsIgnoreCase("edge"))
		{
			logger.info("Launching edge Browser...");
			driver=new EdgeDriver();
		}
		else if(br.equalsIgnoreCase("safari"))
		{
			logger.info("Launching safari Browser...");
			driver=new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));   // local URL from config.properties file
		//driver.get("https://demo.opencart.com/index.php");   // remote App URL
		logger.info("Launching Browser...");
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1920,1080));
	}
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
		logger.info("Closing application....");
		driver.close();
	}

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyymmdhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
	
	try 
	{
		FileUtils.copyFile(source, new File(destination));
	} 
	catch (Exception e) 
	{
		e.getMessage();
	}
	return destination;

	}
	

}
