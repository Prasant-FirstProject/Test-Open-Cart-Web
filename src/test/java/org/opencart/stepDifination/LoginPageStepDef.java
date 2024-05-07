package org.opencart.stepDifination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef
{
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup()
    {
        driver= new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        if(driver != null){
            driver.quit();
        }
    }

    @Given("^I am on the OpenCart login page$")
    public void IAmOnTheOpenLoginPage()
    {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Given("^I have entered a valid username and password$")
    public void IHaveEnteredAValidUsernameAndPassword()
    {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @When("^I click on the login button$")
    public void Iclickontheloginbutton()
    {
        loginPage.clickLoginButton();
    }

    @Then("^I should be logged in successfully$")
    public void Ishouldbeloggedinsuccessfully()
    {
        Assert.assertEquals(loginPage.isLogoutDisplayed(), true);
    }

    @Given("^I have entered invalid (.*) and (.*)$")
    public void IHaveEnteredInValidUsernameAndPassword(String email, String password)
    {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("^I should see an error message indicating (.*)$")
    public void IHaveEnteredAValidUsernameAndPassword(String errorMessage)
    {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }

    @Given("^I click on the \"Forgot Password\" link$")
    public void IclickontheForgotPasswordlink()
    {
        loginPage.clickForgotLinkButton();
    }

    @Then("^I should see the Forgot password page$")
    public void IshouldseetheForgotpasswordpage()
    {
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
    }
}
