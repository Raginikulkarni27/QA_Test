package wyscout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass {

	static WebDriver driver;
	
	public static void initializeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\RAGINI\\chrome\\chromedriver.exe\\");
	     driver = new ChromeDriver();
	    
	    driver.get("https://platformrc.wyscout.com/app/");
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	    
	}
}
