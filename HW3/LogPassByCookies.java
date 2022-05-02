package org.example.HW3;
/**
 *
 *  Registration with valid data
 *  By Cookies
 *  https://pitbikeclub.ru/
 *  Login: zhegunov.m@yandex.ru
 *  Password: Test_2
 *  Created by Maximz1906891 2022/04
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogPassByCookies {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://pitbikeclub.ru/lk/");
        Cookie cookie =new Cookie("PHPSESSID_pitbikes", "vc4ktpkdgopou2d05bk624sqss");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.quit();
    }
}
