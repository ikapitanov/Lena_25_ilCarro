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
    public void testSignUp() throws InterruptedException {
        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        fillRegistrationForm(
                new User()
                        .withFirstName("AS")
                        .withSecondName("FV")
                        .withEmail("aa@bb118.com")
                        .withPassword("1Aaaaaaaa"));

        click(By.cssSelector("#check_policy"));
        pause(2000);
        submitForm();

        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


    @Test
    public void testSignUpWithopoutPassword() throws InterruptedException {
        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

        fillRegistrationForm(new User()
                .withFirstName("Vasya")
                .withSecondName("Katz")
                .withEmail("vasya.katz1@gmail.com"));

        click(By.cssSelector("#check_policy"));
        pause(3000);
        //click submit button
       // submitForm();

        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());
    }
    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }


}
