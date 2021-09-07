package wyscout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage  {

	@FindBy(xpath = "(//span[text()='Platform'])[1]") private WebElement VerifyText;
	
	
}
	
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public String VeryText() {
		
		String actText = VerifyText.getText();
		return actText;
		}
	
}
	
	

