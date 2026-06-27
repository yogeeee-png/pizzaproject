package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	 WebDriverWait wait;
	 public CheckoutPage(WebDriver driver) {

	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
}
