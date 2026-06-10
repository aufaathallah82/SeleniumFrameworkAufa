package support.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import support.config.TestConfig;

import java.nio.file.Path;
import java.time.Duration;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        Path driverPath = Path.of(System.getProperty("user.dir"), TestConfig.getRequired("chrome.driver.path"));
        System.setProperty("webdriver.chrome.driver", driverPath.toString());
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");

        if (Boolean.parseBoolean(TestConfig.getRequired("browser.start.fullscreen"))) {
            options.addArguments("--start-fullscreen");
        }

        if (Boolean.parseBoolean(TestConfig.getRequired("browser.headless"))) {
            options.addArguments("--headless=new");
        }

        WebDriver driver = new ChromeDriver(options);

        if (Boolean.parseBoolean(TestConfig.getRequired("browser.start.fullscreen"))) {
            driver.manage().window().fullscreen();
        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(TestConfig.getSeconds("timeouts.implicit.seconds")));

        return driver;
    }
}
