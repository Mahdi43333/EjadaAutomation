package Com.Ejada.Core.Base.WebTestBase;

import Com.Ejada.Core.Helpers.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FireFoxBrowser {
    public WebDriver driver;
    public ActionHelper action;


    @BeforeClass
    public void setUp(){
        action = new ActionHelper();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public WebDriver getWebDriver(){
        if (driver == null){
            driver = new FirefoxDriver();
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
