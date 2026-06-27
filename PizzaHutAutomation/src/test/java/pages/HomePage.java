package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@placeholder,'location')]")
	WebElement locationTextbox;
	@FindBy(xpath="//p[@class='typography-2 mb-40 text-center']/span")
	WebElement ordertimepage;
	
	@FindBy(xpath="//button[@class='button button--secondary text-center']//span")
	WebElement startOrder;
	
	public void waitForLocationPopup() {
	}

	public void closePopup() {
	}

	public boolean isLocationPopupDisplayed() {
		return locationTextbox.isDisplayed();
	}

	public void enterLocation(String location) {

		locationTextbox.clear();
		locationTextbox.sendKeys(location);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectFirstSuggestion() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-item-type='link']/following-sibling::button[@role='option'][1]")));

		System.out.println("Suggestion text = " + suggestion.getText());

		suggestion.click();

		System.out.println("Address suggestion clicked");
		Thread.sleep(2000);

		System.out.println("URL after click = " + driver.getCurrentUrl());
	}
	public void whattimeWouldPageDisplayed() {
			if(ordertimepage.isDisplayed()) {
				startOrder.click();
			}else {
				System.out.println("continue");
			}
	}

}