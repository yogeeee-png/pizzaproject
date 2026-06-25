package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.MenuPage;
import utilities.DriverFactory;

public class PizzaHutSteps {

    WebDriver driver;

    HomePage homePage;
    MenuPage menuPage;

    @Given("User launch Pizzahut application with {string}")
    public void launchApplication(String url) {

        driver = DriverFactory.initializeDriver();
        driver.get(url);

        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
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
    }

    @Then("User validate pizza price plus Tax is checkout price")
    public void validatePrice() {
    }

    @Then("User validate checkout button contains Item count")
    public void validateItemCount() {
    }

    @Then("User validate checkout button contains total price count")
    public void validateTotalPrice() {
    }

    @Then("User clicks on Drinks option")
    public void clickDrinks() {
    }

    @Then("User select Pepsi option to add into the Basket")
    public void addPepsi() {
    }

    @Then("User see 2 items are showing under checkout button")
    public void validateTwoItems() {
    }

    @Then("User see total price is now more than before")
    public void validatePriceIncrease() {
    }

    @Then("User remove the Pizza item from Basket")
    public void removePizza() {
    }

    @Then("see Price tag got removed from the checkout button")
    public void validatePriceRemoved() {
    }

    @Then("User see 1 item showing in checkout button")
    public void validateOneItem() {
    }

    @Then("User Clicks on Checkout button")
    public void clickCheckout() {
    }

    @Then("User see minimum order required pop up is getting displayed")
    public void validateMinimumOrderPopup() {
    }
}