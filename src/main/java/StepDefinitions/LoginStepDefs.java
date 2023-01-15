package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static StepDefinitions.StepDefsHelper.*;

public class LoginStepDefs {

    WebDriver driver= getDriver();
    LoginPage loginpage= new LoginPage();
    HomePage homepage= new HomePage();
    public LoginStepDefs() throws IOException {
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

    @And("clicks on {string} on {string}")
    public void clicksOnOn(String element, String page) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        if(page.equals("LoginPage")){
            driver.findElement(loginpage.get(element)).click();
        } else if (page.equals("HomePage")) {
            driver.findElement(homepage.get(element)).click();
        }
    }
}
