package org.example.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Put good in the basket
 * https://haieronline.ru/
 * Created by Maximz1906891 2022/04
 */
public class CheckBasket {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();

        driver.get("https://haieronline.ru/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='location-confirm__buttons']/button[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='cookies-notice__container']/button")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='top-block__column-second']//div[@class='catalog-list__group']//li[1]/a[text()='Холодильники']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='catalog__item']//div[@class='add-to-basket js-add-to-basket-container  ']/button[@*='4121']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='modal__content']//a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='basket-item__meta-col']/button")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
