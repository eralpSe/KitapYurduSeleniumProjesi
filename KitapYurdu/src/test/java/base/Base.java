package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class Base {


    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected String firstUrl = "https://www.kitapyurdu.com/";


    @Before
    public void beforeMethod() {
        Log.info("Test başlıyor.");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.setExperimentalOption("w3c", false);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        Log.info("Driver ayağa kaldırıldı.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        driver.manage().window().maximize();
        Log.info("Driver maximize modda açıldı.");


    }


    @After
    public void afterMethod() {
        if (driver != null) {
            driver.close();
            driver.quit();
            Log.info("Test sona erdi.");
        }
    }


}
