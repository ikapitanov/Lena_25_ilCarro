package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //tests for logintn
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginFormPresent()) {
            if(isUserLoggedIn()){
                logOut();
            }
            clickLoginTabOnHeader();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //aa@bb109.com
        //aa@bb110.com

        fillLoginForm(new User().withEmail("aa@bb109.com").withPassword("1Aaaaaaaa"));

        submitForm();
        Assert.assertTrue(isUserLoggedIn());
        String email = getEmailTextFromHeader();
        System.out.println(email);
        Assert.assertEquals(email, "aa@bb109.com");


    }




}
