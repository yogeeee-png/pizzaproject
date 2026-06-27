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
    
    @FindBy(xpath="//h2[text()='supreme']")
    WebElement recommendedsection;
    
    @FindBy(xpath="(//div[text()='Veggie Feast'])[1]")
    WebElement recommedPizza;
    
    @FindBy(xpath="//button[@data-synth='button--veggie-feast-recommended-pan-personal--one-tap']//span[contains(text(),'Add')]")
    WebElement addPizza;
    
    @FindBy(xpath="//span[@class='bg-green-dark pl-5 pr-5 rounded']")
    WebElement cartCount;
    
    @FindBy(xpath="//div[@class='basket-item-product-price leading-tight bold text-15 text-black']")
    WebElement pizzaPrice;
    
    
    @FindBy(xpath="//div[@class='display-supplement-value']")
    WebElement handlingCharge;
    
    @FindBy(xpath="(//div[@class='flex justify-between items-start']/span)[2]")
    WebElement taxTotal;
    
    @FindBy(xpath="//span[@class='amountdue']")
    WebElement payabletotal;
    
    @FindBy(xpath="//span[@class='ml-auto text-right']/span")
    WebElement checkoutbuttonTotal;
    
    @FindBy(xpath="//a[@data-synth='link--desserts--side']/following-sibling::a/span")
    WebElement drinkTab;
    
    @FindBy(xpath="//div[text()='Pepsi - 475ml']")
    WebElement pepsi;
    
    @FindBy(xpath="//div[contains(@class, 'list-item__name') and contains(text(), 'Pepsi - 475ml')]/following-sibling::div[@class='mt-auto']//button")
    WebElement addpepsi;
    
    @FindBy(xpath="//div[text()='Personal Veggie Feast']/following-sibling::div")
    WebElement cartPizzPrice;

    @FindBy(xpath="(//div[text()='Pepsi - 475ml']/following-sibling::div)[3]")
    WebElement pepsiPrice;
    
    @FindBy(xpath="//button[@data-synth='basket-item-remove--veggie-feast-recommended-pan-personal']")
    WebElement remvovePizza;
  
    @FindBy(xpath="//button[@class='button button--primary  justify-between']")
    WebElement checkoutButton;
    
    @FindBy(xpath="//div[@class='pt-20 bg-white p-20 m-20 rounded text-center shadow relative']")
    WebElement miniumOrder;
    
    public void clickVeg() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(toggle));
        toggle.click();
    }

    public void clickPizza() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement pizzaTab = wait.until(ExpectedConditions.elementToBeClickable(pizza));
        pizzaTab.click();
    }
    
    public void ScrollRecommended() {
    	new Actions(driver).scrollToElement(recommendedsection).perform();
    }
    public String Pizzname() {
    	return recommedPizza.getText();
    }
    
    public void Addpizza() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.elementToBeClickable(addPizza));
    	addPizza.click();
    }
    public int pizzPrice() {
    	 String price=cartPizzPrice.getText();
    	 return Integer.parseInt(price);
    }
    
    public String cartItemCount() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(cartCount));
    	return cartCount.getText();
    }
    
    public double cartPizzaPrcie() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(pizzaPrice));
    	String price=pizzaPrice.getText();
    	return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }
    
    public double resturantHandlingCharge() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(handlingCharge));
    	String price=handlingCharge.getText();
    	return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }
    
    public double totalTax() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(taxTotal));
    	String price=taxTotal.getText();
    	return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }
    public double total() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(payabletotal));
    	String price=payabletotal.getText();
    	return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }
    
    public double checkoutButtonTotal() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOf(checkoutbuttonTotal));
    	String price=checkoutbuttonTotal.getText();
    	return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }
    
    public void clickDrinksTab() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(drinkTab));
        drinkTab.click();
    }
    public void ScrollPessi() {
    	new Actions(driver).scrollToElement(pepsi).perform();
    }
    
    public void addPepsi() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(addpepsi));
        addpepsi.click();
    }
    
    public int pepsiPrice() {
   	 String price=pepsiPrice.getText();
   	 return Integer.parseInt(price.replaceAll("[^0-9]", ""));
   }
    
    public void clickRemovePizza() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(remvovePizza));
        remvovePizza.click();
    }
    
    public void clickCheckout() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }
    public boolean minimumOrderpopup() {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(miniumOrder));
        return miniumOrder.isDisplayed();
    }
    
}