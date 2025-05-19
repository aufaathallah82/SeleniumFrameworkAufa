import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static ChromeOptions options;
    public static WebDriver webDriver;

@BeforeTest
    public static void setup(){
    options = new ChromeOptions();
    options.addArguments("--incognito", "--start-maximized");
    options.addArguments("--remote-allow-origin=*");
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/test/resources/chromedriver.exe");
    System.setProperty("webdriver.http.factory", "jdk-http-client");
    webDriver = new ChromeDriver(options);
    webDriver.get("https://www.youtube.com/");
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    void Login(){
    webDriver.findElement(By.xpath("//*[@id=\"guide-button\"]")).click();

    }
}
