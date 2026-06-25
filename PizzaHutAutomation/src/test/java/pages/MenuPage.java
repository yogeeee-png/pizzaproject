package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

    WebDriver driver;
    WebDriverWait wait;

    public MenuPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='hidden 2xl:flex w-full']//span[@class='rounded-full bg-white']")
    WebElement toggle;

    @FindBy(xpath="//a[@class='typography-4 side-menu__link side-menu__link--pizzas text-white lg:text-black  capitalize lg:border-r']")
    WebElement pizza;
    
    @FindBy(xpath="//button[@data-synth='button--veggie-feast-recommended-pan-personal--one-tap']//span[contains(text(),'Add')]")
    WebElement addPizza;
    
    @FindBy(xpath="(//div[text()='Veggie Feast'])[1]")
    WebElement recommedPizza;


    public void clickVeg() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(toggle));
        toggle.click();
    }

    public void clickPizza() {

        System.out.println("Current URL : "+ driver.getCurrentUrl());
        wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement pizzaTab = wait.until(ExpectedConditions.elementToBeClickable(pizza));
        pizzaTab.click();
    }
    public void Addpizza() {
    	WebElement recommended=driver.findElement(By.xpath("//h2[text()='supreme']"));
    	new Actions(driver).scrollToElement(recommended).perform();
    	addPizza.click();
    }
    
    public void getRecommedPizza() {
    	recommedPizza.getText();
    }
    }