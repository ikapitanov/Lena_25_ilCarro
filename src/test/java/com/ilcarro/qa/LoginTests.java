package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //goTo login page
        if (!isLoginFormPresent()) {
            click(By.cssSelector("[href='/login']"));
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //aa@bb109.com
        //aa@bb110.com
        //fillLoginForm
        type(By.name("email"), "aa@bb109.com");
        type(By.name("password"), "1Aaaaaaaa");


        //submit login
        submitForm();


        //Assert userLoggedIn
    }

}
