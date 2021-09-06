package wyscout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage  {

	@FindBy(xpath = "//input[@id='login_username']") private WebElement UN;
	@FindBy(xpath = "//input[@id='login_password']") private WebElement PWD;
	@FindBy(xpath = "//button[@id='login_button']") private WebElement SIGN_IN;
	@FindBy(xpath = "//div[text()='Invalid username or password']") private WebElement errormsg;
	@FindBy(xpath = "//a[text()='Lost your password?']") private WebElement lostpassword;
	@FindBy(xpath = "//button[text()='Recovery']") private WebElement recovery;
	
	
	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void inpEnterUserName(String username) {
		UN.sendKeys(username);
	}
	
	public void inpEnterPassword(String password) {
		PWD.sendKeys(password);
	}
	
	public void clickSignIn() {
		SIGN_IN.click();
	}
	
	public String check() {
		String errormessage = errormsg.getText();
		
		return errormessage;
	}
	
	public void lostpassword() {
		lostpassword.click();
	}
	
	public void recovery() {
		 
	boolean result = recovery.isDisplayed();
	if(result) {
		System.out.println("window is opening");
	}
		
		
	}
	
	
	
	
}

