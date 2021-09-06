package wyscout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class TestPage extends Baseclass {
	

	loginPage login;
	Sheet sh;
	homePage home;

	@BeforeMethod
	public void openBrowser() throws EncryptedDocumentException, IOException {
		Reporter.log("opening browser",true);
		
		FileInputStream file=new FileInputStream("G:\\RAGINI\\wyscout.xlsx");
	    sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
	     initializeBrowser();
		     
	      login=new loginPage(driver);
	      home=new homePage(driver);
	      
	     
	}
	@Test
	 public void TestCase1() {
	    Reporter.log("running correct username and correct password",true);
	    
	    login.inpEnterUserName(sh.getRow(0).getCell(0).getStringCellValue()); 
	    login.inpEnterPassword(sh.getRow(0).getCell(1).getStringCellValue());
	    login.clickSignIn();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    String actText = home.VeryText();
	    String expText = sh.getRow(4).getCell(0).getStringCellValue();
	    if(actText.equals(expText)) {
	    	driver.findElement(By.xpath("//div[@class='account_thumb']")).click();
	    	driver.findElement(By.xpath("//a[@command='logout']")).click();
	    }
	    else {
	    	System.out.println("invalid username or password");
	    }
	    
	}
	
	@Test
	public void TestCase2() {
		 Reporter.log("running incorrect username and correct password",true);
		
		login.inpEnterUserName(sh.getRow(1).getCell(0).getStringCellValue());
		login.inpEnterPassword(sh.getRow(1).getCell(1).getStringCellValue());
		login.clickSignIn();
		String acttect = login.check();
		    String expText = sh.getRow(5).getCell(0).getStringCellValue();
		    if(acttect.equals(expText)) {
		    System.out.println("invalid username or password");
		    }
		
		
	}
	
	@Test
	public void TestCase3() {
		Reporter.log("running correct username and incorrect password",true);
		
		login.inpEnterUserName(sh.getRow(2).getCell(0).getStringCellValue());
		login.inpEnterPassword(sh.getRow(2).getCell(1).getStringCellValue());
		login.clickSignIn();
		String acttect = login.check();
	    String expText = sh.getRow(5).getCell(0).getStringCellValue();
	    if(acttect.equals(expText)) {
	    System.out.println("invalid username or password");
	    }
		
		
	}
	
	@Test
	public void TestCase4() {
		Reporter.log("running incorrect username and incorrect password",true);
		
		login.inpEnterUserName(sh.getRow(3).getCell(0).getStringCellValue());
		login.inpEnterPassword(sh.getRow(3).getCell(1).getStringCellValue());
		login.clickSignIn();
		String acttect = login.check();
	    String expText = sh.getRow(5).getCell(0).getStringCellValue();
	    if(acttect.equals(expText)) {
	    System.out.println("invalid username or password");
	    }
		
	}
	
	@Test
	public void TestCase5() {
		Reporter.log("clicking lost password link",true);
		login.lostpassword();
		driver.switchTo().frame(0);
		login.recovery();
		
	}
	
	@AfterMethod
	public void CloseBrowser() {
		
		driver.close();
	}
	     
	    
	    
		
	}


