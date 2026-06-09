package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.className("title");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getDurationSeconds("timeouts.explicit.seconds")));
    }

    public void open() {
        driver.get(ConfigReader.getRequiredProperty("base.url"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isProductsPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle))
                .getText()
                .trim()
                .equalsIgnoreCase("Products");
    }
}
