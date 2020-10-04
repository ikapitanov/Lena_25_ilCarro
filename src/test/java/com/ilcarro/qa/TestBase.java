package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isFindCarFormPresent(){
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
    }

    public boolean isFindCarFormPresent2(){
    return isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
    }

    public boolean isElementPresent2(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();
    }

    public boolean isLoginFormPresent() {
        return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }
}
