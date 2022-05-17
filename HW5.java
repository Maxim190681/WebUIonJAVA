package HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Tests from HW3
 * https://pitbikeclub.ru (Login: zhegunov.m@yandex.ru, Password: Test_2 )
 * https://haieronline.ru
 * Created by Maximz1906891 2022/05
 */

public class HW5 {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ждем 5 секунд, если нет - тест падает
        driver.manage().window().maximize();
    }

    @Test
    void RegistrationWithValidData() {
        driver.get("https://pitbikeclub.ru");
        driver.findElement(By.xpath("//div//span[text()='Войти']")).click();

        // //input[@id='email']
        // проверяем появился ли элемент
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

        driver.findElement(By.xpath("//div[@class ='col-md-4']/input[@id='email']")).sendKeys("zhegunov.m@yandex.ru");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test_2");
        driver.findElement(By.xpath("//div[@class='col-md-4 col-md-offset-4']/input")).click();

        // //h1[@class='static_h1']
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='static_h1']")));

        // проверяем появился ли элемент
        Assertions.assertEquals(driver.findElement(By.xpath("//h1[@class='static_h1']")).isDisplayed(), true);

        driver.findElement(By.xpath("//div[@class='col-sm-4 col-lg-3 left_nav_column']//a[text()='Выйти']")).click();
    }

    @Test
    void AddGoodInBasketCheckByElement() throws InterruptedException {
        driver.get("https://haieronline.ru/");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='location-confirm__buttons']/button[2]")));
        driver.findElement(By.xpath("//div[@class='location-confirm__buttons']/button[2]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='cookies-notice__button js-cookies-notice-button']")));
        driver.findElement(By.xpath("//button[@class='cookies-notice__button js-cookies-notice-button']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//main/section//div[@class='catalog-list__group']/a[text()='Крупная бытовая техника']")));
        driver.findElement(By.xpath("//main/section//div[@class='catalog-list__group']/a[text()='Крупная бытовая техника']")).click();

        driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']//div[text()='Холодильники']")).click();
        driver.findElement(By.xpath("//div[@class='catalog__item']//div[@class='add-to-basket js-add-to-basket-container  ']/button[@*='4121']")).click();

        // //div[@class='tingle-modal modal modal--small modal--basket tingle-modal--visible']//div[@class='tingle-modal-box__content']

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Товар добавлен в корзину!']")));
        driver.findElement(By.xpath("//div[@class='modal__content']//a")).click();

        Assertions.assertEquals(driver.findElement(By.xpath("//span[@class='cart__count js-cart-count']")).isDisplayed(), true);

        driver.findElement(By.xpath("//div[@class='basket-item__meta-col']/button")).click();
        Thread.sleep(5000);
    }

    @Test
    void AddGoodInBasketcheckByURLcontains() throws InterruptedException {
        driver.get("https://haieronline.ru/");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='location-confirm__buttons']/button[2]")));
        driver.findElement(By.xpath("//div[@class='location-confirm__buttons']/button[2]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='cookies-notice__button js-cookies-notice-button']")));
        driver.findElement(By.xpath("//button[@class='cookies-notice__button js-cookies-notice-button']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main/section//div[@class='catalog-list__group']/a[text()='Крупная бытовая техника']")));
        driver.findElement(By.xpath("//main/section//div[@class='catalog-list__group']/a[text()='Крупная бытовая техника']")).click();

        driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']//div[text()='Холодильники']")).click();
        driver.findElement(By.xpath("//div[@class='catalog__item']//div[@class='add-to-basket js-add-to-basket-container  ']/button[@*='4121']")).click();

        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal__content']//a")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Товар добавлен в корзину!']")));
        driver.findElement(By.xpath("//div[@class='modal__content']//a")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("cart"));

        driver.findElement(By.xpath("//div[@class='basket-item__meta-col']/button")).click();
        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {  // закрывает браузер, даже если тест упал
        driver.quit();
    }
}
