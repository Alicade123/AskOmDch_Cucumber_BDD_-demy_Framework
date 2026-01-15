package askomdch.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryForPARALLEL {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        DriverFactoryForPARALLEL.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
}
