package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import hooks.Hooks;
import org.testng.Assert;
import pages.LoginPage;

public class LoginStepDef {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage = new LoginPage(Hooks.getDriver());
        loginPage.open();
    }

    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user should see the products page")
    public void theUserShouldSeeTheProductsPage() {
        Assert.assertTrue(loginPage.isProductsPageVisible(), "Products page was not displayed");
    }
}
