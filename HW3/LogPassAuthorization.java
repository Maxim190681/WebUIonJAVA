package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Registration with valid data
 * https://pitbikeclub.ru/
 * Login: zhegunov.m@yandex.ru
 * Password: Test_2
 * Created by Maximz1906891 2022/04
 */
public class LogPassAuthorization {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://pitbikeclub.ru");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div//span[text()='Войти']")).click();


        driver.findElement(By.xpath("//div[@class ='col-md-4']/input[@id='email']")).sendKeys("zhegunov.m@yandex.ru");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test_2");
        driver.findElement(By.xpath("//div[@class='col-md-4 col-md-offset-4']/input")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='col-sm-4 col-lg-3 left_nav_column']//a[text()='Выйти']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
