package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * пример автоматизации
 */
public class AutomationPractiseTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // правильно вместо 25й строки
        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10) );

        WebElement casualDressesCheckBox = driver.findElement(By.id("layered_category_9"));
        casualDressesCheckBox.click();

        //Thread.sleep(8000);  // безусловное ожидание (плохое ожидание) // 19строка

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));
        driver.findElement(By.xpath("//a[@title='Cancel']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
