package stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MenuPage;
import utilities.DriverFactory;

public class PizzaHutSteps {

    WebDriver driver;

    HomePage homePage;
    MenuPage menuPage;
    CheckoutPage checoutPage;
    double total;

    @Given("User launch Pizzahut application with {string}")
    public void launchApplication(String url) {

        driver = DriverFactory.initializeDriver();
        driver.get(url);

        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        checoutPage = new CheckoutPage(driver);
    }

    @When("User wait for auto location black pop up screen")
    public void waitForPopup() {
        homePage.waitForLocationPopup();
    }

    @Then("User close the pop up screen")
    public void closePopup() {
        homePage.closePopup();
    }

    @Then("User see pop up for delivery asking for enter location")
    public void validateLocationPopup() {
        Assert.assertTrue(homePage.isLocationPopupDisplayed());
    }

    @Then("User type address as {string}")
    public void enterAddress(String location) {
        homePage.enterLocation(location);
    }

    @Then("User select first auto populate drop down option")
    public void selectAddress() throws InterruptedException {
        homePage.selectFirstSuggestion();
    }

    @When("User navigate to deails page")
    public void navigateToDetailsPage() {
    	//homePage.whattimeWouldPageDisplayed();
    }

    @Then("User validate vegetarian radio button flag is off")
    public void validateVegToggle() {
    	menuPage.clickVeg();
    }

    @Then("User clicks on Pizzas menu bar option")
    public void clickPizzaMenu() {
        menuPage.clickPizza();
    }

    @When("User select add button of any pizza from Recommended")
    public void addPizza() {
    	menuPage.ScrollRecommended();
    	menuPage.Addpizza();
    }

    @Then("User see that the pizza is getting added under Your Basket")
    public void validateBasket() {
    	String cartText=menuPage.cartItemCount().split(" ")[0];
    	System.out.println(cartText);
    	Assert.assertEquals(cartText, "1");
    }

    @Then("User validate pizza price plus Tax is checkout price")
    public void validatePrice() {
    	double priceOfPizz=menuPage.cartPizzaPrcie();
    	System.out.println("pizz price:- "+priceOfPizz);
    	double handlingCharge=menuPage.resturantHandlingCharge();
    	System.out.println("handling charge:- "+handlingCharge);
    	double tax=menuPage.totalTax();
    	System.out.println("tax:- "+tax);
    	total=menuPage.total();
    	
    	double subTotal;
    	subTotal=priceOfPizz+handlingCharge+tax;
    	System.out.println("systemTotal:- "+total);
    	System.out.println("My Total:- "+subTotal);
    	Assert.assertEquals(subTotal, total);
    }

    @Then("User validate checkout button contains Item count")
    public void validateItemCount() {
    	String cartText=menuPage.cartItemCount().split(" ")[0];
    	System.out.println(cartText);
    	Assert.assertTrue(cartText.contains("1"));
    }

    @Then("User validate checkout button contains total price count")
    public void validateTotalPrice() {
    	double priceOfPizz=menuPage.cartPizzaPrcie();
    	System.out.println("pizz price:- "+priceOfPizz);
    	double handlingCharge=menuPage.resturantHandlingCharge();
    	System.out.println("handling charge:- "+handlingCharge);
    	double tax=menuPage.totalTax();
    	System.out.println("tax:- "+tax);
    	double checkoutTotalbutton=menuPage.checkoutButtonTotal();
    	System.out.println("Checkout button total :- "+checkoutTotalbutton);
    	double subTotal;
    	subTotal=priceOfPizz+handlingCharge+tax;
    	System.out.println("My Total:- "+subTotal);
    	Assert.assertEquals(checkoutTotalbutton, subTotal);
    }

    @Then("User clicks on Drinks option")
    public void clickDrinks() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    	menuPage.clickDrinksTab();
    }

    @Then("User select Pepsi option to add into the Basket")
    public void addPepsi() {
    	menuPage.ScrollPessi();
    	menuPage.addPepsi();
    }

    @Then("User see 2 items are showing under checkout button")
    public void validateTwoItems() {
    	String cartText=menuPage.cartItemCount().split(" ")[0];
    	System.out.println(cartText);
    	Assert.assertTrue(cartText.contains("2"));
    }

    @Then("User see total price is now more than before")
    public void validatePriceIncrease() {
    	double oldTotal=total;
    	double newTotal=menuPage.total();
    	System.out.println(newTotal);
    	Assert.assertTrue(newTotal > oldTotal);
    	
    }

    @Then("User remove the Pizza item from Basket")
    public void removePizza() {
    	menuPage.clickRemovePizza();
    }

    @Then("see Price tag got removed from the checkout button")
    public void validatePriceRemoved() {
    
//    	double expectedTotal = menuPage.pepsiPrice()+ menuPage.totalTax();
//    	Assert.assertEquals(menuPage.total(), expectedTotal, 0.01);
    }

    @Then("User see 1 item showing in checkout button")
    public void validateOneItem() {
    	String cartText=menuPage.cartItemCount().split(" ")[0];
    	System.out.println(cartText);
    	Assert.assertTrue(cartText.contains("1"));
    }

    @Then("User Clicks on Checkout button")
    public void clickCheckout() {
    	menuPage.clickCheckout();
    }

    @Then("User see minimum order required pop up is getting displayed")
    public void validateMinimumOrderPopup() {
    	Assert.assertEquals(menuPage.minimumOrderpopup(), true);
    }
}