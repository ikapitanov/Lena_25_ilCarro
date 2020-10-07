package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase{
    @Test
    public void testFormLetTheCarWork(){
        // click(By.cssSelector(".let-carwork-style_let_car__location__30BIh"));

        type(By.name("country"), "Israel");
        type(By.cssSelector(".address"), "Balfour Street");
        type(By.cssSelector(".distance_included"), "500");
        type(By.cssSelector(".serial_number"), "12345679");
        type(By.cssSelector(".brand"), "Volkswagen ");
        type(By.cssSelector(".model"), "Bora");
        type(By.cssSelector(".year"), "2002");
        type(By.cssSelector(".engine"), "1,6");
        type(By.cssSelector(".fuel_consumption"), "8");
        type(By.cssSelector(".fuel"), "petrol");
        type(By.cssSelector(".transmition"), "automatic");
        type(By.cssSelector(".wd"), "wedfrt");
        type(By.cssSelector(".horsepower"), "110");
        type(By.cssSelector(".torque"), "3456");
        type(By.cssSelector(".doors"),"4");
        type(By.cssSelector(".seats"), "5");
        type(By.cssSelector(".class"), "E");
        type(By.name("about"), "dhfhjkglglgkmfjdk");
        type(By.cssSelector(".type_feature"), "dfghjkl");
        type(By.cssSelector(".price"), "87");

        submitForm();

    }
}
