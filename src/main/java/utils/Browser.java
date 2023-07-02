package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver driver;
    public static void setup(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void tearDown(){
        driver.quit();
    }
}
