package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

    WebDriver driver;

    public MenuPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@class='rounded-full bg-white']")
    WebElement toggle;

    @FindBy(xpath="//a[contains(.,'Pizzas')]")
    WebElement pizza;

    public void clickVeg() {
        toggle.click();
    }

    public void clickPizza() {

        System.out.println("Current URL : "
                + driver.getCurrentUrl());

        System.out.println("Contains Pizzas text : "
                + driver.getPageSource().contains("Pizzas"));

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement pizzaTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        org.openqa.selenium.By.xpath(
                                "//a[contains(.,'Pizzas')]")));

        pizzaTab.click();
    }
    public boolean isVegToggleOn() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.visibilityOf(toggle));

            return toggle.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
   
    public boolean isMenuPageDisplayed() {

        System.out.println("Current URL : "
                + driver.getCurrentUrl());

        return driver.getCurrentUrl().contains("order");
    }
    }