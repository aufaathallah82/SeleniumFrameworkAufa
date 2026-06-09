package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StandaloneYoutubeDemo {

    private WebDriver webDriver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-fullscreen");
        options.addArguments("--remote-allow-origin=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().fullscreen();
        webDriver.get("https://www.youtube.com/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void openYoutubeGuide() {
        webDriver.findElement(By.xpath("//*[@id=\"guide-button\"]")).click();
    }

    @AfterTest
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
