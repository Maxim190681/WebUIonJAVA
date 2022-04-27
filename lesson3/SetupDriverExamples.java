package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();  // запуск драйвера

        ChromeOptions chromeOptions = new ChromeOptions(); // создаем  экземпляр драйвера
        chromeOptions.addArguments("--disable-notifications"); // блокировка всех нотификаций
        //chromeOptions.addArguments("--headless");   // запуск  браузера без интерфейса
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com/");  //открыть страницу браузера

        driver.manage().window().setSize(new Dimension(300,700));
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB); // открыть новую вкладку

        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); // в массив получаем дескрипторы -
                                                                        // уникальное имя вкладки
        driver.switchTo().window(tabs.get(1)); // переход в след вкладку, нумерация массива NB
        driver.get("https://ya.ru/");

        Thread.sleep(5000);
        driver.close(); // закрыть вкладку
        Thread.sleep(5000);

        driver.switchTo().window(tabs.get(0));
                            // управляем вкладкой через JS
        ((JavascriptExecutor)driver).executeScript("window.open('https://ya.ru/','_blank').focus();");

        Thread.sleep(500);
        driver.quit();
    }
}
