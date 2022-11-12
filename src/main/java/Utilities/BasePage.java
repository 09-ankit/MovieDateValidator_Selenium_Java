package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	
	public static WebDriver driver;
	
	//Pass base URL and set PageLoadTimeout and Implicit TimeOut
	public static void initialization()
	{		
		//User need to Set Chrome driver Path
		System.setProperty("webdriver.chrome.driver", "D:\\sel fils\\Ankit\\New folder\\chromedriver.exe");
		driver = new ChromeDriver(); 								
		driver.manage().window().maximize();   //maximize window
		driver.manage().deleteAllCookies();   //delete all cookies before lauch
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);  //Set timeout Ranges
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);		
	}
	
	//Screenshot Method
	public static void getScreenshot(String screenshotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		 File source =ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
	}

	
}
