package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @Before
    public void setUp() {
        DRIVER.set(DriverFactory.createDriver());
    }

    @After
    public void tearDown() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}
