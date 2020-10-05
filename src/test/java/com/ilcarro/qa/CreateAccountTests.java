package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //preconditions: user shoud be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignUpTabPresentInHeader()) {    //sign up not present
            logOut();
        }
    }

    @Test
    public void testSignUp() {
        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));


        //fill registration form
        type(By.cssSelector("#first_name"), "AS");
        type(By.cssSelector("#second_name"), "FV");
        type(By.cssSelector("#email"), "aa@bb115.com");
        type(By.cssSelector("#password"), "1Aaaaaaaa");

        click(By.cssSelector("#check_policy"));

        //click submit button
        submitForm();

        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());
    }




}
