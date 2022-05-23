package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetToLoginPage extends BasePage{
    public RetToLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-sm-4 col-lg-3 left_nav_column']//a[text()='Выйти']")
    public WebElement ReturnToLogPage;

    public void ReturnToLogPage() {
        ReturnToLogPage.click();
    }
}
