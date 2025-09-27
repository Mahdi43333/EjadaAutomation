package Com.Ejada.Core.Base.WebTestBase;

import Com.Ejada.Core.Helpers.ActionHelper;
import Com.Ejada.Core.Report.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ChromeBrowser {
    protected  WebDriver driver;
    public ActionHelper action;
    @Parameters("browser")

    @BeforeClass
    public void setUp(String browser){
        action = new ActionHelper();
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public WebDriver getWebDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
        }

        return driver;
    }

    @AfterClass
    public void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
