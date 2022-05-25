package org.example.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) { // конструктор Alt+ins (none)
        super(driver);
    }

    @FindBy(xpath = "//div//span[text()='Войти']")
    public WebElement GoToLoginPage;

    @FindBy(xpath = "//div[@class ='col-md-4']/input[@id='email']")
    public WebElement InputLogin;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement InputPwd;

    @FindBy(xpath = "//div[@class='col-md-4 col-md-offset-4']/input")
    public WebElement EnterToAccount;


    public MyAccountCheck login (String email, String pwd) {
        GoToLoginPage.click();
        InputLogin.sendKeys(email);
        InputPwd.sendKeys(pwd);
        EnterToAccount.click();
        return new MyAccountCheck(driver);

    }

}
