package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.config.TestConfig;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.className("title");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(TestConfig.getRequired("base.url"));
        visible(usernameInput);
    }

    public void enterUsername(String username) {
        var usernameField = visible(usernameInput);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        var passwordField = visible(passwordInput);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        clickable(loginButton).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isProductsPageVisible() {
        return visible(productsTitle)
                .getText()
                .trim()
                .equalsIgnoreCase("Products");
    }
}
