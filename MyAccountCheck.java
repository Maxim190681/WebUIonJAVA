package org.example.HW6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountCheck extends BasePage {
    public MyAccountCheck(WebDriver driver) {
        super(driver);
    }
    public final static String XPASS = "//h1[@class='static_h1']";

    @FindBy(xpath = "//h1[@class='static_h1']")
     public WebElement checkElement;

     public void checkElement() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPASS)));
        Assertions.assertEquals(checkElement.isDisplayed(), true);
    }


}
