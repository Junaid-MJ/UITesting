package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.YourCartPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static StepDefinitions.StepDefsHelper.*;

public class GlobalStepDefs {

    WebDriver driver= getDriver();
    LoginPage loginpage= new LoginPage();
    HomePage homepage= new HomePage();
    YourCartPage yourCartPage= new YourCartPage();
    public GlobalStepDefs() throws IOException {
    }

    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() throws IOException {
       driver.get( ReadSystemProperties().get("baseURL").toString());
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }


    @Then("Validate that login is successful and User is navigated to Homepage")
    public void validate_that_login_is_successful_and_user_is_navigated_to_homepage() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(loginpage.getProductLabel()).isDisplayed();
    }

    @Then("Validate that login is unsuccessful and warning message is displayed")
    public void validateThatLoginIsUnsuccessfulAndWarningMessageIsDisplayed() {
        String actualMessage= driver.findElement(loginpage.getWarningMessage()).getText();
        String expectedMessage= "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @And("User Enters the username as {string} and password as {string}")
    public void userEntersTheUsernameAsAndPasswordAs(String username, String password) {
        driver.findElement(loginpage.getUsernameTxtBox()).sendKeys(username);
        driver.findElement(loginpage.getPasswordTxtBox()).sendKeys(password);
    }


    @When("User selects {string} from {string}")
    public void userSelectsFrom(String option, String list) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        driver.findElement(homepage.get(list)).click();
        Thread.sleep(2000);
        driver.findElement(homepage.get(option)).click();
    }

    @Then("Validate that user has logged out successfully")
    public void validateThatUseHasLoggedOutSuccessfully() {
        driver.findElement(loginpage.LoginButton()).isDisplayed();
    }

    @And("User clicks on {string} on {string}")
    public void clicksOnOn(String element, String page) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        if(page.equals("LoginPage")){
            driver.findElement(loginpage.get(element)).click();
        } else if (page.equals("HomePage")) {
            driver.findElement(homepage.get(element)).click();
        }else if (page.equals("YourCartPage")) {
            driver.findElement(yourCartPage.get(element)).click();
        }
    }

    @And("User quits the browser")
    public void userQuitsTheBrowser() {
        driver.close();
        driver.quit();
    }

    @When("User adds {string} to cart")
    public void userAddsToCart(String productname) {
        homepage.setProduct(productname);
        driver.findElement(homepage.getProduct()).click();
    }

    @Then("Validate that the {string} product is placed in the cart")
    public void validateThatTheProductIsPlacedInTheCart(String productname) {
        driver.findElement(homepage.CartButton()).click();
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[@class='cart_item']//a"));
        boolean isPresent=false;
        for(WebElement e:listOfProducts){
            if(e.getText().equals(productname)){
                isPresent=true;
            }
        }
        Assert.assertEquals(true, isPresent);
    }

    @Then("User validate that the {string} is removed from th cart")
    public void userValidateThatTheIsRemovedFromThCart(String productname) {
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[@class='cart_item']//a"));
        boolean isPresent=false;
        if(!listOfProducts.isEmpty()){
            for(WebElement e:listOfProducts){
                if(e.getText().equals(productname)){
                    isPresent=true;
                }
            }
        }
        Assert.assertEquals(false, isPresent);

    }
}
